package adapter;

import java.security.SecureRandom;

import payment.Crypto;

public class PricetoCryptoAdapter implements PriceAdapter {
	private Crypto crypto;
	
	public static String generateCryptoAddress() {
		String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
		int length = 12;
		
		StringBuilder cryptoAddress = new StringBuilder(length);
		SecureRandom random = new SecureRandom();
		
		
		for(int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(characters.length());
			char randomChar = characters.charAt(randomIndex);
			cryptoAddress.append(randomChar);
		}
		
		return cryptoAddress.toString();
	}
	
	public PricetoCryptoAdapter(Crypto crypto) {
		// TODO Auto-generated constructor stub
		this.crypto = crypto;
		this.crypto.setCrypto((float) (crypto.getCrypto() * 0.5));
	}
	

	@Override
	public String getAmount() {
		// TODO Auto-generated method stub
		return "ADA " + this.crypto.getCrypto()+ " with Address : "+ generateCryptoAddress();
	}

}
