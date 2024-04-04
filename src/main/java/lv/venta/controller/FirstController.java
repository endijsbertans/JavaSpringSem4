package lv.venta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
	
	@GetMapping("/hello")
	public String getHello() {
		System.out.println("Hello from spring!");
		return "hello-page";
	}
	
}
