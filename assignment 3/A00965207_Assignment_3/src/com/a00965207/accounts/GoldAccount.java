package com.a00965207.accounts;
/**
 * GoldAccount data class. A00965207
 * 
 * @version 2016.06.27
 * @author Hessam Ganjian
 */
public class GoldAccount extends Account {

	private boolean overdraft;

	public static final double INTEREST_RATE = 0.025;
	public static final double FEE = 10.0;
	public static final double OVERDRAFT_AMT = -5000.0;

	/**
	 * Default constructor.
	 */
	public GoldAccount() {
		super();
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
	public GoldAccount(double balance, String accountNumber) {
		super(balance, accountNumber);
		overdraft = false;
	}

	/**
	 * 
	 * @return the interestRate as double.
	 */
	public double getInterestRate() {

		return INTEREST_RATE;
	}

	/**
	 * 
	 * @return the inOverdraft as boolean.
	 */
	public boolean isOverdraft() {

		return overdraft;
	}

	/**
	 * 
	 * @param overdraft
	 *            the inOverdraft to set.
	 */
	public void setOverdraft(boolean overdraft) {

		this.overdraft = overdraft;
	}

	/**
	 * 
	 * @param transactionInfo
	 *            the information to add to ArrayList.
	 */
	@Override
	public void addTransaction(String transactionInfo) {
		System.out.println("Saving transaction details for Gold Account...");
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

		if (getBalance() - amount >= GoldAccount.OVERDRAFT_AMT) {
			
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
		return "GoldAccount [interestRate=" + INTEREST_RATE + ", overdraft=" + overdraft + ", toString()="
				+ super.toString() + "]";
	}

}
