package onlineStore.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onlineStore.model.Product;
import onlineStore.service.ProductService;

@RequestMapping("/api/v1/product")
@RestController
public class ProductController {
	
	private final ProductService service;
	
	public ProductController(ProductService service) {
		this.service = service;
	}
	
	@PostMapping
	public void addProduct(@Valid @NonNull @RequestBody Product product) {
		service.addProduct(product);
	}
	
	@GetMapping(path = "{ID}")
	public Product getProductById(@PathVariable("ID") UUID ID) {
		return service.getProductByID(ID)
				.orElse(null);
	}
	
	@GetMapping(path = "{name}")
	public Product getProductByName(@PathVariable("name") String name) {
		return service.getProductByName(name)
				.orElse(null);
	}
	
	@GetMapping(path = "{productTypeID}")
	public Product getProductByProductTypeID(@PathVariable("ID") UUID ID) {
		return service.getProductByProductTypeID(ID)
				.orElse(null);
	}
	
	@DeleteMapping(path = "{ID}")
	public void deleteProductById(@PathVariable("ID") UUID ID) {
		service.deleteProduct(ID);
	}
	
	@PutMapping(path = "{ID}")
	public void updateProduct(@PathVariable("ID") UUID ID, @Valid @NonNull @RequestBody Product product) {
		service.updateProduct(ID, product);
	}

}
