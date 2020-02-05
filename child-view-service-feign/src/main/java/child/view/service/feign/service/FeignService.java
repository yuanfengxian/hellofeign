package child.view.service.feign.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import child.view.service.feign.client.ChildProductFeign;
import child.view.service.feign.pojo.Product;

@Service
public class FeignService {
	@Autowired
	private ChildProductFeign cpf;
	public List<Product> getProducts() {
		return cpf.getProducts();
	}

}
