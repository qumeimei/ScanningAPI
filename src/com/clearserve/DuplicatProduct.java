package com.clearserve;
/**
 * Handles the product already has a price rule in system.
 * @author Jingyi Guo
 * @version 01/10/14
 */
public class DuplicatProduct extends RuntimeException{

	private static final long serialVersionUID = 2L;

	public DuplicatProduct(String pro) {
		super("The product" +pro+"is already exisit in productRulse!");
	}

}
