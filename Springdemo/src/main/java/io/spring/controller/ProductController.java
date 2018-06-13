package io.spring.controller;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.spring.dao.ProductRepository;
import io.spring.models.product;
 
@Controller
public class ProductController  {
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value ="/index")
	public String index(Model model,@RequestParam(name="page",defaultValue="0")int p,
									@RequestParam(name="size",defaultValue="10")int s,
									@RequestParam(name="key" ,defaultValue="")String key) {
		
	    Page<product> PageProduct = productRepository.search("%"+key+"%", new PageRequest(p, s));
	    model.addAttribute("ListProduct", PageProduct.getContent());
		int[] pages=new int[PageProduct.getTotalPages()];
	    
	    model.addAttribute("pages",pages);
	    model.addAttribute("size",s);
	    model.addAttribute("currentpage",p);
	    model.addAttribute("key",key);
		
		return "index";
		
	}
	
	@RequestMapping(value ="/delete")
	public String delete(Long id,int size,int page,String key) {
		
		productRepository.deleteById(id);
		
		return "redirect:/index?page="+page+"&size="+size+"&key="+key;
	
	}
	
	@RequestMapping("/addProduct")
	public String form(Model model) {
		model.addAttribute("product" , new product());
		return "form";
		
	}
	
	@RequestMapping("/edit")
	public String update(Model model,long id) {
		
		product prod = productRepository.getOne(id);
	     
	  System.out.println(prod.toString());
	  
		model.addAttribute("product" ,  prod);
		
		return "edit";
		
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(Model model, @Valid product prod ,BindingResult bindingresult) {
		
		if(bindingresult.hasErrors()) 
			return"form";
		
		System.err.println(prod.getId() +"   SAVE   "+prod.getLable());
		
		productRepository.save(prod);
		
		return "confirm";
		
	}
	
	 
	
}
