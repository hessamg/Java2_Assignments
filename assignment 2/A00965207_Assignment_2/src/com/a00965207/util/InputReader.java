package com.a00965207.util;
import java.util.Scanner;

/**
 * Class InputReader reads user input from the keyboard.
 */

/**
 * @version 2016.01.20
 * @author Bullwinkle Moose
 */
public class InputReader {
	private Scanner scanner;

	/**
	 * Default constructor for InputReader class Create a new InputReader to
	 * read user input.
	 */
	public InputReader() {
		scanner = new Scanner(System.in);
	}

	/**
	 * Retrieves a user's int input.
	 * @return the user's input as an int.
	 */
	public int getIntInput() {
		try {
			return scanner.nextInt();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Not a number - treating as zero");
			scanner.nextLine(); // clear the buffer
			return 0;
		}
	}

	/**
	 * Retrieves a user's double input.
	 * 
	 * @return the user's input as an double.
	 */
	public double getDoubleInput() {
		try {
			return scanner.nextDouble();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Not a number - treating as zero");
			scanner.nextLine(); // clear the buffer
			return 0.0;
		}
	}

	/**
	 * Retrieves a user's String input.
	 * 
	 * @return the user's input as an String.
	 */
	public String getStringInput() {

		String input = scanner.next();
		if (input.length() > 0) {
			return input;
		} else {
			System.out.println("ERROR:Invalid input provided");
		}
		return null;

	}
}