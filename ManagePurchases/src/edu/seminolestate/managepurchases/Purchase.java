package edu.seminolestate.managepurchases;

import java.time.LocalDate;
/*
 * Author:	Robert Kaye
 * Date:	6/24/2017
 * Purpose:	A service class for creating and managing purchase objects
 */
public class Purchase {
	// declare variables
	private String productName;
	private String storeName;
	private LocalDate purchaseDate;
	private double cost;

	// constructor taking 4 variables
	public Purchase(String newProduct, String newStore, LocalDate newDate, double newCost) throws InvalidArgumentException {
		this.setProductName(newProduct);
		this.setStoreName(newStore);
		this.setPurchaseDate(newDate);
		this.setCost(newCost);
	} // end constructor

	// custom toString with getClass and all variables
	public String toString() {
		return super.getClass() + 
			" [productName:" + getProductName() + 
			", storeName:" + getStoreName() + 
			", purchaseDate:" + getPurchaseDate() + 
			", cost:" + getCost() + "]";
	} // end toString

	// getter for productName
	public String getProductName() {
		return productName;
	} // end getProductName

	// setter for productName
	public void setProductName(String newProduct) throws InvalidArgumentException {
		// if newProduct is a not null and its length is greater than 0, assign to productName
		if (newProduct != null && newProduct.length() >0)
			this.productName = newProduct;
		// else throw exception
		else {
			InvalidArgumentException e = 
					new InvalidArgumentException("Product name cannot be null or blank - " + newProduct);
			throw e;
		} // end else
	} // end setProductName

	// getter for storeName
	public String getStoreName() {
		return storeName;
	} // end getStoreName

	// setter for storeName
	public void setStoreName(String newStore) throws InvalidArgumentException {
		// if newStore is a not null and its length is greater than 0, assign to storeName
		if (newStore != null && newStore.length() >0)
			this.storeName = newStore;
		// else throw exception
		else {
			InvalidArgumentException e = 
					new InvalidArgumentException("Store name cannot be null or blank - " + newStore);
			throw e;
		} // end else
	} // end setStoreName

	// getter for purchaseDate
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	} // end getPurchaseDate

	// setter for purchaseDate
	public void setPurchaseDate(LocalDate newDate) throws InvalidArgumentException {
		// if newDate is a not null assign to purchaseDate
		if (newDate != null) {
			this.purchaseDate = 
				LocalDate.of(newDate.getYear(), newDate.getMonth(), newDate.getDayOfMonth());
		} // end if
		else {
			throw new InvalidArgumentException("Invalid date");
		} // end else
	} // end setPurchaseDate

	// getter for cost
	public double getCost() {
		return cost;
	} // end getCost

	//setter for cost
	public void setCost(double newCost) {
		// if newCost is greater than or equal to 0, assign to cost 
		if (newCost >= 0) {
			this.cost = newCost;
		} // end if
		else {	
		} // end else
	} // end setCost
} // end Purchase class