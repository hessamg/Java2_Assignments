package com.a00965207.test;

import com.a00965207.accounts.ChequingAccount;
//import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChequingAccountTest {
	private ChequingAccount ca;
	
	/**
	 * Setting up.
	 */
	@Before
	public void setUp(){
		ca = new ChequingAccount("CH-123");
	}
	
	/**
	 * Tearing down.
	 */
	@After
	public void tearDown() {
	}
	
	/**
	 * Positive Testing. The number if cheques should change.
	 */
	@Test
	public void testPositiveSetNumberOfCheques() {
		ca.setNumberOfCheques(5);
		assertEquals(5, ca.getNumberOfCheques());
	}
	
	/**
	 * Negative Testing. The number if cheques should not change. it cannot be negative
	 */
	@Test
	public void testNegativeSetNumberOfCheques() {
		ca.setNumberOfCheques(-5);
		assertEquals(2, ca.getNumberOfCheques());
	}
	
	/**
	 * Positive Testing. the balance should change.
	 */
	@Test
	public void testPositiveSetBalance() {
		ca.setBalance(10.5);
		assertEquals(10.5, ca.getBalance(),0.01);
	}
	
	/**
	 * Negative Testing. The balance should not change . it cannot be negative in Chequing Account
	 */
	@Test
	public void testNegativeSetBalance() {
		ca.setBalance(-10.5);
		assertEquals(0, ca.getBalance(),0.01);
	}
	
	/**
	 * Positive Test. should remove even though the balance will be negative.
	 */
	@Test
	public void testPositiveSubtractFromBalance() {
		ca.setBalance(50.0);
		ca.subtractFromBalance(10.0);
		assertEquals(40.0, ca.getBalance(),0.01);
	}
	
	/**
	 * Negative Test. should not subtract a negative. balance should not change.
	 */
	@Test
	public void testNegativeSubtractFromBalance() {
		ca.subtractFromBalance(-10.0);
		assertEquals(0.0, ca.getBalance(),0.01);
	}
}
