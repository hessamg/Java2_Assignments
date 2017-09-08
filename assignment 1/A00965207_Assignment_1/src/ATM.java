/**
 * A00965207
 * 
 * @version 2016.05.16
 * @author Hessam Ganjian
 */
public class ATM {

	private InputReader reader;
	private Bank bank;
	private boolean exit, verified;
	private String accountNumber, passcode;

	/**
	 * Default constructor. Calls the initialize() method to seed the Bank with
	 * some BankCustomers. Calls the run() method to perform the primary program
	 * functions.
	 */
	public ATM() {
		reader = new InputReader();
		initialize();

	}

	/**
	 * Main method calls the class default constructor.
	 * 
	 * @param args
	 *            for program arguments (not used).
	 */
	public static void main(java.lang.String[] args) {
		new ATM().run();
	}

	/**
	 * The primary application processor.
	 */
	public void run() {
		System.out.println("Welcome to Bullwinkle's Bank.");
		while (!exit) {
			System.out.println("Choose one of the following options:");
			System.out.println("1 - Sign In");
			System.out.println("2 - Deposit");
			System.out.println("3 - Withdraw");
			System.out.println("4 - Display Account Info");
			System.out.println("5 - Exit");

			int input = reader.getIntInput();
			System.out.println("> " + input);
			switch (input) {
			case 1:
				verifyCustomer();
				break;
			case 2:
				transactDeposit();
				break;
			case 3:
				transactWithdraw();
				break;
			case 4:
				displayAccountInformation();
				break;
			case 5:
				exit = true;
				System.out.println("Thank you for banking at Bullwinkle's Bank.");
				System.out.println("\nDEBUG: Displaying all the accounts in the bank.");
				Bank.displayAllCustomers();
				System.out.println("\nDEBUG: Closing account number ST-789:");
				bank.closeAccount("ST-789");
				Bank.displayAllCustomers();
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		}
	}

	/**
	 * Adds Customer references to the Back HashMap as seed data for testing.
	 */
	public void initialize() {
		BankCustomer bc1, bc2, bc3;
		bc1 = new BankCustomer("darby", "dog", "ST-123", "123");
		bc2 = new BankCustomer("FrEckle", "cAt", "ST-789", "789");
		bc3 = new BankCustomer("Myia", "dog", "ST-456", "456");

		bank = new Bank();
		bank.createAccount(bc1);
		bank.createAccount(bc2);
		bank.createAccount(bc3);
	}

	/**
	 * Performs a deposit into a BankCustomer's account.
	 */
	public void transactDeposit() {
		if (verified) {
			System.out.println("Enter the amount to deposit:");
			bank.deposit(accountNumber, reader.getDoubleInput());
		} else {
			System.out.println("ERROR: You must LOGIN before you can perform a transaction.");
		}

	}

	/**
	 * Performs a withdrawal from a BankCustomer's account.
	 */
	public void transactWithdraw() {
		if (verified) {
			System.out.println("Enter the amount to withdraw:");
			bank.withdraw(accountNumber, reader.getDoubleInput());
		} else {
			System.out.println("ERROR: You must LOGIN before you can perform a transaction.");
		}

	}

	/**
	 * Displays a BankCustomer's account information if the customer has been
	 * previously verified.
	 */
	public void displayAccountInformation() {
		if (verified) {
			Bank.displayCustomerInformation(Bank.theBank.get(accountNumber));
		} else {
			System.out.println("ERROR: You must LOGIN before you can perform a transaction.");
		}
	}

	/**
	 * To confirm a BankCustomer's account number and passcode.
	 */
	public void verifyCustomer() {
		if (verified) {
			System.out.println("You are already Signed In.Do you wish to Sign out?(Y/N)");
			String input = reader.getStringInput();
			if (input.equals("y") || input.equals("Y")) {
				verified = false;
				System.out.println("You are signed out from your account.");
				System.out.println("Welcome to Bullwinkle's Bank.");
			}
		} else {
			System.out.println("Enter Account Number:");
			accountNumber = reader.getStringInput();
			System.out.println("Enter Passcode:");
			passcode = reader.getStringInput();
			if (Bank.theBank.containsKey(accountNumber)
					&& passcode.equals(Bank.theBank.get(accountNumber).getPasscode())) {
				verified = true;
			}

			else {
				System.out.println("ERROR: Either account number or passcode is not correct.");
			}
		}
	}
}
