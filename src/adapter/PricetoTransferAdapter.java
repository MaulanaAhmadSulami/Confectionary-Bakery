package adapter;

import java.util.Random;

import payment.Transfer;

public class PricetoTransferAdapter implements PriceAdapter {
	private Transfer transfer;
	
	public static String getAccountNumber() {
		StringBuilder accountNumber = new StringBuilder();
		
		Random random = new Random();
		
		for(int i = 0; i < 10; i++) {
			int digit = random.nextInt(10);
			accountNumber.append(digit);
		}
		
		return accountNumber.toString();
	}
	public PricetoTransferAdapter(Transfer transfer) {
		// TODO Auto-generated constructor stub
		this.transfer = transfer;
		this.transfer.setTransfer((float) (transfer.getTransfer() * 1.1));
	}


	@Override
	public String getAmount() {
		// TODO Auto-generated method stub
		return " $ " +this.transfer.getTransfer()+ " with Account Number "+ getAccountNumber();
	}

}
