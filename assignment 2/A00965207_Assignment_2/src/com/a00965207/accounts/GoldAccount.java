package com.a00965207.accounts;

import java.util.Date;

/**
 * A00965207
 * 
 * @version 2016.05.30
 * @author Hessam Ganjian
 */
public class GoldAccount extends Account {
	private double interestRate;
	private boolean inOverdraft;
	private final double FEE = 5.00;
	private final double OVERDRAFT_AMT = 50.00;
	private Date newDate;

	/**
	 * Default constructor of GoldAccount.
	 */
	public GoldAccount() {

	}

	/**
	 * Constructor of class GoldAccount.This is an account that is provided to
	 * senior citizens, people 65 years and older.
	 * 
	 * @param accountNumber
	 *            to set accountNumber as String.
	 * @param age
	 *            to check the age restriction for the gold account holders.
	 */
	public GoldAccount(String accountNumber, int age) {
		super(accountNumber);
		setAccountType("GoldAccount", age);
		setActive(true);
		setInterestRate(0.025);
		newDate = new Date();
	}

	/**
	 * Mutator for the interestRate field.
	 * 
	 * @return the interestRate as double.
	 */
	public double getInterestRate() {
		return interestRate;
	}

	/**
	 * Accessor for the interestRate field.
	 * 
	 * @param interestRate
	 *            the interestRate to set as double.
	 */
	public void setInterestRate(double interestRate) {
		if (interestRate >= 0) {
			this.interestRate = interestRate;
		}
	}

	/**
	 * Mutator for the inOverdraft field.
	 * 
	 * @return the inOverdraft
	 */
	public boolean isInOverdraft() {
		return inOverdraft;
	}

	/**
	 * Accessor for the inOverdraft field.
	 * 
	 * @param inOverdraft
	 *            the inOverdraft to set as boolean.
	 */
	public void setInOverdraft(boolean inOverdraft) {
		this.inOverdraft = inOverdraft;
	}

	/**
	 * Override method for the the accountType field.
	 * 
	 * @param accountType
	 *            The accountType to set as String.
	 * @param age
	 *            Check if the age is above 65.
	 */
	public void setAccountType(String accountType, int age) {
		if (accountType != null && accountType.length() > 0) {
			if (age >= 65) {
				setAccountType(accountType);
			} else {
				System.out.println("The customer has to be older than 65 years old to open a Gold Account.");
			}
		}
	}

	/**
	 * Overrides method addToBalance.
	 * 
	 * @param amount
	 *            a double to add to the existing balance field
	 */

	public void addToBalance(double amount) {
		@SuppressWarnings("deprecation")
		int numOfMounths = (new Date().getMonth() - newDate.getMonth())
				+ 12 * (new Date().getYear() - newDate.getYear());
		if (numOfMounths != 0) {
			super.addToBalance(amount + (getBalance() * interestRate * numOfMounths));
			newDate = new Date();
		} else {
			super.addToBalance(amount);
			newDate = new Date();
		}
		if (getBalance() >= 0) {
			if (isInOverdraft()) {
				System.out.println("You are no longer in overdraft.");
			}
			setInOverdraft(false);
		}
	}

	/**
	 * Override method for the the subtractFromBalance field.
	 * 
	 * @param amount
	 *            the amount to remove from balance.
	 */
	public void subtractFromBalance(double amount) {
		@SuppressWarnings("deprecation")
		int numOfMounths = (new Date().getMonth() - newDate.getMonth())
				+ 12 * (new Date().getYear() - newDate.getYear());
		if (amount <= getBalance() + OVERDRAFT_AMT && amount > 0) {
			if (amount >= getBalance()) {
				setInOverdraft(true);
				System.out.println("You are in overdraft now.\n" + "You will be charged $" + FEE
						+ " every month until you are no longer in overdraft.");
			}
			setBalance(getBalance() - amount);
			setTransaction(new Date() + " - withdrawal: $" + amount);
		} else if (amount < 0) {
		} else {
			System.out.println("You don't have enough balance in your account.");
		}
		if (inOverdraft) {
			super.subtractFromBalance(FEE * numOfMounths);
			newDate = new Date();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (", account=" + getAccountType() + " [interestRate=" + interestRate + ", Overdraft=" + inOverdraft
				+ super.toString() + "]");
	}

}
