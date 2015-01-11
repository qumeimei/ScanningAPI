package com.clearserve;
/**
 * Handles the product without a price rule in system.
 * @author Jingyi Guo
 * @version 01/10/14
 */

public class MissingProduct extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public MissingProduct(String pro) {
		super("The productd" +pro+"is not exist,please define it first!");
	}

}
