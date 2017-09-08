package com.a00965207.test;

import com.a00965207.accounts.SavingsAccount;
//import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SavingsAccountTest {
	private SavingsAccount sa;

	/**
	 * Setting up.
	 */
	@Before
	public void setUp() {
		sa = new SavingsAccount("SA-123");
	}

	/**
	 * Tearing down.
	 */
	@After
	public void tearDown() {
	}

	/**
	 * Positive Testing. the balance should change.
	 */
	@Test
	public void testPositiveSetBalance() {
		sa.setBalance(10.5);
		assertEquals(10.5, sa.getBalance(), 0.01);
	}

	/**
	 * Negative Testing. The balance should not change . it cannot be negative
	 * in Chequing Account
	 */
	@Test
	public void testNegativeSetBalance() {
		sa.setBalance(-10.5);
		assertEquals(0, sa.getBalance(), 0.01);
	}

	/**
	 * Positive Testing. the account should be active.
	 */
	@Test
	public void testPositiveIsActive() {
		sa.setBalance(55.5);
		assertEquals(true, sa.isActive());
	}

	/**
	 * Negative Testing. the account should not be active.Balance is less than
	 * minimum balance.
	 */
	@Test
	public void testNegativeIsActive() {
		sa.setBalance(10.5);
		assertEquals(false, sa.isActive());
	}

}
