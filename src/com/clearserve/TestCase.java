package com.clearserve;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Setup the sale rules and test three cases.
 * @author Jingyi Guo
 * @version 01/10/14
 */
public class TestCase {
	public static SaleTerminal terminal;


	@Before
	public void setUp() throws Exception {
		terminal=new SaleTerminal();
		terminal.setPricing("A", 4, 2, 7);
		terminal.setPricing("B", 12);
		terminal.setPricing("C", 6, 1.25, 6);
		terminal.setPricing("D", 0.15);
		}
	
	@Test
	public void testCase1() {
		terminal.scan("A");
		terminal.scan("B");
		terminal.scan("C");
		terminal.scan("D");
		terminal.scan("A");
		terminal.scan("B");
		terminal.scan("A");
		terminal.scan("A");
		double total=terminal.total();
		System.out.println(total);
		assertEquals(32.4,total,0.001 );
	}
	
	
	@Test
	public void testCase2() {
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		double total=terminal.total();
		assertEquals(7.25,total,0.001 );
	}
	@Test
	public void testCase3() {
		terminal.scan("A");
		terminal.scan("B");
		terminal.scan("C");
		terminal.scan("D");
		double total=terminal.total();
		assertEquals(15.4,total,0.001);
	}

}
