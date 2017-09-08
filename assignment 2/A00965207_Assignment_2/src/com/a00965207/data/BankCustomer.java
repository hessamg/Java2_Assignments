package com.a00965207.data;

import com.a00965207.accounts.*;

/**
 * A00965207
 * 
 * @version 2016.05.30
 * @author Hessam Ganjian
 */
public class BankCustomer {

	private String firstName, lastName, passcode;
	private Account myAccount;
	private int age;

	/**
	 * Default constructor for a BankCustomer.
	 */
	public BankCustomer() {
		myAccount = new Account();
	}

	/**
	 * Copy constructor for a BankCustomer.
	 * 
	 * @param firstName
	 *            - String to initialize the firstName field
	 * @param lastName
	 *            - String to initialize the lastName field
	 * @param accountNumber
	 *            - String to initialize the accountNumber field
	 * @param passcode
	 *            - String to initialize the passcode field * @param age - int
	 *            to initialize the age field
	 */
	public BankCustomer(String firstName, String lastName, String accountNumber, String passcode, int age) {

		if (accountNumber.substring(0, 2).equals("SA")) {
			myAccount = new SavingsAccount(accountNumber);
		} else if (accountNumber.substring(0, 2).equals("GL")) {
			myAccount = new GoldAccount(accountNumber, age);
		} else if (accountNumber.substring(0, 2).equals("CH")) {
			myAccount = new ChequingAccount(accountNumber);
		} else {
			myAccount = new ChequingAccount("CH-" + accountNumber);
		}
		setFirstName(firstName);
		setLastName(lastName);
		setPasscode(passcode);
		setAge(age);
	}

	/**
	 * @param name
	 *            the name to be formatted .
	 * @return as the properly-formatted name as a String.
	 */
	private String formatName(String name) {
		if (name != null) {
			return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
		} else {
			return ("The String cannot be null");
		}
	}

	/**
	 * Accessor method for the firstName field.
	 * 
	 * @return the firstName as a String
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Mutator for the firstName field.
	 * 
	 * @param firstName
	 *            - the firstName to set
	 */
	public void setFirstName(String firstName) {
		if (firstName != null && firstName.length() > 0) {
			this.firstName = firstName;
		}
	}

	/**
	 * Accessor method for the lastName.
	 * 
	 * @return the lastName as a String
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Mutator for the lastName field.
	 * 
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		if (lastName != null && lastName.length() > 0) {
			this.lastName = lastName;
		}
	}

	/**
	 * Accessor method for the passcode field.
	 * 
	 * @return the passcode as a String
	 */
	public String getPasscode() {
		return passcode;
	}

	/**
	 * Mutator for the passcode field.
	 * 
	 * @param passcode
	 *            the passcode to set
	 */
	public void setPasscode(String passcode) {
		if (passcode != null && passcode.length() > 0) {
			this.passcode = passcode;
		}
	}

	/**
	 * @return the age as int.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set as int.
	 */
	public void setAge(int age) {
		if (age >= 0) {
			this.age = age;
		}
	}

	/**
	 * Mutator for the myAccount field.
	 * 
	 * @return the myAccount Account.
	 */
	public Account getMyAccount() {
		return myAccount;
	}

	/**
	 * Accessor for the myAccount field.
	 * 
	 * @param myAccount
	 *            the myAccount to set Account.
	 */
	public void setMyAccount(Account myAccount) {
		this.myAccount = myAccount;
	}

	/**
	 * @return Overrides toString in class java.lang.Object.
	 */
	public String toString() {
		return ("BankCustomer [firstName=" + formatName(getFirstName()) + ", lastName=" + formatName(getLastName())
				+ ", passcode=" + getPasscode() + myAccount.toString() + ", age=" + age + "]");
	}
}
