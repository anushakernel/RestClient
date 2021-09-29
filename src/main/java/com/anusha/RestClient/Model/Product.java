package com.anusha.RestClient.Model;

public class Product {
	private String id;
	private String name;
	private String price;
	private String dept;
	
	public Product() {
		
	}
	
	public Product(String id,String name,String price,String dept){
		this.id = id;
		this.name = name;
		this.price = price;
		this.dept = dept;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
	
	public void setPrice(String price){
		this.price = price;
	}
	public String getPrice(){
		return price;
	}
	public void setDept(String dept){
		this.dept = dept;
	}
	public String getDept(){
		return dept;
	}
}
