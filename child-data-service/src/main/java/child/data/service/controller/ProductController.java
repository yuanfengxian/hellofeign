package child.data.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import child.data.service.service.ProductService;
@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	@RequestMapping("/products")
	public Object getProducts() {
		
		return productService.listProducts();
	}

}
