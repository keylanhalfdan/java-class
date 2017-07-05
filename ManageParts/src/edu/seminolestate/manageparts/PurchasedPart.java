package edu.seminolestate.manageparts;
/*
 * Author:	Robert Kaye
 * Date:	6/15/2017
 * Purpose:	A service subclass for managing purchased parts
 */
public class PurchasedPart extends Part{
	// declaring variables
	private double purchasePrice; //what does this part cost to buy?
	private String vendor;  //who do we buy this part from?
	private double handlingCost; //shipping and handling costs when we buy it
	public static final String DEFAULT_VENDOR_NAME = "no vendor name";
	public static final double DEFAULT_PURCHASE_PRICE = 0;
	public static final double DEFAULT_HANDLING_COST = 0; 
	
	// constructor to create a new purchased part with a part ID, taking other default values from both Part and PurchasedPart classes
	public PurchasedPart(int ID) {
		this(ID, DEFAULT_DESCRIPTION, DEFAULT_SELL_PRICE, DEFAULT_HANDLING_COST, DEFAULT_PURCHASE_PRICE, DEFAULT_VENDOR_NAME);
	}
	
	// constructor to create a new purchased part with a part ID, handling cost, purchased price and vendor,
	// taking other default values from both Part and PurchasedPart classes
	public PurchasedPart(int ID, double hCost, double pPrice, String vendor) {
		this(ID, DEFAULT_DESCRIPTION, DEFAULT_SELL_PRICE, hCost, pPrice, vendor);
	}
	
	// constructor to create a new part with all info
	public PurchasedPart(int ID, String desc, double sellPrice, double hCost, double pPrice, String vendor) {
		super(ID, desc, sellPrice);
		this.handlingCost = DEFAULT_HANDLING_COST;
		this.purchasePrice = DEFAULT_PURCHASE_PRICE;
		this.vendor = DEFAULT_VENDOR_NAME;
		
		this.setHandlingCost(hCost);
		this.setPurchasePrice(pPrice);
		this.setVendor(vendor);
	}
	
	// method to get total cost that overrides the one in the Part class
	@Override
	public double getTotalCost() {
		return super.getTotalCost() + handlingCost + purchasePrice;
	}
	
	// method to get the handling cost
	public double getHandlingCost() {
		return handlingCost;
	}
	
	// method to get the purchase price
	public double getPurchasePrice() {
		return purchasePrice;
	}
	
	// method to get vendor name
	public String getVendor() {
		return vendor;	
	}
	
	// method to set handling cost if the cost is greater than or equal to zero
	public void setHandlingCost(double newCost) {
		if (newCost >= 0)
			this.handlingCost = newCost;
	}
	
	// method to set purchase price is the price is greater than or equal to zero
	public void setPurchasePrice(double newPrice) {
		if (newPrice >= 0)
			this.purchasePrice = newPrice;
	}
	
	// method to set the vendor name if the name is not null and has a length greater than 0
	public void setVendor(String newVendor) {
		if (newVendor != null && newVendor.length() > 0)
			this.vendor = newVendor;
	}
	
	// method to display toString, overrides the one in the Part class and uses getClass() to display that followed by data from variables
	@Override
	public String toString() {
		return super.toString() + 
			" [partID=" + getPartID() + ", partDescription=" + getPartDescription() + ", partSellPrice=" + getPartSellPrice()
			+ ", purchasePrice=" + getPurchasePrice() + ", handlingCost=" + getHandlingCost() + ", vendor=" + getVendor() + "]"; 
	}
	
}
