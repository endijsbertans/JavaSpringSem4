package lv.venta.service;

import java.util.ArrayList;

import lv.venta.Product;

public interface ICRUDProductService {
	public abstract Product create(Product product)throws Exception;
	public abstract ArrayList<Product> retrieveAll()throws Exception;
	public abstract Product retrieveById(int id) throws Exception;
	public abstract void updateById(int id, Product product)throws Exception;
	public abstract Product deleteById(int id) throws Exception;
}
