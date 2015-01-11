package com.clearserve;
/**
 * Calculate a product's price according to the number of product using unit price or volume prices.
 * 
 * @author Jingyi Guo
 * @version 01/10/14
 */
public class ProductCalculator {
	private String productName;//product name
	private int minNum;			//minimal number required for volume price
	private double unitPrice;   //unitPrice of product
	private double volumnPrice; //volume price of product
	
	public ProductCalculator(String productName,int minNum,double unitPirce,double volumnPrice){
		this.productName=productName;
		this.minNum=minNum;
		this.unitPrice=unitPirce;
		this.volumnPrice=volumnPrice;
	}
	// judge if the product is qualified for volumnprice
	public boolean addVolumnPrice(int numberPerchased){
		return numberPerchased>=minNum;
	}
	//calculate the total price of certain product
	public double getTotal(int numberPerchased){
		if(addVolumnPrice(numberPerchased)){
			return unitPrice*(numberPerchased%minNum)+volumnPrice*(numberPerchased/minNum);
		}
		else {
			return unitPrice*numberPerchased;
		}
	}
	
	public String getName(){
		return productName;
	}
	public int getMin(){
		return minNum;
	}
	public double getUnitPrice(){
		return unitPrice;
	}
	public double getVolumnPrice(){
		return volumnPrice;
	}

}
