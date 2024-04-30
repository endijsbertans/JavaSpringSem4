package lv.venta.service;
import java.util.ArrayList;

import lv.venta.Product;
public interface IFilterProductService {

	public abstract ArrayList<Product>
	filterProductByPriceThreshold(float priceThreshold) throws Exception;

	public abstract ArrayList<Product>
	filterProductByQuantityThreshold(int quantityThreshold) throws Exception;

	public abstract ArrayList<Product>
	filterByTitleOrDescription(String searchText) throws Exception;

	public abstract float
	calculateProductsTotalValue() throws Exception;

}
