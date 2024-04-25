package lv.venta;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.repo.IProductRepo;

@SpringBootApplication
public class JavaSpringSem4Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringSem4Application.class, args);
	}
	@Bean
	public CommandLineRunner testDatabaseLayer(IProductRepo productRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				ArrayList<Product> allProducts = new ArrayList<>(Arrays.asList(new Product("Abols", "Sarkans", 0.99f, 5),new Product("Zemene", "Salda", 1.23f, 3),new Product("Arbuzs", "Roza", 3.99f, 2)));
				productRepo.saveAll(allProducts);
			}
		};
	}
}
