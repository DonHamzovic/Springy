 package io.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import io.spring.dao.ProductRepository;
import io.spring.models.product;

@SpringBootApplication
public class SpringdemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =	SpringApplication.run(SpringdemoApplication.class, args);
		
	//SpringApplication.run(SpringdemoApplication.class, args);
		
		ProductRepository productRepository =ctx.getBean(ProductRepository.class);
		productRepository.save(new product("ASUS ROG",650,2000));
		
		productRepository.findAll().forEach(p->System.out.println("ID: "+p.getId()+"Lable: "+p.getLable()));
		
		
		 
		
		
	}
}
