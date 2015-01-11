package com.clearserve;

import java.io.ObjectOutputStream.PutField;
import java.util.HashMap;
import java.util.Map;

/**
 * This is the point of sale scanning API. It scans products, sets produce price and calculate
 * the final total price. It also perform a rounding at the final total price.
 * 
 * @author Jingyi Guo
 * @version 01/10/14
 */
public class SaleTerminal {
	//hashmap is used to store the product name and corresponding calculator
	private HashMap<String, ProductCalculator> priceRule=new HashMap<String,ProductCalculator>();
	private ProductScanner proScan=new ProductScanner();
	
/**
* Set the price policy for certain number of products. For example, $5 for 5 banana
* @param pro product name
* @param minNum minimal number for a volumn price and if the minNum is 1,then unitprice is the same with volumnprice 
* @param unitPrice price for purchasing one product
* @param volumnPrice price for purchasing the minNum of product
*/
public void setPricing(String pro,int minNum,double unitPrice,double volumnPrice){
	ProductCalculator cal=new ProductCalculator(pro, minNum, unitPrice, volumnPrice);
	if(priceRule.containsKey(pro)){
		throw new DuplicatProduct(pro);
	}
	else{
		priceRule.put(pro,cal);
	}
	
}
public void setPricing(String pro,double unitPrice){
	setPricing(pro, 1,unitPrice,unitPrice);
}

/**
 * Scan the product to shopping list.
 * @throws exception if there is no such product exist 
 * @param pro product name
 */
public void scan(String pro){
	ProductCalculator map=priceRule.get(pro);
	if(map==null)
		throw new MissingProduct(pro);
	proScan.addProduct(pro);
}


//Calculate the total price of products according to product list.
public double total(){
	double total=0;
	for(Map.Entry<String, Integer> pro:proScan.getProducts().entrySet()){
		String proName=pro.getKey();
		int quantity=pro.getValue();
		ProductCalculator proCal=priceRule.get(proName);
		if(proCal==null)
			throw new MissingProduct(proName);
		
		ProductCalculator cal=priceRule.get(proName);
		double subtotal=cal.getTotal(quantity);
		total+=subtotal;
		//System.out.println(total);
	}
	//round the total price to two digit
	return round(total, 2);
}

//round the double to certain digit number
public static double round(double value, int places) {
    if (places < 0) 
    	throw new IllegalArgumentException();
    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
}
public HashMap<String, ProductCalculator> getPriceRule(){
	return priceRule;
}

}
