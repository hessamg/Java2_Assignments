package com.a00965207.test;

import com.a00965207.accounts.GoldAccount;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GoldAccountTest {
	private GoldAccount ga;
	
	/**
	 * Setting up.
	 */
	@Before public void setUp() {
		ga = new GoldAccount("GL-123",65);
	}
	
	/**
	 * Tearing down.
	 */
	@After
	public void tearDown() {
	}

	/**
	 * Positive Testing. the account is created. age is greater than 65.
	 */
	@Test
	public void testSetAccountType() {
		assertEquals("GL-123", ga.getAccountNumber());
	}
	
	/**
	 * Positive Test. Testing the setInterestRate().
	 */
	@Test
	public void testPositiveSetInterestRate() {
		ga.setInterestRate(0.50);
		assertEquals(0.50, ga.getInterestRate(),0.01);
	}
	
	/**
	 * Negative Test. interestRate should not go negative. interestRate should not change.
	 */
	@Test
	public void testNegativeSetInterestRate() {
		ga.setInterestRate(-0.05);
		assertEquals(0.025, ga.getInterestRate(),0.01);
	}

	/**
	 * Positive Test. should add to balance.
	 */
	@Test
	public void testPositiveAddToBalance() {
		ga.addToBalance(100.0);
		assertEquals(100.0, ga.getBalance(),0.01);
	}
	
	/**
	 * Negative Test. should not add a negative balance. balance should not change.
	 */
	@Test
	public void testNegativeAddToBalance() {
		ga.addToBalance(-100.0);
		assertEquals(0.0, ga.getBalance(),0.01);
	}
	
	/**
	 * Positive Test. should remove even though the balance will be negative.
	 */
	@Test
	public void testPositiveSubtractFromBalance() {
		ga.subtractFromBalance(10.0);
		assertEquals(-10.0, ga.getBalance(),0.01);
	}
	
	/**
	 * Negative Test. should not subtract a negative. balance should not change.
	 */
	@Test
	public void testNegativeSubtractFromBalance() {
		ga.subtractFromBalance(-10.0);
		assertEquals(0.0, ga.getBalance(),0.01);
	}
}
