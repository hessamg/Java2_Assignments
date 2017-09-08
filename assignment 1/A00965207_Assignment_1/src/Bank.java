import java.util.HashMap;

/**
 * A00965207
 * 
 * @version 2016.05.16
 * @author Hessam Ganjian
 */

public class Bank {
	public static HashMap<String, BankCustomer> theBank;

	/**
	 * Default constructor for Bank class. Initializes the HashMap.
	 */
	public Bank() {
		theBank = new HashMap<String, BankCustomer>();
	}

	/**
	 * Add a new BankCustomer element to the HashMap.
	 * 
	 * @param newCustomer
	 *            The new element to add to the HashpMap using the account
	 *            number as the key and the new BankCustomer as the value.
	 */
	public void createAccount(BankCustomer newCustomer) {
		if (newCustomer != null) {
			theBank.put(newCustomer.getAccountNumber(), newCustomer);
		}
	}

	/**
	 * Removes an BankCustomer from the HashMap.
	 * 
	 * @param accountNumber
	 *            The key of the element to remove from the HashMap.
	 */
	public void closeAccount(String accountNumber) {
		if (accountNumber != null && accountNumber.length() > 0 && theBank.containsKey(accountNumber)) {
			theBank.remove(accountNumber);
			System.out.println("Account number " + accountNumber + " is closed.");
		} else {
			System.out.println("There is no such an account.\n");
		}
	}

	/**
	 * Gets the BankCustomer from the HashMap and adds a double amount to a
	 * BankCustomer's balance.
	 * 
	 * @param accountNumber
	 *            The account number of the BankCustomer.
	 * @param amount
	 *            The amount to deposit.
	 */
	public void deposit(String accountNumber, double amount) {
		if (accountNumber != null && accountNumber.length() > 0 && theBank.containsKey(accountNumber)) {
			theBank.get(accountNumber).addToBalance(amount);
		} else {
			System.out.println("There is no such an account.\n");
		}
	}

	/**
	 * Gets the BankCustomer from the HashMap and subtracts an amount from a
	 * BankCustomer's balance as long as it does not leave a negative balance.
	 * 
	 * @param accountNumber
	 *            The account number of the BankCustomer.
	 * @param amount
	 *            The amount to subtract from a BankCustomer's balance.
	 */
	public void withdraw(String accountNumber, double amount) {
		if (accountNumber != null && accountNumber.length() > 0 && theBank.containsKey(accountNumber)) {	
			theBank.get(accountNumber).subtractFromBalance(amount);
		} else {
			System.out.println("There is no such an account.\n");
		}
	}

	/**
	 * Displays the details of a BankCustomer element in the HashMap. Uses
	 * BankCustomer.toString() implementation.
	 * 
	 * @param customer
	 *            the BankCustomer chosen to display.
	 */
	public static void displayCustomerInformation(BankCustomer customer) {
		System.out.println("Here is your information.");
		if (customer != null) {	
			for (String key : theBank.keySet()) {
				{
					if (theBank.get(key).getAccountNumber().equals(customer.getAccountNumber())){
						System.out.println(theBank.get(key).toString());
					}
				}
			}
			System.out.println();
		}
	}

	/**
	 * Displays all elements of the HashMap by using BankCustomer.toString()
	 * implementation of each.
	 */
	public static void displayAllCustomers() {
		if (!theBank.isEmpty()) {
			for (String acounts : theBank.keySet()) {
				System.out.println(theBank.get(acounts).toString());
			}
		} else {
			System.out.println("No Bank accounts yet.\n");
		}
	}

}
