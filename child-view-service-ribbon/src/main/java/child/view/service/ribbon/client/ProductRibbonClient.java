package child.view.service.ribbon.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import child.view.service.ribbon.pojo.Product;

@Component
public class ProductRibbonClient {
	@Autowired
	RestTemplate resttemplate;
	
	public List<Product> getProducts(){
		return resttemplate.getForObject("http://CHILD-DATA-SERVICE/products", List.class);
	}

}
