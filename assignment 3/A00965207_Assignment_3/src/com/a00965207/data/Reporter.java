package com.a00965207.data;

/**
 * A00965207
 * 
 * @version 2016.06.27
 * @author Hessam Ganjian
 */
public interface Reporter {

	/**
	 * Will take a reference to the HashMap that contains all the Accounts in
	 * the bank and the prefix code that we used to identify each Account
	 * subtype. eg call. displayByCode(theBank, "gl") Only the account numbers
	 * that hold the prefix code specified will be displayed.
	 * 
	 * @param records
	 *            to set as Bank.
	 * @param prefix
	 *            to set as String.
	 */
	void displayByCode(Bank records, String prefix);

	/**
	 * Will display all the active Accounts in the bank. The output will be
	 * displayed sorted by account number.
	 * 
	 * @param records
	 *            to set as Bank.
	 */
	void displayAllCodes(Bank records);
	
	/**
	 * Will display only the inactive accounts in the bank, sorted by account
	 * number descending.
	 * 
	 * @param records
	 *            to set as BankBank.
	 */
	void displayInactiveCodes(Bank records);
}
