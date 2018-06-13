package io.spring.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import io.spring.models.product;

public interface ProductRepository  extends JpaRepository<product, Long> {
	
	
	@Query("select p from product p where p.lable like :x")
	
	public Page<product> search (@Param("x") String key,Pageable pageable);
	
	
}
	