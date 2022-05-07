package products;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class Product {
	
	private String id;
	private String description;
    private float price;
    
    public Product(String id, String description, float price) {
		this.id = id;
		this.description =description;
		this.price = price;
	}
}
