package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.Product;

public interface IProductRepo extends CrudRepository<Product, Integer>{

}
