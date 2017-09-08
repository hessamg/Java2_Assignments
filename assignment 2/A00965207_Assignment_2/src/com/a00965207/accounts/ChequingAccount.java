package com.a00965207.accounts;

/**
 * A00965207
 * 
 * @version 2016.05.30
 * @author Hessam Ganjian
 */
public class ChequingAccount extends Account {
	private final double FEE = 0.50;
	private final int LIMIT_PER_MONTH = 3;
	private int numberOfCheques;

	/**
	 * Default constructor for ChequingAccount.
	 */
	public ChequingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor for ChequingAccount. A subtype of Account. It will hold
	 * information for a chequing account.
	 * 
	 * @param accountNumber
	 *            to set as String.
	 */
	public ChequingAccount(String accountNumber) {
		super(accountNumber);
		setActive(true);
		setAccountType("ChequingAccount");
		setNumberOfCheques(2);
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
	 * @return the numberOfCheques as int.
	 */
	public int getNumberOfCheques() {
		return numberOfCheques;
	}

	/**
	 * @param numberOfCheques
	 *            the numberOfCheques to set as int.
	 */
	public void setNumberOfCheques(int numberOfCheques) {
		if (numberOfCheques >= 0) {
			this.numberOfCheques = numberOfCheques;
		}
	}

	/**
	 * Subtracts from a BankCustomer's balance.
	 * 
	 * @param amount
	 *            a double to subtract from the balance field
	 */
	public void subtractFromBalance(double amount) {

		if (getNumberOfCheques() <= LIMIT_PER_MONTH) {
			super.subtractFromBalance(amount);
			setNumberOfCheques(getNumberOfCheques() + 1);
		} else {
			System.out.println(
					"You have used all of your cheque limits for this month. Extra $" + FEE + " will be charged.");
			super.subtractFromBalance(amount + FEE);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ", account=" + getAccountType() + "[numberOfCheques=" + numberOfCheques + super.toString() + "]";
	}
}
