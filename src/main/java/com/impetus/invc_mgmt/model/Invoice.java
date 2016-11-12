/**
 * 
 */
package com.impetus.invc_mgmt.model;

import java.util.Date;
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

import org.codehaus.jackson.annotate.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class Invoice consist the attributes related to Invoice.A pojo class.
 * 
 * @author Ashish
 */
@Entity
@Table(name = "invoice")
public class Invoice {

	/** The invoiceid. */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int invoiceid;

	/** The invoiceprice. */
	@Column
	private double invoiceprice;

	/** The invoicetax. */
	@Column
	private double invoicetax;

	/** The invoiceissuedate. */
	@Column
	private Date invoiceissuedate;

	/** The invoiceduedate. */
	@Column
	private Date invoiceduedate;

	/** The invoicenote. */
	@Column
	private String invoicenote;

	/** The invoicestatus. */
	@Column
	private String invoicestatus;

	/** The invoicepaydate. */
	@Column
	private Date invoicepaydate;

	/** The client. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clientid")
	private Client client;

	/** The tenant. */
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "tenantid")
	private Tenant tenant;

	/** The user. */
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "userid")
	private User user;

	/** The invoicedetail. */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "invoice")
	@JsonIgnore
	private Set<InvoiceDetail> invoicedetail;

	/**
	 * Instantiates a new invoice.
	 * 
	 */
	public Invoice() {
	}

	/**
	 * Instantiates a new invoice.
	 * 
	 * @param invoiceid
	 *            the invoiceid
	 * @param invoiceprice
	 *            the invoiceprice
	 * @param invoicetax
	 *            the invoicetax
	 * @param invoiceissuedate
	 *            the invoiceissuedate
	 * @param invoiceduedate
	 *            the invoiceduedate
	 * @param invoicenote
	 *            the invoicenote
	 * @param invoicestatus
	 *            the invoicestatus
	 * @param invoicepaydate
	 *            the invoicepaydate
	 * @param client
	 *            the client
	 * @param tenant
	 *            the tenant
	 * @param user
	 *            the user
	 * @param invoicedetail
	 *            the invoicedetail
	 */
	public Invoice(int invoiceid, double invoiceprice, double invoicetax,
			Date invoiceissuedate, Date invoiceduedate, String invoicenote,
			String invoicestatus, Date invoicepaydate, Client client,
			Tenant tenant, User user, Set<InvoiceDetail> invoicedetail) {
		super();
		this.invoiceid = invoiceid;
		this.invoiceprice = invoiceprice;
		this.invoicetax = invoicetax;
		this.invoiceissuedate = invoiceissuedate;
		this.invoiceduedate = invoiceduedate;
		this.invoicenote = invoicenote;
		this.invoicestatus = invoicestatus;
		this.invoicepaydate = invoicepaydate;
		this.client = client;
		this.tenant = tenant;
		this.user = user;
		this.invoicedetail = invoicedetail;
	}

	// getter setter
	/**
	 * Gets the invoiceid.
	 * 
	 * @return the invoiceid
	 */
	public int getInvoiceid() {
		return invoiceid;
	}

	/**
	 * Sets the invoiceid.
	 * 
	 * @param invoiceid
	 *            the new invoiceid
	 */
	public void setInvoiceid(int invoiceid) {
		this.invoiceid = invoiceid;
	}

	/**
	 * Gets the invoiceprice.
	 * 
	 * @return the invoiceprice
	 */
	public double getInvoiceprice() {
		return invoiceprice;
	}

	/**
	 * Sets the invoiceprice.
	 * 
	 * @param invoiceprice
	 *            the new invoiceprice
	 */
	public void setInvoiceprice(double invoiceprice) {
		this.invoiceprice = invoiceprice;
	}

	/**
	 * Gets the invoicetax.
	 * 
	 * @return the invoicetax
	 */
	public double getInvoicetax() {
		return invoicetax;
	}

	/**
	 * Sets the invoicetax.
	 * 
	 * @param invoicetax
	 *            the new invoicetax
	 */
	public void setInvoicetax(double invoicetax) {
		this.invoicetax = invoicetax;
	}

	/**
	 * Gets the invoiceissuedate.
	 * 
	 * @return the invoiceissuedate
	 */
	public Date getInvoiceissuedate() {
		return invoiceissuedate;
	}

	/**
	 * Sets the invoiceissuedate.
	 * 
	 * @param invoiceissuedate
	 *            the new invoiceissuedate
	 */
	public void setInvoiceissuedate(Date invoiceissuedate) {
		this.invoiceissuedate = invoiceissuedate;
	}

	/**
	 * Gets the invoiceduedate.
	 * 
	 * @return the invoiceduedate
	 */
	public Date getInvoiceduedate() {
		return invoiceduedate;
	}

	/**
	 * Sets the invoiceduedate.
	 * 
	 * @param invoiceduedate
	 *            the new invoiceduedate
	 */
	public void setInvoiceduedate(Date invoiceduedate) {
		this.invoiceduedate = invoiceduedate;
	}

	/**
	 * Gets the invoicenote.
	 * 
	 * @return the invoicenote
	 */
	public String getInvoicenote() {
		return invoicenote;
	}

	/**
	 * Sets the invoicenote.
	 * 
	 * @param invoicenote
	 *            the new invoicenote
	 */
	public void setInvoicenote(String invoicenote) {
		this.invoicenote = invoicenote;
	}

	/**
	 * Gets the invoicestatus.
	 * 
	 * @return the invoicestatus
	 */
	public String getInvoicestatus() {
		return invoicestatus;
	}

	/**
	 * Sets the invoicestatus.
	 * 
	 * @param invoicestatus
	 *            the new invoicestatus
	 */
	public void setInvoicestatus(String invoicestatus) {
		this.invoicestatus = invoicestatus;
	}

	/**
	 * Gets the invoicepaydate.
	 * 
	 * @return the invoicepaydate
	 */
	public Date getInvoicepaydate() {
		return invoicepaydate;
	}

	/**
	 * Sets the invoicepaydate.
	 * 
	 * @param invoicepaydate
	 *            the new invoicepaydate
	 */
	public void setInvoicepaydate(Date invoicepaydate) {
		this.invoicepaydate = invoicepaydate;
	}

	/**
	 * Gets the client.
	 * 
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Sets the client.
	 * 
	 * @param client
	 *            the new client
	 */
	public void setClient(Client client) {
		this.client = client;
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
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 * 
	 * @param user
	 *            the new user
	 */
	public void setUser(User user) {
		this.user = user;
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

}