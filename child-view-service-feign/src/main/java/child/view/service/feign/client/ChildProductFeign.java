package child.view.service.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import child.view.service.feign.pojo.Product;

@FeignClient(value="CHILD-DATA-SERVICE")
public interface ChildProductFeign {
	@GetMapping("/products")
	public List<Product> getProducts();
}
