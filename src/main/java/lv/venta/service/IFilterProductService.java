package lv.venta.service;
import java.util.ArrayList;

import lv.venta.Product;
import org.springframework.data.jpa.repository.Query;

public interface IFilterProductService {

	ArrayList<Product> filterByTitleOrDescription(String searchText) throws Exception;

	float calculateProductsTotalValue() throws Exception;


	ArrayList<Product> filterProductByPriceThreshold(float priceThreshold) throws Exception;

	ArrayList<Product> filterProductByQuantityThreshold(int quantityThreshold) throws Exception;
}
