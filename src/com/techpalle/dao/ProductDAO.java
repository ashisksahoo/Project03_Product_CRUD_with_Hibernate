package com.techpalle.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.techpalle.model.Product;

public class ProductDAO 
{
	private static SessionFactory sesf = null;
	private static Session ses = null;
	private static Transaction tran = null;
	
	private static SessionFactory openSession()
	{
		sesf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		ses = sesf.openSession();
		tran = ses.beginTransaction();
		return sesf;
	}
	
	private static SessionFactory closeSession()
	{
		ses.close();
		sesf.close();
		return sesf;
	}
	
	public static void createTable()
	{
		openSession();
		tran.commit();
		closeSession();
	}
	
	public static void insertProductDetails()
	{
		openSession();
		Product pro1 = new Product("office table white", 357869, "S04NG8R967", "₹ 80,000");
		Product pro2 = new Product("office chair black", 951847, "R96GT7F346", "₹ 9,000");
		Product pro3 = new Product("office chair white", 846213, "Q71VD6D864", "₹ 18,000");
		Product pro4 = new Product("office table brown", 249578, "P58BF4S529", "₹ 45,000");
		Product pro5 = new Product("office white board", 764395, "N07CS3A217", "₹ 50,000");
		Product pro6 = new Product("office black board", 578964, "U92FY5G351", "₹ 30,000");
		ses.save(pro1);
		ses.save(pro2);
		ses.save(pro3);
		ses.save(pro4);
		ses.save(pro5);
		ses.save(pro6);
		tran.commit();
		closeSession();
	}
	
	public static void showAllProducts()
	{
		openSession();
		Query<Product> showproduct = ses.createQuery("from Product");
		List<Product> showlist = showproduct.list();
		for (Product prod : showlist) 
		{
			System.out.println(prod.getProduct_id()+"\t"+prod.getProduct_name()+"\t"+prod.getSku_code()+"\t"+prod.getBatch_number()+"\t"+prod.getPrice());
		}
		tran.commit();
		closeSession();
	}
	
	public static void updateProduct()
	{
		openSession();
		Product pro = ses.get(Product.class, 5);
		pro.setPrice("₹ 60,000");
		ses.update(pro);
		tran.commit();
		closeSession();
	}
	
	public static void deleteProduct()
	{
		openSession();
		Product pro = ses.get(Product.class, 6);
		ses.delete(pro);
		tran.commit();
		closeSession();
	}
}
