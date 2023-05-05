package com.techpalle.controller;

import java.util.Scanner;

import com.techpalle.dao.ProductDAO;

public class ProductMainClass 
{
	private static void showMenu()
    {
        System.out.println("press 1: create product table");
        System.out.println("press 2: insert data into the table");
        System.out.println("press 3: show all student records");
        System.out.println("press 4: update data of the table");
        System.out.println("press 5: delete record from the table");
        System.out.println("press 6: exit from the program");
    }
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		showMenu();
		do 
		{
			menu = sc.nextInt();
			switch (menu)
			{
			case 1:
				ProductDAO.createTable();
				System.out.println("table created");
				break;
			case 2:
				ProductDAO.insertProductDetails();
				System.out.println("record inserted");
				break;
			case 3:
				ProductDAO.showAllProducts();
				System.out.println("all product records");
				break;
			case 4:
				ProductDAO.updateProduct();
				System.out.println("record updated");
				break;
			case 5:
				ProductDAO.deleteProduct();
				System.out.println("record deleted");
				break;
			case 6:
				System.out.println("enter 6 again to exit from program");
				int ext = sc.nextInt();
				System.out.println("program exited successfully");
				System.exit(ext);
				break;
			default:
				System.out.println("invalid input");
				break;
			}
		} 
		while (menu != 6);
	}
}
