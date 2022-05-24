package com.bankApp;


//Abstract means we will not be able to create objects from the account class
//But we can create objects that inherit account class
public abstract class Account implements IBaseRate {
	//List common properties for savings and checking accounts
	private String name;
	private String sSN;
	private double balance;
	
	private static int index = 10000;
	protected String accountNumber;
	protected double rate; 
	
	//Constructor to set base properties and initialize the account
	public Account(String name, String sSN, double initDeposit){
		this.name = name;
		this.sSN = sSN;
		balance = initDeposit;
		
		index++;
		this.accountNumber = setAccountNumber();
		
		setRate();
	}
	
	public abstract void setRate() ; 
	
	private String setAccountNumber() {
		String last2ofSSN = sSN.substring(sSN.length()-2, sSN.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return last2ofSSN + uniqueID +randomNumber;
	}
	
	public void compund() {
		double accruedIntrest = balance * (rate/100);
		System.out.println("Accrued Intrest: $" + accruedIntrest);
		balance = balance + accruedIntrest;
		printBalance();
	}
	
	//List common methods 
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}

	public void withraw(double amount) {
		balance = balance - amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();
	}
	
	public void tranfer(String toWhere, double amount) {
		balance = balance - amount;
		System.out.println("Transfering $" + amount + " to " + toWhere);
		printBalance();
	}
	
	public void printBalance() {
		System.out.println("*****Your balance is now $" + balance + "*****\n");
	}
	
	public void showInfo(){
		System.out.println(
				"NAME : " + name +
				"\nACCOUNT : " + accountNumber +
				"\nBALANCE : " + balance +
				"\nRATE : " + rate + "%"
				);
	}
}
