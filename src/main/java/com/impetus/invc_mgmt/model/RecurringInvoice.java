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
 * The Class RecurringInvoice consist the attributes related to
 * RecurringInvoice.A pojo class.
 * 
 * @author Ashish
 */
@Entity
@Table(name = "recurringinvoice")
public class RecurringInvoice {

	/** The recurringinvoiceid. */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int recurringinvoiceid;

	/** The recurringinvoiceprice. */
	@Column
	private double recurringinvoiceprice;

	/** The recurringinvoicetax. */
	@Column
	private double recurringinvoicetax;

	/** The recurringinvoiceissuedate. */
	@Column
	private Date recurringinvoiceissuedate;

	/** The recurringinvoicenote. */
	@Column
	private String recurringinvoicenote;

	/** The recurringinvoiceoccurence. */
	@Column
	private int recurringinvoiceoccurence;

	/** The recurringinvoicefrequency. */
	@Column
	private String recurringinvoicefrequency;

	/** The tenant. */
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "tenantid")
	private Tenant tenant;

	/** The client. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clientid")
	private Client client;

	/** The user. */
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "userid")
	private User user;

	/** The recurringinvoicedetail. */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "recurringinvoice")
	@JsonIgnore
	private Set<RecurringInvoiceDetail> recurringinvoicedetail;

	/**
	 * Instantiates a new recurring invoice.
	 * 
	 */
	public RecurringInvoice() {
	}

	/**
	 * Instantiates a new recurring invoice.
	 * 
	 * @param recurringinvoiceid
	 *            the recurringinvoiceid
	 * @param recurringinvoiceprice
	 *            the recurringinvoiceprice
	 * @param recurringinvoicetax
	 *            the recurringinvoicetax
	 * @param recurringinvoiceissuedate
	 *            the recurringinvoiceissuedate
	 * @param recurringinvoicenote
	 *            the recurringinvoicenote
	 * @param recurringinvoiceoccurence
	 *            the recurringinvoiceoccurence
	 * @param recurringinvoicefrequency
	 *            the recurringinvoicefrequency
	 * @param tenant
	 *            the tenant
	 * @param client
	 *            the client
	 * @param user
	 *            the user
	 * @param recurringinvoicedetail
	 *            the recurringinvoicedetail
	 */
	public RecurringInvoice(int recurringinvoiceid,
			double recurringinvoiceprice, double recurringinvoicetax,
			Date recurringinvoiceissuedate, String recurringinvoicenote,
			int recurringinvoiceoccurence, String recurringinvoicefrequency,
			Tenant tenant, Client client, User user,
			Set<RecurringInvoiceDetail> recurringinvoicedetail) {
		super();
		this.recurringinvoiceid = recurringinvoiceid;
		this.recurringinvoiceprice = recurringinvoiceprice;
		this.recurringinvoicetax = recurringinvoicetax;
		this.recurringinvoiceissuedate = recurringinvoiceissuedate;
		this.recurringinvoiceoccurence = recurringinvoiceoccurence;
		this.recurringinvoicenote = recurringinvoicenote;

		this.recurringinvoicefrequency = recurringinvoicefrequency;
		this.tenant = tenant;
		this.client = client;
		this.user = user;
		this.recurringinvoicedetail = recurringinvoicedetail;
	}

	/**
	 * Gets the recurringinvoiceoccurence.
	 * 
	 * @return the recurringinvoiceoccurence
	 */
	public int getRecurringinvoiceoccurence() {
		return recurringinvoiceoccurence;
	}

	/**
	 * Sets the recurringinvoiceoccurence.
	 * 
	 * @param recurringinvoiceoccurence
	 *            the new recurringinvoiceoccurence
	 */
	public void setRecurringinvoiceoccurence(int recurringinvoiceoccurence) {
		this.recurringinvoiceoccurence = recurringinvoiceoccurence;
	}

	// getter setter
	/**
	 * Gets the recurringinvoiceid.
	 * 
	 * @return the recurringinvoiceid
	 */
	public int getRecurringinvoiceid() {
		return recurringinvoiceid;
	}

	/**
	 * Sets the recurringinvoiceid.
	 * 
	 * @param recurringinvoiceid
	 *            the new recurringinvoiceid
	 */
	public void setRecurringinvoiceid(int recurringinvoiceid) {
		this.recurringinvoiceid = recurringinvoiceid;
	}

	/**
	 * Gets the recurringinvoiceprice.
	 * 
	 * @return the recurringinvoiceprice
	 */
	public double getRecurringinvoiceprice() {
		return recurringinvoiceprice;
	}

	/**
	 * Sets the recurringinvoiceprice.
	 * 
	 * @param recurringinvoiceprice
	 *            the new recurringinvoiceprice
	 */
	public void setRecurringinvoiceprice(double recurringinvoiceprice) {
		this.recurringinvoiceprice = recurringinvoiceprice;
	}

	/**
	 * Gets the recurringinvoicetax.
	 * 
	 * @return the recurringinvoicetax
	 */
	public double getRecurringinvoicetax() {
		return recurringinvoicetax;
	}

	/**
	 * Sets the recurringinvoicetax.
	 * 
	 * @param recurringinvoicetax
	 *            the new recurringinvoicetax
	 */
	public void setRecurringinvoicetax(double recurringinvoicetax) {
		this.recurringinvoicetax = recurringinvoicetax;
	}

	/**
	 * Gets the recurringinvoiceissuedate.
	 * 
	 * @return the recurringinvoiceissuedate
	 */
	public Date getRecurringinvoiceissuedate() {
		return recurringinvoiceissuedate;
	}

	/**
	 * Sets the recurringinvoiceissuedate.
	 * 
	 * @param recurringinvoiceissuedate
	 *            the new recurringinvoiceissuedate
	 */
	public void setRecurringinvoiceissuedate(Date recurringinvoiceissuedate) {
		this.recurringinvoiceissuedate = recurringinvoiceissuedate;
	}

	/**
	 * Gets the recurringinvoicenote.
	 * 
	 * @return the recurringinvoicenote
	 */
	public String getRecurringinvoicenote() {
		return recurringinvoicenote;
	}

	/**
	 * Sets the recurringinvoicenote.
	 * 
	 * @param recurringinvoicenote
	 *            the new recurringinvoicenote
	 */
	public void setRecurringinvoicenote(String recurringinvoicenote) {
		this.recurringinvoicenote = recurringinvoicenote;
	}

	/**
	 * Gets the recurringinvoicefrequency.
	 * 
	 * @return the recurringinvoicefrequency
	 */
	public String getRecurringinvoicefrequency() {
		return recurringinvoicefrequency;
	}

	/**
	 * Sets the recurringinvoicefrequency.
	 * 
	 * @param recurringinvoicefrequency
	 *            the new recurringinvoicefrequency
	 */
	public void setRecurringinvoicefrequency(String recurringinvoicefrequency) {
		this.recurringinvoicefrequency = recurringinvoicefrequency;
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
