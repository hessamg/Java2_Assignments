package com.a00965207.accounts;
/**
 * A00965207
 * 
 * @version 2016.05.30
 * @author Hessam Ganjian
 */

public class SavingsAccount extends Account {
	private final double MIN_AMOUNT = 50.00;

	/**
	 * Default constructor for SavingsAccount.
	 */
	public SavingsAccount() {

	}

	/**
	 * Constructor for SavingsAccount.A subtype of Account. It will hold
	 * information that is unique to a savings account.
	 * 
	 * @param accountNumber
	 *            as String.
	 */
	public SavingsAccount(String accountNumber) {
		super(accountNumber);
		setActive(isActive());
		setAccountType("SavingsAccount");

	}
	
	/**
	 * Override for the the balance field.
	 * 
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(double balance) {
		if (balance >= 0) {
			super.setBalance(balance);
		}
	}
	/**
	 * overriding the isActive. The account will be deactivated if the balance
	 * is less than MIN_AMOUNT.
	 * 
	 * @return active from superclass as boolean.
	 */
	public boolean isActive() {
		if (getBalance() < MIN_AMOUNT) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ", account=" + getAccountType() + super.toString();
	}

}
