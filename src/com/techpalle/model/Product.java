package com.techpalle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_id;
	@Column(nullable = false)
	private String product_name;
	@Column(unique = true, nullable = false)
	private int sku_code;
	@Column(unique = true, nullable = false)
	private String batch_number;
	@Column(nullable = false)
	private String price;
	
	public int getProduct_id() 
	{
		return product_id;
	}
	public void setProduct_id(int product_id) 
	{
		this.product_id = product_id;
	}
	public String getProduct_name() 
	{
		return product_name;
	}
	public void setProduct_name(String product_name) 
	{
		this.product_name = product_name;
	}
	public int getSku_code() 
	{
		return sku_code;
	}
	public void setSku_code(int sku_code) 
	{
		this.sku_code = sku_code;
	}
	public String getBatch_number() 
	{
		return batch_number;
	}
	public void setBatch_number(String batch_number) 
	{
		this.batch_number = batch_number;
	}
	public String getPrice() 
	{
		return price;
	}
	public void setPrice(String price) 
	{
		this.price = price;
	}
	
	public Product() 
	{
		super();
	}
	public Product(String product_name, int sku_code, String batch_number, String price) 
	{
		super();
		this.product_name = product_name;
		this.sku_code = sku_code;
		this.batch_number = batch_number;
		this.price = price;
	}
	public Product(int product_id, String product_name, int sku_code, String batch_number, String price) 
	{
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.sku_code = sku_code;
		this.batch_number = batch_number;
		this.price = price;
	}
}
