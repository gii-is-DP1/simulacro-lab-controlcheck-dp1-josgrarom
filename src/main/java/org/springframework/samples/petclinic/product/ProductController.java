package org.springframework.samples.petclinic.product;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    
	@Autowired
	private ProductService ps;
	
	@GetMapping(path = "/product/create")
	public String initCreationForm(ModelMap modelMap) {
		Product product = new Product();
		modelMap.addAttribute("product", product);
		modelMap.addAttribute("productType", ps.findAllProductTypes());
		return "products/createOrUpdateProductForm";
	}

	@PostMapping(path = "/product/create")
	public String processCreationForm(@Valid Product product, BindingResult result, ModelMap modelMap) {
		if (result.hasErrors()) {
			modelMap.addAttribute("productType", ps.findAllProductTypes());
			return "products/createOrUpdateProductForm";
		}
		
		else {

			ps.save(product);
			modelMap.addAttribute("message", "Guardado con éxito");
			return "welcome";
		}
	
}
}
