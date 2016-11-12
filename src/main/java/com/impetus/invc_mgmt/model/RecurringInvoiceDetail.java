/**
 * 
 */
package com.impetus.invc_mgmt.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.Entity;

// TODO: Auto-generated Javadoc
/**
 * The Class RecurringInvoiceDetail consist the attributes related to
 * RecurringInvoiceDetail.A pojo class.
 * 
 * @author Ashish
 */
@Entity
@Table(name = "recurringinvoicedetail")
public class RecurringInvoiceDetail {

	/** The recurringinvoicedetailid. */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int recurringinvoicedetailid;

	/** The recurringinvoicedetailquantity. */
	@Column
	private int recurringinvoicedetailquantity;

	/** The recurringinvoicedetailprice. */
	@Column
	private double recurringinvoicedetailprice;

	/** The recurringinvoicedetailamount. */
	@Column
	private double recurringinvoicedetailamount;

	/** The item. */
	@ManyToOne
	@JoinColumn(name = "itemid")
	private Item item;

	/** The recurringinvoice. */
	@ManyToOne
	@JoinColumn(name = "recurringinvoiceid")
	private RecurringInvoice recurringinvoice;

	/**
	 * Instantiates a new recurring invoice detail.
	 */
	public RecurringInvoiceDetail() {
	}

	/**
	 * Instantiates a new recurring invoice detail.
	 * 
	 * @param recurringinvoicedetailid
	 *            the recurringinvoicedetailid
	 * @param recurringinvoicedetailquantity
	 *            the recurringinvoicedetailquantity
	 * @param recurringinvoicedetailprice
	 *            the recurringinvoicedetailprice
	 * @param recurringinvoicedetailamount
	 *            the recurringinvoicedetailamount
	 */
	public RecurringInvoiceDetail(int recurringinvoicedetailid,
			int recurringinvoicedetailquantity,
			double recurringinvoicedetailprice,
			double recurringinvoicedetailamount) {
		super();
		this.recurringinvoicedetailid = recurringinvoicedetailid;
		this.recurringinvoicedetailquantity = recurringinvoicedetailquantity;
		this.recurringinvoicedetailprice = recurringinvoicedetailprice;
		this.recurringinvoicedetailamount = recurringinvoicedetailamount;
	}

	// getter setter
	/**
	 * Gets the recurringinvoicedetailid.
	 * 
	 * @return the recurringinvoicedetailid
	 */
	public int getRecurringinvoicedetailid() {
		return recurringinvoicedetailid;
	}

	/**
	 * Sets the recurringinvoicedetailid.
	 * 
	 * @param recurringinvoicedetailid
	 *            the new recurringinvoicedetailid
	 */
	public void setRecurringinvoicedetailid(int recurringinvoicedetailid) {
		this.recurringinvoicedetailid = recurringinvoicedetailid;
	}

	/**
	 * Gets the recurringinvoicedetailquantity.
	 * 
	 * @return the recurringinvoicedetailquantity
	 */
	public int getRecurringinvoicedetailquantity() {
		return recurringinvoicedetailquantity;
	}

	/**
	 * Sets the recurringinvoicedetailquantity.
	 * 
	 * @param recurringinvoicedetailquantity
	 *            the new recurringinvoicedetailquantity
	 */
	public void setRecurringinvoicedetailquantity(
			int recurringinvoicedetailquantity) {
		this.recurringinvoicedetailquantity = recurringinvoicedetailquantity;
	}

	/**
	 * Gets the recurringinvoicedetailprice.
	 * 
	 * @return the recurringinvoicedetailprice
	 */
	public double getRecurringinvoicedetailprice() {
		return recurringinvoicedetailprice;
	}

	/**
	 * Sets the recurringinvoicedetailprice.
	 * 
	 * @param recurringinvoicedetailprice
	 *            the new recurringinvoicedetailprice
	 */
	public void setRecurringinvoicedetailprice(
			double recurringinvoicedetailprice) {
		this.recurringinvoicedetailprice = recurringinvoicedetailprice;
	}

	/**
	 * Gets the recurringinvoicedetailamount.
	 * 
	 * @return the recurringinvoicedetailamount
	 */
	public double getRecurringinvoicedetailamount() {
		return recurringinvoicedetailamount;
	}

	/**
	 * Sets the recurringinvoicedetailamount.
	 * 
	 * @param recurringinvoicedetailamount
	 *            the new recurringinvoicedetailamount
	 */
	public void setRecurringinvoicedetailamount(
			double recurringinvoicedetailamount) {
		this.recurringinvoicedetailamount = recurringinvoicedetailamount;
	}

	/**
	 * Gets the item.
	 * 
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * Sets the item.
	 * 
	 * @param item
	 *            the new item
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * Gets the recurringinvoice.
	 * 
	 * @return the recurringinvoice
	 */
	public RecurringInvoice getRecurringinvoice() {
		return recurringinvoice;
	}

	/**
	 * Sets the recurringinvoice.
	 * 
	 * @param recurringinvoice
	 *            the new recurringinvoice
	 */
	public void setRecurringinvoice(RecurringInvoice recurringinvoice) {
		this.recurringinvoice = recurringinvoice;
	}

}
