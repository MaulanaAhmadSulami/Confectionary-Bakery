package main;

import java.util.ArrayList;
import java.util.Scanner;

import adapter.PricetoCashAdapter;
import adapter.PricetoCryptoAdapter;
import adapter.PricetoTransferAdapter;
import database.DatabaseManager;
import factory.ConfectionaryFactory;
import model.Confectionary;
import payment.Cash;
import payment.Crypto;
import payment.Transfer;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static DatabaseManager db = new DatabaseManager();
	
	public static void menu() {
		System.out.println("Nom Nom Co.");
		System.out.println("============");
		System.out.println("1. Bake Confectionary");
		System.out.println("2. View Confectionary Order");
		System.out.println("3. Exit");
		System.out.println(">>");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opt;
		
		do {
			menu();
			opt = sc.nextInt();
			sc.nextLine();
			switch (opt) {
			case 1:
				//type
				String tempType, tempName, tempSoftness, tempPayment;
				float tempPrice;
				ArrayList<String> tempToppings = new ArrayList<String>();
				
				//for type
				do {
					System.out.println("Input confectionary type [Cupcake | Tart] [Case sensitive]:");
					tempType = sc.nextLine();
				} while (!tempType.equals("Cupcake") && !tempType.equals("Tart"));
				
				// for name
				do {
					System.out.println("Input confectionary name [length between 5-15]:");
					tempName = sc.nextLine();
				}while(!(tempName.length() >= 5) || !(tempName.length() <= 15));
				
				// for softness
				do {
					System.out.println("Input confectionary softness [Fluffy | Medium | Hard] [Case sensitive]: ");
					tempSoftness = sc.nextLine();
				}while(!tempSoftness.equals("Fluffy") && !tempSoftness.equals("Medium") && !tempSoftness.equals("Hard"));
				
				// for topping
				
					System.out.println("Adding additional topping [Y | N] [Case sensitive]");
					String ans = "N";
					do {
						ans = sc.nextLine();
						if(ans.equals("Y")) {
							for(int i = 0; i < 3; i++) {
								String tempTopping;
								do {
									System.out.println("Input Topping "+ (i + 1) + "[Length between 1-10]");
									tempTopping = sc.nextLine();
								} while (tempTopping.length() < 1 || tempTopping.length() > 10);
								tempToppings.add(tempTopping);
							}
							}else {
								break;
						}
					} while (!ans.equals("N") && !ans.equals("Y"));

				// for Price
					
					do {
						System.out.println("Input confectionary price [10.0 - 50.0]: ");
						tempPrice = sc.nextFloat();
						sc.nextLine();
					} while (tempPrice < 10.0 || tempPrice > 50.0);
					
					
				// for Payment
					
					do {
						System.out.println("What kind of payment [Cash | Transfer | Crypto ] [Case sensitive]");
						tempPayment = sc.nextLine();
					} while (!tempPayment.equals("Cash") && !tempPayment.equals("Transfer") && !tempPayment.equals("Crypto"));
					
					if(tempPayment.equals("Cash")) {
						Cash cash = new Cash(tempPrice);
						Confectionary confectionary = ConfectionaryFactory.createConfectionary(tempName, tempType, tempSoftness, tempToppings, new PricetoCashAdapter(cash), tempPayment);
						db.addConfectionary(confectionary);
					}else if(tempPayment.equals("Transfer")) {
						Transfer transfer = new Transfer(tempPrice);
						Confectionary confectionary = ConfectionaryFactory.createConfectionary(tempName, tempType, tempSoftness, tempToppings, new PricetoTransferAdapter(transfer), tempPayment);
						db.addConfectionary(confectionary);
					}else if(tempPayment.equals("Crypto")) {
						Crypto crypto = new Crypto(tempPrice);
						Confectionary confectionary = ConfectionaryFactory.createConfectionary(tempName, tempType, tempSoftness, tempToppings, new PricetoCryptoAdapter(crypto), tempPayment);
						db.addConfectionary(confectionary);
					}
					
					System.out.println("Confectionary Baked!");
					System.out.println("Press enter to continue....");
					sc.nextLine();
				break;
			
			case 2:
				ArrayList<Confectionary> ConfList = db.getAllConfectionary();
				
				if(ConfList.size() != 0) {
					for(Confectionary conv : ConfList) {
						System.out.println("====================================================");
						System.out.println("Name        : " + conv.getName() + " ("+ conv.getType()+ ") ");
						System.out.println("Softness    : " + conv.getSoftness());
						System.out.println("Topping     : " + conv.getToppings());
						System.out.println("PaymentType : " + conv.getPaymentType());
						System.out.println("Price       : " + conv.getPrice().getAmount());
						System.out.println("====================================================");
						
					}
				}
				break;
				
			default:
				break;
			}
			
		} while (opt != 3);
		System.out.println("Thank you for using nomnom service.");
	}

}
