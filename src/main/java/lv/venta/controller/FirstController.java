package lv.venta.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lv.venta.Product;
import lv.venta.service.ICRUDProductService;
import lv.venta.service.IFilterProductService;




@Controller
public class FirstController {
	@Autowired
	private ICRUDProductService crudService;
	
	@Autowired
	private IFilterProductService filterService;
	
	@GetMapping("/hello") //localhost:8080/hello
	public String getHello() {
		System.out.println("Hello from Spring boot");
		return "hello-page"; //tiek parādīta hello-page.html lapa
	}
	
	
	@GetMapping("/hello/msg")//localhost:8080/hello/msg
	public String getHelloMsg(Model model) {
		//                  nosaukums, vērtība
		model.addAttribute("mymsg"   , "Ziņa no backend!! Hei!");
		return "msg-page"; //tiek parādīta msg-page.html lapa
	}
	
	
	@GetMapping("/product/test")//localhost:8080/product/test
	public String getProductTest(Model model) {
		try {
		model.addAttribute("zemene", crudService.retrieveAll().get(0));
		return "product-page-3"; //tiek parādīta show-product-page.html lapa
		}catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
	}
	
	//get mapping funkciju, kura pados sarakstu no vismaz 3 produktiem
	//html kods, kas so sarakstu avr parādīt
	
	@GetMapping("/product/all")//localhost:8080/product/all
	public String getProductAll(Model model) {
		try {
		model.addAttribute("myobjs", crudService.retrieveAll());
		return "product-page"; //tiek parādīta show-product-all-page.html lapa
		}catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/productone")
	public String getMethodName(@RequestParam("id")int id, Model model) {
			try {
				model.addAttribute("zemene", crudService.retrieveById(id));
				return "product-page-3"; 
			}catch (Exception e) {
				model.addAttribute("msg", e.getMessage());
				return "error-page";
			}
		}
	@GetMapping("/product/all/{id}")//localhost:8080/product/all/2
	public String getProductAllId(@PathVariable("id") int id, Model model) {
		try {
			model.addAttribute("zemene", crudService.retrieveById(id));
			return "product-page-3"; 
		}catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
}
	@GetMapping("/product/insert")//localhost:8080/product/insert
	public String getProductInsert(Model model) {
		model.addAttribute("product", new Product());
		return "insert-product-page";
	}
	@PostMapping("product/insert")
	public String postProductInsert(@Valid Product product, BindingResult result) {
		System.out.println(product);
		if(result.hasErrors()) {
			return "insert-product-page";
		}else {
			try {
				Product newProduct = crudService.create(product);
				return "redirect:/product/all";
			} catch (Exception e) {
				return "redirect:/error"; // p'arlec uz cit endpoint
			}
		}
	}
	@GetMapping("/error")
	public String getError() {
		return "error-page";
	}
	
}