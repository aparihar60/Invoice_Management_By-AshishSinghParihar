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
 * The Class InvoiceDetail consist the attributes related to InvoiceDetail.A
 * pojo class.
 * 
 * @author Ashish
 */
@Entity
@Table(name = "invoicedetail")
public class InvoiceDetail {

	/** The invoicedetailid. */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int invoicedetailid;

	/** The invoicedetailquantity. */
	@Column
	private int invoicedetailquantity;

	/** The invoicedetailitemprice. */
	@Column
	private double invoicedetailitemprice;

	/** The invoicedetailamount. */
	@Column
	private double invoicedetailamount;

	/** The invoice. */
	@ManyToOne
	@JoinColumn(name = "invoiceid")
	private Invoice invoice;

	/** The item. */
	@ManyToOne
	@JoinColumn(name = "itemid")
	private Item item;

	/**
	 * Instantiates a new invoice detail.
	 * 
	 * @param invoicedetailid
	 *            the invoicedetailid
	 * @param invoicedetailquantity
	 *            the invoicedetailquantity
	 * @param invoicedetailitemprice
	 *            the invoicedetailitemprice
	 * @param invoicedetailamount
	 *            the invoicedetailamount
	 */
	public InvoiceDetail(int invoicedetailid, int invoicedetailquantity,
			double invoicedetailitemprice, double invoicedetailamount) {
		super();
		this.invoicedetailid = invoicedetailid;
		this.invoicedetailquantity = invoicedetailquantity;
		this.invoicedetailitemprice = invoicedetailitemprice;
		this.invoicedetailamount = invoicedetailamount;
	}

	/**
	 * Instantiates a new invoice detail.
	 */
	public InvoiceDetail() {
		// TODO Auto-generated constructor stub
	}

	// getter setter
	/**
	 * Gets the invoicedetailid.
	 * 
	 * @return the invoicedetailid
	 */
	public int getInvoicedetailid() {
		return invoicedetailid;
	}

	/**
	 * Sets the invoicedetailid.
	 * 
	 * @param invoicedetailid
	 *            the new invoicedetailid
	 */
	public void setInvoicedetailid(int invoicedetailid) {
		this.invoicedetailid = invoicedetailid;
	}

	/**
	 * Gets the invoicedetailquantity.
	 * 
	 * @return the invoicedetailquantity
	 */
	public int getInvoicedetailquantity() {
		return invoicedetailquantity;
	}

	/**
	 * Sets the invoicedetailquantity.
	 * 
	 * @param invoicedetailquantity
	 *            the new invoicedetailquantity
	 */
	public void setInvoicedetailquantity(int invoicedetailquantity) {
		this.invoicedetailquantity = invoicedetailquantity;
	}

	/**
	 * Gets the invoicedetailitemprice.
	 * 
	 * @return the invoicedetailitemprice
	 */
	public double getInvoicedetailitemprice() {
		return invoicedetailitemprice;
	}

	/**
	 * Sets the invoicedetailitemprice.
	 * 
	 * @param invoicedetailitemprice
	 *            the new invoicedetailitemprice
	 */
	public void setInvoicedetailitemprice(double invoicedetailitemprice) {
		this.invoicedetailitemprice = invoicedetailitemprice;
	}

	/**
	 * Gets the invoicedetailamount.
	 * 
	 * @return the invoicedetailamount
	 */
	public double getInvoicedetailamount() {
		return invoicedetailamount;
	}

	/**
	 * Sets the invoicedetailamount.
	 * 
	 * @param invoicedetailamount
	 *            the new invoicedetailamount
	 */
	public void setInvoicedetailamount(double invoicedetailamount) {
		this.invoicedetailamount = invoicedetailamount;
	}

	/**
	 * Gets the invoice.
	 * 
	 * @return the invoice
	 */
	public Invoice getInvoice() {
		return invoice;
	}

	/**
	 * Sets the invoice.
	 * 
	 * @param invoice
	 *            the new invoice
	 */
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
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

}
