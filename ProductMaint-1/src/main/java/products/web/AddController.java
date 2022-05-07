package products.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import products.data.ProductRepository;
import products.Product;

@Slf4j
@Controller
@RequestMapping("/product")
public class AddController {
	private ProductRepository productRepo;

	@Autowired
	public AddController(ProductRepository productRepo) {

		this.productRepo = productRepo;
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("product", new Product(null, null, 0));
		return "addProduct";
	}
	
	@PostMapping
	public String addProduct(Product product, Model model) {
		productRepo.save(product);
		model.addAttribute(product);
		log.info("Product saved: " + product);
		return "home";
	}
}
