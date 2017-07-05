package edu.seminolestate.manageparts;
/*
 * Author:	Robert Kaye
 * Date:	6/15/2017
 * Purpose:	A service superclass for managing parts
 */
public class Part {
	// declaring variables
	private int partID;
	private String partDescription;
	private double partSellPrice;
	public static final String DEFAULT_DESCRIPTION = "no part description";
	public static final double DEFAULT_SELL_PRICE = 0;
	
	// constructor for creating a part with a part ID and a default description and sell price
	public Part(int ID) {
		this(ID, DEFAULT_DESCRIPTION, DEFAULT_SELL_PRICE);
	}
	
	// constructor for creating a part with a part ID, description and a sell price
	public Part(int ID, String desc, double sellPrice) {
		this.partDescription = DEFAULT_DESCRIPTION;
		this.partSellPrice = DEFAULT_SELL_PRICE;
		
		this.setPartID(ID);
		this.setPartDescription(desc); 
		this.setPartSellPrice(sellPrice);		
	}
	
	// method to get total cost (defaults to 0)
	public double getTotalCost() {
		double totalCost = 0.0;
		return totalCost;
	}
	
	// method to get the part ID
	public int getPartID() {
		return partID;
	}
	
	// method to get the part description
	public String getPartDescription() {
		return partDescription;
	}
	
	// method to get the sell price
	public double getPartSellPrice() {
		return partSellPrice;
	}
	
	// method to set a part ID
	public void setPartID(int newPartID) {
		if (newPartID >= 0)
			this.partID = newPartID;
	}
	
	// method to set description
	public void setPartDescription(String newPartDescription) {
		if (newPartDescription != null && newPartDescription.length() > 0)
			this.partDescription = newPartDescription;
	}
	
	//method to set sell price
	public void setPartSellPrice(double newPartSellPrice) {
		if (newPartSellPrice >= 0)
			this.partSellPrice = newPartSellPrice;
	}
	
	// method to do standard toString with getClass() option added to the front
	public String toString() {
		return this.getClass() + "";
	}
	
	
}
