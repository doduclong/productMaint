package products.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import products.data.ProductRepository;
import products.Product;

@Slf4j
@RestController
//@RequestMapping("/display")
public class DisplayProduct {
	private ProductRepository productRepo;
	
//	@Autowired
//	public DisplayProduct(ProductRepository productRepo) {
//		this.productRepo = productRepo;
//	}
	
	@ModelAttribute
	public void addProductsToModel(Model model) {
		List<Product> products = new ArrayList<>();
		productRepo.findAll().forEach(products::add);
	}
	
	@GetMapping("/products")
	public String products_index() {
		return "products";
	}

}
