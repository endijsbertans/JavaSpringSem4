package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.venta.Product;



@Controller
public class FirstController {
	
	@GetMapping("/hello")
	public String getHello() {
		System.out.println("Hello from spring!");
		return "hello-page";
	}
	@GetMapping("/hello/msg")
	public String getMethodName(Model model) {
		model.addAttribute("mymsg", "Cavinaa pasaulit <3");
		return "msg-page";
	}
	@GetMapping("/product/test")
	public String getProductTest(Model model) {
		Product myProduct = new Product("Zemene", "garda", 0.99f, 5);
		model.addAttribute("zemene", myProduct);
		return "product-page";
	}
	
	@GetMapping("/products/")
	public String getProduct(Model model) {
		ArrayList<Product> allProducts = new ArrayList<Product>();
		Product myProduct = new Product("Zemene", "garda", 0.99f, 5);
		allProducts.add(myProduct);
		
		Product myProduct2 = new Product("Abols", "Sarkans", 1.99f, 3);
		allProducts.add(myProduct2);
		
		Product myProduct3 = new Product("Kakis", "melns", 5.99f, 1);
		allProducts.add(myProduct3);
		
		model.addAttribute("products", allProducts);
		return "product-page-3";
	}
}
