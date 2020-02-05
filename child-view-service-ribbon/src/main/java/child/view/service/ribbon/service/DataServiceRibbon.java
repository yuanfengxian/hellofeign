package child.view.service.ribbon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import child.view.service.ribbon.client.ProductRibbonClient;
import child.view.service.ribbon.pojo.Product;

@Service
public class DataServiceRibbon {
	@Autowired
	private ProductRibbonClient prc;
	public List<Product> getProducts() {
		return prc.getProducts();
	}
}
