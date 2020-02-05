package child.view.service.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import child.view.service.feign.service.FeignService;

@Controller
@RefreshScope
public class FeignController {
	@Autowired
	private FeignService feignService;
	@Value("${version}")
	String version;
	
	@RequestMapping("/products")
	public Object getProducts(Model m) {
		m.addAttribute("ps", feignService.getProducts());
		m.addAttribute("version", version);
		return "products";
	}

}
