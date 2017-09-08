package com.a00965207.data;
import com.a00965207.accounts.*;
/**
 * BankCustomer data class to hold customer information.
 * A00965207
 * 
 * @version 2016.06.27
 * @author Hessam Ganjian
 */
public class BankCustomer {
	private String firstName;
	private String lastName;
	private String passcode;
	private Account account;
	private int age;

	/**
	 * Default constructor for a BankCustomer. Sets the fields to the default
	 * values for each type.
	 */
	public BankCustomer() {
		super();
	}

	/**
	 * Overloaded constructor to initialize objects of the BankCustomer class.
	 * 
	 * @param firstName
	 *            the first name of the customer
	 * @param lastName
	 *            the last name of the customer
	 * @param passcode
	 *            the passcode of the customer
	 * @param age
	 *            the age of the customer
	 */
	public BankCustomer(String firstName, String lastName, String passcode,
			int age) {
		super();
		setFirstName(firstName);
		setLastName(lastName);
		setPasscode(passcode);
		setAge(age);
	}

	/**
	 * Returns the first name of the bank customer.
	 * 
	 * @return the firstName as String
	 */
	public String getFirstName() {

		return firstName;
	}

	/**
	 * Sets the first name of the bank customer.
	 * 
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {

		if (firstName != null && !firstName.isEmpty()) {
			this.firstName = firstName;
		}
	}

	/**
	 * Returns the last name of the bank customer.
	 * 
	 * @return the lastName as String
	 */
	public String getLastName() {

		return lastName;
	}

	/**
	 * Sets the last name of the bank customer.
	 * 
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {

		if (lastName != null && !lastName.isEmpty()) {
			this.lastName = lastName;
		}
	}

	/**
	 * Returns the passcode of the bank customer.
	 * 
	 * @return the passcode as String
	 */
	public String getPasscode() {

		return passcode;
	}

	/**
	 * Sets the passcode of the bank customer.
	 * 
	 * @param passcode
	 *            the passcode to set
	 */
	public void setPasscode(String passcode) {

		if (passcode != null && !passcode.isEmpty()) {
			this.passcode = passcode;
		}
	}

	/**
	 * Returns the customer account.
	 * 
	 * @return the myAccount as Account
	 */
	public Account getAccount() {

		return account;
	}

	/**
	 * Sets the customer account.
	 * 
	 * @param account
	 *            the myAccount to set.
	 */
	public void setAccount(Account account) {

		if (account != null) {
			this.account = account;
		}
	}

	/**
	 * Returns the age of the customer.
	 * 
	 * @return the age as int
	 */
	public int getAge() {

		return age;
	}

	/**
	 * Sets the age of the customer.
	 * 
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {

		if (age >= 0) {
			this.age = age;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BankCustomer [firstName=" + firstName + ", lastName="
				+ lastName + ", passcode=" + passcode + ", account=" + account
				+ ", age=" + age + "]";
	}

	

}
