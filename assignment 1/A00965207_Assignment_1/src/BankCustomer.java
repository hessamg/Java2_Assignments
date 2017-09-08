/**
 * A00965207
 * 
 * @version 2016.05.16
 * @author Hessam Ganjian
 */

public class BankCustomer {

	private String firstName, lastName, accountNumber, passcode;
	private double balance;

	/**
	 * Default constructor for a BankCustomer. Sets the fields to the default
	 * values for each type.
	 */
	public BankCustomer() {

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
	 *            - String to initialize the passcode field
	 */
	public BankCustomer(String firstName, String lastName, String accountNumber, String passcode) {
		setFirstName(firstName);
		setLastName(lastName);
		setAccountNumber(accountNumber);
		setPasscode(passcode);
	}
	
	/**
	 * @param name the name to be formatted .
	 * @return  as the properly-formatted name as a String.
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
	 * Accessor method for the accountNumber field.
	 * 
	 * @return the accountNumber as a String
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Mutator for the accountNumber field.
	 * 
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		if (accountNumber != null && accountNumber.length() > 0) {
			this.accountNumber = accountNumber;
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
	 * Accessor method for the the balance field.
	 * 
	 * @return the balance as a double
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Mutator for the the balance field.
	 * 
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(double balance) {
		if (balance >= 0) {
			this.balance = balance;
		}
	}

	/**
	 * Adds to a BankCustomer's balance.
	 * 
	 * @param amount
	 *            a double to add to the existing balance field
	 */
	public void addToBalance(double amount) {
		if (amount > 0) {
			balance += amount;
		}
	}

	/**
	 * Subtracts from a BankCustomer's balance.
	 * 
	 * @param amount
	 *            a double to subtract from the balance field
	 */
	public void subtractFromBalance(double amount) {
		if (amount <= balance && amount > 0) {
			balance -= amount;
		}
	}

	/**
	 * @return Overrides toString in class java.lang.Object.
	 */
	public String toString() {
		return ("BankCustomer [firstName=" + formatName(getFirstName()) + 
                ", lastName=" + formatName(getLastName()) +
                ", accountNumber=" + getAccountNumber() +
                ", passcode=" + getPasscode() +
                ", balance=" + getBalance() +
                "]");
	}
}
