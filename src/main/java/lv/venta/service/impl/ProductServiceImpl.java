package lv.venta.service.impl;

import java.util.ArrayList;

import lv.venta.repo.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.Product;
import lv.venta.service.ICRUDProductService;
import lv.venta.service.IFilterProductService;

@Service
public class ProductServiceImpl implements ICRUDProductService, IFilterProductService{

	@Autowired
	private IProductRepo productRepo;

	@Override
	public Product create(Product product) throws Exception {
		if(product == null) throw new Exception("Product is null");


		Product productFromDB =
				productRepo.findByTitleAndDescriptionAndPrice(product.getTitle(),
						product.getDescription(), product.getPrice());

		//noskaidrojam, vai tads jau eksistē
		if(productFromDB != null) {
			productFromDB.setQuantity
					(productFromDB.getQuantity() + product.getQuantity());
			productRepo.save(productFromDB);
			return productFromDB;
		}

		Product storedProduct = productRepo.save(product);
		return storedProduct;
	}

	@Override
	public ArrayList<Product> retrieveAll() throws Exception {
		if(productRepo.count() == 0) throw new Exception("Product table is empty");
		return (ArrayList<Product>) productRepo.findAll();
	}

	@Override
	public Product retrieveById(int id) throws Exception {
		if(id < 0) throw new Exception("Id should be positive");

		if(productRepo.existsById(id))
		{
			return productRepo.findById(id).get();
		}

		throw new Exception("Product with " + id + " is not found");
	}

	@Override
	public void updateById(int id, Product product) throws Exception {
		Product updateProduct = retrieveById(id);

		updateProduct.setTitle(product.getTitle());
		updateProduct.setDescription(product.getDescription());
		updateProduct.setQuantity(product.getQuantity());
		updateProduct.setPrice(product.getPrice());
		productRepo.save(updateProduct);//notiek Update arī DB līmenī

	}

	@Override
	public Product deleteById(int id) throws Exception {
		Product deleteProduct = retrieveById(id);
		productRepo.delete(deleteProduct);
		return deleteProduct;
	}



	@Override
	public ArrayList<Product> filterByTitleOrDescription(String searchText) throws Exception {
		if(searchText == null) throw new Exception("Wrong search text");
		ArrayList<Product> filteredProducts =
				productRepo.findByTitleIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(searchText, searchText);

		return filteredProducts;
	}

	@Override
	public float calculateProductsTotalValue() throws Exception {
		if(productRepo.count()==0) throw new Exception("There is no product in my web");

		float result = productRepo.calculateTotalValueOfDBProducts();
		return result;
	}

	@Override
	public ArrayList<Product> filterProductByPriceThreshold(float priceThreshold) throws Exception {
		if(priceThreshold < 0 || priceThreshold > 10000) throw new Exception("Wrong price threshold");
		return productRepo.findByPriceLessThanEqual(priceThreshold);
	}

	@Override
	public ArrayList<Product> filterProductByQuantityThreshold(int quantityThreshold) throws Exception {
		if(quantityThreshold < 0 || quantityThreshold > 100) throw new Exception("Wrong quantity threshold");
		return productRepo.findByQuantityLessThanEqual(quantityThreshold);
	}
}