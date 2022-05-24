package com.bankApp;

public class Savings extends Account{
	//List properties specific to Savings account
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;
	
	//Constructor to initialize settings for the account properties
	public Savings(String name, String sSN, double initDeposit) {
		super(name,sSN, initDeposit);
		accountNumber = "1" + accountNumber;
		setSafetyDepositBox();
	}	
	
	private void setSafetyDepositBox() {
		safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
		safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
	}
	//List any methods specific to Savings
	public void showInfo() {
		
		System.out.println("ACCOUNT TYPE: Savings");
		super.showInfo();
		System.out.println(
				"Your Savings Account Features" +
				"\n Safety Deposit Box ID: "+ safetyDepositBoxID +		
				"\n Safety Deposit Box key: "+ safetyDepositBoxKey +"\n"
				);
	}

	@Override
	public void setRate() {
		rate = getBaseRate() - .25;
	}
}
