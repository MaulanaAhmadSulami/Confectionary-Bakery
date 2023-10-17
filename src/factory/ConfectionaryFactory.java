package factory;

import java.util.ArrayList;

import adapter.PriceAdapter;
import model.Confectionary;

public class ConfectionaryFactory {

	public ConfectionaryFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static Confectionary createConfectionary(String name, String type, String softness, ArrayList<String> toppings, PriceAdapter priceAdapter ,String paymentType) {
		 Confectionary confectionary = new Confectionary();
		 confectionary.setName(name);
		 confectionary.setType(type);
		 confectionary.setSoftness(softness);
		 confectionary.setToppings(toppings);
		 confectionary.setPrice(priceAdapter);
		 confectionary.setPaymentType(paymentType);
		 return confectionary;
	}
}
	