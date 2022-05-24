package com.bankApp;

public class Checking extends Account{
	//List properties specific to checking
	private int debitCardNumber;
	private int debitCardPIN;
	
	//Constructor to initialize checking account properties
	public Checking(String name, String sSN, double initDeposit) {
		super(name,sSN, initDeposit);
		accountNumber = "2" + accountNumber;
		setDebitCard();
	}
	
	private void setDebitCard() {
		debitCardNumber = (int)(Math.random() * Math.pow(10,12));
		debitCardPIN = (int)(Math.random() * Math.pow(10,4));
	}

	//List any methods specific to checking
	
	
	public void showInfo() {
		System.out.println("ACCOUNT TYPE: Checking");
		super.showInfo();
		System.out.println(
				"Your Savings Account Features" +
				"\n Debit Card Number : "+ debitCardNumber +		
				"\n PIN: "+ debitCardPIN +"\n"
				);
	}

	@Override
	public void setRate() {
		rate = getBaseRate() * .15;
	}
}
