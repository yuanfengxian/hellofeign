package child.view.service.ribbon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import child.view.service.ribbon.pojo.Product;
import child.view.service.ribbon.service.DataServiceRibbon;

@Controller
public class ChildRibbonController {
	 @Autowired DataServiceRibbon productService;
     
	    @RequestMapping("/products")
	    public Object products(Model m) {
	        List<Product> ps = productService.getProducts();
	        m.addAttribute("ps", ps);
	        return "products";
	    }

}
