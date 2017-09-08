package com.a00965207.accounts;
import java.util.ArrayList;
import java.util.Date;

/**
 * A00965207
 * 
 * @version 2016.06.27
 * @author Hessam Ganjian
 */
public abstract class Account {
	private double balance;
	private String accountNumber;
	private boolean active;
    protected ArrayList<String> accountRecords;

	/**
	 * Default constructor.
	 */
	public Account() {
	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param balance
	 *            the balance to set.
	 * @param accountNumber
	 *            the account number to set.
	 *            
	 */
	public Account(double balance, String accountNumber) {
		setBalance(balance);
		setAccountNumber(accountNumber);
		active = true;
		accountRecords = new ArrayList<String>();
	}

	/**
	 * 
	 * @return the balance as double.
	 */
	public double getBalance() {

		return balance;
	}

	/**
	 * 
	 * @param balance
	 *            the balance to set.
	 */
	public void setBalance(double balance) {

		if (balance >= 0) {
			this.balance = balance;
		}
	}

	/**
	 * 
	 * @return the accountNumber as String.
	 */
	public String getAccountNumber() {

		return accountNumber;
	}

	/**
	 * 
	 * @param accountNumber
	 *            the accountNumber to set.
	 */
	public void setAccountNumber(String accountNumber) {

		if (accountNumber != null && !accountNumber.isEmpty()) {
			this.accountNumber = accountNumber;
		}
	}

	/**
	 * 
	 * @return the active as boolean.
	 */
	public boolean isActive() {

		return active;
	}

	/**
	 * 
	 * @param active
	 *            the active to set.
	 */
	public void setActive(boolean active) {

		this.active = active;
	}

	/**
	 * 
	 * @param transactionInfo
	 *            the information to add to ArrayList.
	 */
	 public abstract void addTransaction(String transactionInfo);

	/**
	 * Displays the transaction information.
	 */
	public void displayAccountRecords() {
		System.out.println("Acount Activity: ");

		for (String info : accountRecords) {
			System.out.println(info);
		}
	}

	/**
	 * 
	 * @param amount
	 *            the amount to add to the existing field.
	 */
	public void addToBalance(double amount) {

		if (amount > 0.0) {
			balance += amount;
			addTransaction(String.format("%s - deposit: $%.2f", new Date(), amount));
		}
	}

	/**
	 * 
	 * @param amount
	 *            the amount to subtract from the balance.
	 */
	public void subtractFromBalance(double amount) {

		if (amount > 0.0) {
			balance -= amount;
			addTransaction(String.format("%s - withdrawal: $%.2f", new Date(), amount));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [balance=" + balance + ", accountNumber="
				+ accountNumber + ", active=" + active + "]";
	}

}