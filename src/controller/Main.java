package controller;
import java.io.*;
import java.sql.SQLException;

import dao.LoginDAO;
import dao.ProductDAO;
import model.Login;
import model.Product;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Login login = new Login();
		Product product=new Product();
		LoginDAO logindao = new LoginDAO();
		ProductDAO productdao = new ProductDAO();
		int option;
		do
		{
			System.out.println("1.Admin");
			System.out.println("2.Agent");
			System.out.println("3.Exit");
			System.out.println("_____________________________________________________");
			option = Integer.parseInt(br.readLine());
			
			switch(option)
			{
			case 1: 
			{
			System.out.println("________________________________________________");
			System.out.println("Enter username");
			String username = br.readLine();
			System.out.println("Enter password");
			String password = br.readLine();
			login.setUSERNAME(username);
			login.setPASSWORD(password);
			boolean result = logindao.validate(login);
			if(result==true)
			{
				System.out.println("Login Successful");
				System.out.println("_____________________________________________________");
				do
				{
				System.out.println("1.Add Product");
				System.out.println("2.Display Inventory Details");
				System.out.println("3.Logout");
				System.out.println("_____________________________________________________");
				option = Integer.parseInt(br.readLine());
				switch(option)
				{
				case 1:{
					System.out.println("Enter username");
					String productName = br.readLine();
					System.out.println("Enter product id");
					int productId = Integer.parseInt(br.readLine());
					System.out.println("Enter the min selling quantity");
					int minsell = Integer.parseInt(br.readLine());
					System.out.println("Enter the price of the peoduct");
					int price = Integer.parseInt(br.readLine());
					System.out.println("Enter the quantity");
					int quantity = Integer.parseInt(br.readLine());
					product.setPRODUCTNAME(productName);
					product.setPRODUCTID(productId);
					product.setMINSELL(minsell);
					product.setQUANTITY(quantity);
					product.setPRICE(price);
					productdao.addProduct(product);
					System.out.println("________________________________________________");
				}
				case 2:{
					productdao.display();break;
				}
				case 3: break;
				}
				}
				while(option !=3);
			}
			else
			{
				System.out.println("Username & password incorrect");
			}
			}
			break;
			case 2: System.out.println("__________________________________________________________");
			System.out.println("Enter the username: ");
			String name = br.readLine();
			System.out.println("Enter the password: ");
			String pass = br.readLine();
			login.setUSERNAME(name);
			login.setPASSWORD(pass);
			if(logindao.validate(login))
			{
				System.out.println("__________________________________________________________");
				System.out.println("Login Successful");
				
				do
				{
					System.out.println("__________________________________________________________");
					System.out.println("1.Buy");
					System.out.println("2.Sell");
					System.out.println("3.Show History");
					System.out.println("4.Logout");
					System.out.println("__________________________________________________________");
					option = Integer.parseInt(br.readLine());
					switch(option)
					{
					case 1: System.out.println("Buy");
					
					
						System.out.println("Enter the product id: ");
						int productId = Integer.parseInt(br.readLine());
						System.out.println("Enter the product name: ");
						String productname = br.readLine();
						System.out.println("Enter the min selling quantity: ");
						int minsell = Integer.parseInt(br.readLine());
						System.out.println("Enter the product price: ");
						int price = Integer.parseInt(br.readLine());
						System.out.println("Enter the product quantity: ");
						int quantity = Integer.parseInt(br.readLine());
						product.setPRODUCTNAME(productname);
						product.setPRODUCTID(productId);
						product.setMINSELL(minsell);
						product.setPRICE(price);
						product.setQUANTITY(quantity);
						
						productdao.addProduct(product);
						System.out.println("__________________________________________________________");
						
					
					case 2:
						System.out.println("__________________________________________________________");
						System.out.println("Enter the product id: ");
						int productId1 = Integer.parseInt(br.readLine());
						System.out.println("Enter the product quantity: ");
						int quantity1 = Integer.parseInt(br.readLine());
						if(productdao.availableOfQuantity(productId1, quantity1))
						{
							int total = productdao.totalAmount(productId1, quantity1);
							System.out.println("__________________________________________________________");
							System.out.println("Total cost is "+total);
							System.out.println("__________________________________________________________");
							System.out.println("Confirm Booking(Yes/No)");
							String booking = br.readLine();
							System.out.println("__________________________________________________________");
							
						}
					case 3: break;
					}
				}while(option!=3);
			}
			else
			{
				System.out.println("Username & password incorrect");
			}
			}
			break;
		}while(option!=3);
		
}
}
