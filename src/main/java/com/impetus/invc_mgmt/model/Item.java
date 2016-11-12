/**
 * 
 */
package com.impetus.invc_mgmt.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Entity;

// TODO: Auto-generated Javadoc
/**
 * The Class Item consist the attributes related to Item.A pojo class.
 * 
 * @author Ashish
 */
@Entity
@Table(name = "item")
public class Item {

	/** The itemid. */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemid;

	/** The itemname. */
	@Column
	private String itemname;

	/** The itemprice. */
	@Column
	private double itemprice;

	/** The tenant. */
	@ManyToOne
	@JoinColumn(name = "tenantid")
	private Tenant tenant;

	/** The invoicedetail. */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	private Set<InvoiceDetail> invoicedetail;

	/** The recurringinvoicedetail. */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	private Set<RecurringInvoiceDetail> recurringinvoicedetail;

	/**
	 * Instantiates a new item.
	 * 
	 */
	public Item() {
	}

	/**
	 * Instantiates a new item.
	 * 
	 * @param itemid
	 *            the itemid
	 * @param itemname
	 *            the itemname
	 * @param itemprice
	 *            the itemprice
	 * @param tenant
	 *            the tenant
	 * @param invoicedetail
	 *            the invoicedetail
	 * @param recurringinvoicedetail
	 *            the recurringinvoicedetail
	 */
	public Item(int itemid, String itemname, double itemprice, Tenant tenant,
			Set<InvoiceDetail> invoicedetail,
			Set<RecurringInvoiceDetail> recurringinvoicedetail) {
		super();
		this.itemid = itemid;
		this.itemname = itemname;
		this.itemprice = itemprice;
		this.tenant = tenant;
		this.invoicedetail = invoicedetail;
		this.recurringinvoicedetail = recurringinvoicedetail;
	}

	// getter setter
	/**
	 * Gets the itemid.
	 * 
	 * @return the itemid
	 */
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
	 * Gets the itemname.
	 * 
	 * @return the itemname
	 */
	public String getItemname() {
		return itemname;
	}

	/**
	 * Sets the itemname.
	 * 
	 * @param itemname
	 *            the new itemname
	 */
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	/**
	 * Gets the itemprice.
	 * 
	 * @return the itemprice
	 */
	public double getItemprice() {
		return itemprice;
	}

	/**
	 * Sets the itemprice.
	 * 
	 * @param itemprice
	 *            the new itemprice
	 */
	public void setItemprice(double itemprice) {
		this.itemprice = itemprice;
	}

	/**
	 * Gets the tenant.
	 * 
	 * @return the tenant
	 */
	public Tenant getTenant() {
		return tenant;
	}

	/**
	 * Sets the tenant.
	 * 
	 * @param tenant
	 *            the new tenant
	 */
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	/**
	 * Gets the invoicedetail.
	 * 
	 * @return the invoicedetail
	 */
	public Set<InvoiceDetail> getInvoicedetail() {
		return invoicedetail;
	}

	/**
	 * Sets the invoicedetail.
	 * 
	 * @param invoicedetail
	 *            the new invoicedetail
	 */
	public void setInvoicedetail(Set<InvoiceDetail> invoicedetail) {
		this.invoicedetail = invoicedetail;
	}

	/**
	 * Gets the recurringinvoicedetail.
	 * 
	 * @return the recurringinvoicedetail
	 */
	public Set<RecurringInvoiceDetail> getRecurringinvoicedetail() {
		return recurringinvoicedetail;
	}

	/**
	 * Sets the recurringinvoicedetail.
	 * 
	 * @param recurringinvoicedetail
	 *            the new recurringinvoicedetail
	 */
	public void setRecurringinvoicedetail(
			Set<RecurringInvoiceDetail> recurringinvoicedetail) {
		this.recurringinvoicedetail = recurringinvoicedetail;
	}

}
