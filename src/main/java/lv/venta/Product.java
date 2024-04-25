package lv.venta;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
//@AllArgsConstructor
@Table(name = "ProductTable")
@Entity
public class Product {
	@Column(name = "Id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	
	private static int counter = 0;
	
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z ]+")
	@Size(min = 3, max = 20)
	@Column(name = "Title")
	private String title;
	
	@NotNull
	@Pattern(regexp = "[A-Za-z]+")
	@Size(min = 4, max = 200)
	@Column(name = "Description")
	private String description;
	
	@Min(0)
	@Max(10000)
	@Column(name = "Price")
	private float price;
	
	@Min(0)
	@Max(100)
	@Column(name = "Quantity")
	private int quantity;
	
	public void setId() {
		this.id = counter;
		counter++;
	}

	public Product(String title, String description, float price, int quantity) {
		setId();
		setTitle(title);
		setDescription(description);
		setPrice(price);
		setQuantity(quantity);
		
	}

}