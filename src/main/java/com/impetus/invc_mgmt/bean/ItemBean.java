package com.impetus.invc_mgmt.bean;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemBean consist the attributes of item and their getter/setter.
 */
public class ItemBean {

	/** The item id. */
	private int itemid;

	/** The item name. */
	private String itemname;

	/** The item price. */
	private double itemprice;

	/**
	 * Gets the item id.
	 * 
	 * @return the itemid
	 */

	// getter setter
	public int getItemid() {
		return itemid;
	}

	/**
	 * Sets the itemid.
	 * 
	 * @param itemid
	 *            the new itemid
	 */
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	/**
	 * Gets the item name.
	 * 
	 * @return the item name
	 */
	public String getItemname() {
		return itemname;
	}

	/**
	 * Sets the item name.
	 * 
	 * @param item
	 *            name the new item name
	 */
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	/**
	 * Gets the item price.
	 * 
	 * @return the item price
	 */
	public double getItemprice() {
		return itemprice;
	}

	/**
	 * Sets the item price.
	 * 
	 * @param item
	 *            price the new itemprice
	 */
	public void setItemprice(double itemprice) {
		this.itemprice = itemprice;
	}

}
