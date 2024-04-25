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
import lv.venta.service.ICRUDProductService;
import lv.venta.service.IFilterProductService;

@Controller
public class FirstController {

	@Autowired
	private ICRUDProductService crudService;


	@GetMapping("/hello") // localhost:8080/hello
	public String getHello() {
		System.out.println("Hello from Spring boot");
		return "hello-page"; // tiek parādīta hello-page.html lapa
	}

	@GetMapping("/hello/msg") // localhost:8080/hello/msg
	public String getHelloMsg(Model model) {
		// nosaukums, vērtība
		model.addAttribute("mymsg", "Ziņa no backend!! Hei!");
		return "msg-page"; // tiek parādīta msg-page.html lapa
	}

	@GetMapping("/product/test") // localhost:8080/product/test
	public String getProductTest(Model model) {
		try {
			model.addAttribute("myobj", crudService.retrieveAll().get(0));
			return "product-page"; // tiek parādīta show-product-page.html lapa
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page"; // tiek parādīta error-page.html lapa
		}

	}

	// get mapping funkciju, kura pados sarakstu no vismaz 3 produktiem
	// html kods, kas so sarakstu avr parādīt

	@GetMapping("/error") // localhost:8080/error
	public String getError() {
		return "error-page";
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}