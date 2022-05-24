package com.bankApp;

import java.util.LinkedList;
import java.util.List;

public class BankApp {

	public static void main(String[] args) {
		/*Checking chkacc1 = new Checking("Tom Wilson", "321456789", 1500);
		
		Savings savacc1 = new Savings("Rich Lowe","441456799", 2500);
		
		chkacc1.showInfo();

		savacc1.showInfo();
		
		//savacc1.deposit(5000);
		//savacc1.withraw(20);
		//savacc1.tranfer("mTB",20);
		savacc1.compund();
		*/
		List<Account> accounts = new LinkedList<Account>(); 
		
		String file ="C:\\Users\\mlanj\\eclipse-workspace2\\mapmay2\\src\\main\\java\\com\\bankApp\\NewBankAccounts.csv";
		
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		
		for(String[] accountHolder : newAccountHolders) {
			String name = (accountHolder[0]);
			String sSN = accountHolder[1];
			String accType = (accountHolder[2]);
			double initDeposit = Double.parseDouble(accountHolder[3]);
			
			if(accType.equals("Savings")) {
				accounts.add(new Savings(name,sSN, initDeposit));
			}
			else if (accType.equals("Checking")) {
				accounts.add(new Checking(name,sSN, initDeposit));
			}
			else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
		}
	
		for (Account acc : accounts) {
			acc.showInfo();
		}
		
	}

}
 