package com.a00965207.accounts;
/**
 * SavingsAccount data class A00965207
 * 
 * @version 2016.06.27
 * @author Hessam Ganjian
 */
public class SavingsAccount extends Account {

	public static final double MIN_AMOUNT = 100.0;

	/**
	 * Default constructor.
	 */
	public SavingsAccount() {
		super();
	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param balance
	 *            the balance to set.
	 * @param accountNumber
	 *            the account number to set.
	 */
	public SavingsAccount(double balance, String accountNumber) {
		super(balance, accountNumber);
	}

	/**
	 * @return the minAmount constant as a double.
	 */
	public static double getMinAmount() {
		return MIN_AMOUNT;
	}

	/**
	 * 
	 * @param transactionInfo
	 *            the information to add to ArrayList.
	 */
	@Override
	public void addTransaction(String transactionInfo) {
		System.out.println("Saving transaction details for Saving Account...");
		if (!getAccountNumber().equals(null) && !getAccountNumber().isEmpty()) {
			accountRecords.add(transactionInfo);
			System.out.println("Successful");
		} else {
			System.out.println("Error!!!");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Account#subtractFromBalance(double)
	 */
	@Override
	public void subtractFromBalance(double amount) {

		if (getBalance() - amount >= MIN_AMOUNT) {
			super.subtractFromBalance(amount);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SavingsAccount [toString()=" + super.toString() + "]";
	}

}
