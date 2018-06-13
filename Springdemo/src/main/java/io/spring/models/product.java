package io.spring.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class product implements Serializable {
	@Id @GeneratedValue
	private long id;
	@NotNull
	@Size(min=4,max=20)
	private String lable;
	@DecimalMin("100")
	private int price;

	private int quantity ;
	
	
	 
	public product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public product( String lable, int price, int quantity) {
		super();
		this.lable = lable;
		this.price = price;
		this.quantity = quantity;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLable() {
		return lable;
	}
	public void setLable(String lable) {
		this.lable = lable;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
