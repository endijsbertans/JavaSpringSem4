package lv.venta.service;
import java.util.ArrayList;

import lv.venta.Product;
public interface IFilterProductService {
	public abstract ArrayList<Product>
	filterProductByPriceTreshold(float priceTreshold) throws Exception;
	
	public abstract ArrayList<Product>
	filterProductByQuantityTreshold(int quantityTreshold) throws Exception;
	
	public abstract ArrayList<Product>
	filterByTitleOrDescription(String searchText) throws Exception;
	
	
}
