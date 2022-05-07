package products.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import products.data.ProductRepository;
import products.Product;

@Slf4j
@Controller
@RequestMapping("/display")
public class DisplayProduct {
	private ProductRepository productRepo;
	
	@Autowired
	public DisplayProduct(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
	@ModelAttribute
	public void addProductsToModel(Model model) {
		List<Product> products = new ArrayList<>();
		productRepo.findAll().forEach(products::add);
	}
	
	@GetMapping
	public String showDesignForm(Model model) {
		model.addAttribute("taco", new Taco());
		return "display";
	}
}
