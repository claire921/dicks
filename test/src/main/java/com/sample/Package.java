package com.sample;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.sample.ShoppingExample.Customer;

public class Package {
	private CustomerInfo cusInfo;
	private HashMap<Product, Integer> productList;
	private double desireScore;
	private Date estimatedDate;
	private Date orderDate;
	private int maxItem;
	private int zoneID;
	
	public Package(Product p, int amount) {
		
		productList = new HashMap<Product, Integer>();
		productList.put(p,amount);
		System.out.println("new package!");
		

		
	}

	public ArrayList<Product> getProducts () {
		ArrayList<Product> list =  new ArrayList<Product>();
		list.addAll(productList.keySet());
		return list;
	}

	public void addProducts(Product prod,int number){
		productList.put(prod, number);
	}
	public int getZoneID() {
		return zoneID;
	}
	public void setZoneID(int zoneID) {
		this.zoneID = zoneID;
	}
	public CustomerInfo getCusInfo() {
		return cusInfo;
	}
	public void setCusInfo(CustomerInfo cusInfo) {
		this.cusInfo = cusInfo;
	}
	public HashMap<Product, Integer> getProductList() {
		return productList;
	}
	public void setProductList(HashMap<Product, Integer> productList) {
		this.productList = productList;
	}
	public double getDesireScore() {
		return desireScore;
	}
	public void setDesireScore(double desireScore) {
		this.desireScore = desireScore;
	}
	public Date getEstimatedDate() {
		return estimatedDate;
	}
	public void setEstimatedDate(Date estimatedDate) {
		this.estimatedDate = estimatedDate;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getMaxItem() {
		return maxItem;
	}
	public void setMaxItem(int maxItem) {
		this.maxItem = maxItem;
	}

}