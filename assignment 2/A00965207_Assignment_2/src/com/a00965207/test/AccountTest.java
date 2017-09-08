package com.a00965207.test;

import com.a00965207.accounts.Account;
//import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountTest extends junit.framework.TestCase {
	private Account account1;

	/**
	 * Setting up.
	 */
	@Before
	public void setUp() {
		account1 = new Account("GL-123");
	}

	/**
	 * Tearing down.
	 */
	@After
	public void tearDown() {
	}

	/**
	 * The balance should be returned in 2 decimals. balance can be set negative here.
	 */
	@Test
	public void testGetAndSetBalance() {
		account1.setBalance(150.555);
		assertEquals(150.56, account1.getBalance());
	}
	/**
	 * Positive Testing. The account number should be changed.
	 */
	@Test
	public void testSetAccountNumber() {
		account1.setAccountNumber("CH-345");
		assertEquals("CH-345", account1.getAccountNumber());
	}
	
	/**
	 * Positive Testing. The balance should be changed.
	 */
	@Test
	public void testPositiveAddToBalance() {
		account1.setBalance(150.555);
		account1.addToBalance(25.5);
		assertEquals(176.06, account1.getBalance());
	}
	
	/**
	 * Negative Testing. The balance should not be changed. cannot be negative.
	 */
	@Test
	public void testNegativeAddToBalance() {
		account1.setBalance(150.555);
		account1.addToBalance(-25.5);
		assertEquals(150.56, account1.getBalance());
	}
	
	/**
	 * Positive Testing. The balance should be changed.
	 */
	@Test
	public void testPositiveSubtractFromBalance() {
		account1.setBalance(150.0);
		account1.subtractFromBalance(25.0);
		assertEquals(125.0, account1.getBalance());
	}
	/**
	 * Negative Testing. No negative balance.
	 */
	@Test
	public void testNegativeBalance() {
		account1.setBalance(150.0);
		account1.subtractFromBalance(175.0);
		assertEquals(150.0, account1.getBalance());
	}
	/**
	 * Negative Testing. The account number should not be changed. should not subtract a negative number. 
	 */
	@Test
	public void testNegativeSubtractFromBalance() {
		account1.setBalance(150.0);
		account1.subtractFromBalance(-25.5);
		assertEquals(150.0, account1.getBalance());
	}
	
	/**
	 * Testing isActive().
	 */
	@Test
	public void testIsActive() {
		// Success
		assertEquals(true, account1.isActive());

	}

}
