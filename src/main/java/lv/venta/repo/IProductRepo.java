package lv.venta.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.Product;

import java.util.ArrayList;

public interface IProductRepo extends CrudRepository<Product, Integer>{

    Product findByTitleAndDescriptionAndPrice(String title, String description, float price);

    ArrayList<Product> findByPriceLessThanEqual(float priceThreshold);

    ArrayList<Product> findByQuantityLessThanEqual(int quantityThreshold);

    ArrayList<Product> findByTitleIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(String searchText, String searchText1);
    @Query(nativeQuery = true, value = "SELECT SUM(PRICE * QUANTITY) FROM PRODUCT_TABLE")

    float calculateTotalValueOfDBProducts();
}
