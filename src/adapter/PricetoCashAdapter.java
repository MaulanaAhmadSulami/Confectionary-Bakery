package adapter;

import payment.Cash;

public class PricetoCashAdapter implements PriceAdapter {

	private Cash cash;
	
	public PricetoCashAdapter(Cash cash) {
		this.cash = cash;
		this.cash.setCash((float) (cash.getCash() * 1.0));
	}
	@Override
	public String getAmount() {
		// TODO Auto-generated method stub
		return "$" + this.cash.getCash();
	}

	
}
