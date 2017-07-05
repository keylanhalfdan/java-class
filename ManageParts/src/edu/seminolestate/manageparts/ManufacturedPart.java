package edu.seminolestate.manageparts;
/*
 * Author:	Robert Kaye
 * Date:	6/15/2017
 * Purpose:	A service subclass for managing manufactured parts
 */
public class ManufacturedPart extends Part{
	// declare variables
	private double laborCost;//cost to make part 
	private double materialCost;//amount of material in product
	public static final double DEFAULT_LABOR_COST = 0;
	public static final double DEFAULT_MATERIAL_COST = 0;
	
	// constructor to create a new manufactured part with a part ID, taking other default values from both Part and PurchasedPart classes
	public ManufacturedPart(int id) {
		this(id, DEFAULT_DESCRIPTION, DEFAULT_SELL_PRICE, DEFAULT_LABOR_COST, DEFAULT_MATERIAL_COST);
	}
	
	// constructor to create a new manufactured part with a part ID, labor cost and material cost,
	// taking other default values from both Part and PurchasedPart classes
	public ManufacturedPart(int id, double lCost, double mCost) {
		this(id, DEFAULT_DESCRIPTION, DEFAULT_SELL_PRICE, lCost, mCost);
	}
	// constructor to create a new part with all info
	public ManufacturedPart(int id, String desc, double sellPrice, double lCost, double mCost) {
		super(id, desc, sellPrice);
		this.laborCost = DEFAULT_LABOR_COST;
		this.materialCost = DEFAULT_MATERIAL_COST;
		
		this.setLaborCost(lCost);
		this.setMaterialCost(mCost);
	}
	
	// method to get total cost that overrides the one in the Part class
	@Override
	public double getTotalCost() {
		return super.getTotalCost() + materialCost + laborCost;
	}
	
	// method to get labor cost
	public double getLaborCost() {
		return laborCost;
	}
	
	//method to get the material cost
	public double getMaterialCost() {
		return materialCost;
	}
	
	// method to set a new labor cost if the cost is greater than or equal to zero 
	public void setLaborCost(double newLaborCost) {
		if (newLaborCost >= 0)
			this.laborCost = newLaborCost;
	}
	
	// method to set a new material cost if the cost is greater than or equal to zero
	public void setMaterialCost(double newMaterialCost) {
		if (newMaterialCost >= 0)
			this.materialCost = newMaterialCost;
	}
	
	// method to display toString, overrides the one in the Part class and uses getClass() to display that followed by data from variables
	@Override
	public String toString() {
		return super.toString() + 
			" [partID=" + getPartID() + ", partDescription=" + getPartDescription() + ", partSellPrice=" + getPartSellPrice()
			+ ", laborCost=" + getLaborCost() + ", materialCost=" + getMaterialCost() + "]"; 
	}
}
