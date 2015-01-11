package com.clearserve;

import java.util.HashMap;

/**
 * Record products of type and quantity in shopping list
 * @author Jingyi Guo
 * @version 01/10/14
 */

public class ProductScanner {
	// a hashmap is used to record the products customer purchased.
	private HashMap<String, Integer> productList=new HashMap<String,Integer>();
	//scan product one by one
	public void addProduct(String prod){
		if(productList.containsKey(prod)){
			productList.put(prod,productList.get(prod)+1);
		}
		else {
			productList.put(prod,1);
		}
	}

	public int getProductQuan(String prod){
		if(productList.containsKey(prod))
			return productList.get(prod);
		else 
			return 0;
	}
	//get the product lists
	public HashMap<String, Integer> getProducts(){
		return productList;
		
	}
	
}
