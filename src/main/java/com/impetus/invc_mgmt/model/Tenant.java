/**
 * 
 */
package com.impetus.invc_mgmt.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Tenant consist the attributes related to Tenant.A pojo class.
 * 
 * @author Ashish
 */
@Entity
@Table(name = "tenant")
public class Tenant {

	/** The Constant TENANTA. */
	private static final String TENANTA = "tenant";
	/** The tenantid. */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tenantid;

	/** The tenantname. */
	@Column
	private String tenantname;

	/** The tenantaddress. */
	@Column
	private String tenantaddress;

	/** The tenantemail. */
	@Column
	private String tenantemail;

	/** The tenantcontactno. */
	@Column
	private Long tenantcontactno;

	/** The dateformat. */
	@Column
	private String dateformat;

	/** The currencyformat. */
	@Column
	private String currencyformat;

	/** The thankyoumail. */
	@Column
	private int thankyoumail;

	/** The remindermail. */
	@Column
	private int remindermail;

	/** The user. */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = TENANTA)
	private Set<User> user;

	/** The client. */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = TENANTA)
	private Set<Client> client;

	/** The invoice. */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = TENANTA)
	private Set<Invoice> invoice;

	/** The recurringinvoice. */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = TENANTA)
	private Set<RecurringInvoice> recurringinvoice;

	/** The item. */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = TENANTA)
	private Set<Item> item;

	/**
	 * Instantiates a new tenant.
	 */
	public Tenant() {
	}

	/**
	 * Instantiates a new tenant.
	 * 
	 * @param tenantid
	 *            the tenantid
	 * @param tenantname
	 *            the tenantname
	 * @param tenantaddress
	 *            the tenantaddress
	 * @param tenantemail
	 *            the tenantemail
	 * @param tenantcontactno
	 *            the tenantcontactno
	 * @param dateformat
	 *            the dateformat
	 * @param currencyformat
	 *            the currencyformat
	 * @param thankyoumail
	 *            the thankyoumail
	 * @param remindermail
	 *            the remindermail
	 */
	public Tenant(int tenantid, String tenantname, String tenantaddress,
			String tenantemail, Long tenantcontactno, String dateformat,
			String currencyformat, int thankyoumail, int remindermail) {
		super();
		this.tenantid = tenantid;
		this.tenantname = tenantname;
		this.tenantaddress = tenantaddress;
		this.tenantemail = tenantemail;
		this.tenantcontactno = tenantcontactno;
		this.dateformat = dateformat;
		this.currencyformat = currencyformat;
		this.thankyoumail = thankyoumail;
		this.remindermail = remindermail;
	}

	// getter setter
	/**
	 * Gets the tenantid.
	 * 
	 * @return the tenantid
	 */
	public int getTenantid() {
		return tenantid;
	}

	/**
	 * Sets the tenantid.
	 * 
	 * @param tenantid
	 *            the new tenantid
	 */
	public void setTenantid(int tenantid) {
		this.tenantid = tenantid;
	}

	/**
	 * Gets the tenantname.
	 * 
	 * @return the tenantname
	 */
	public String getTenantname() {
		return tenantname;
	}

	/**
	 * Sets the tenantname.
	 * 
	 * @param tenantname
	 *            the new tenantname
	 */
	public void setTenantname(String tenantname) {
		this.tenantname = tenantname;
	}

	/**
	 * Gets the tenantaddress.
	 * 
	 * @return the tenantaddress
	 */
	public String getTenantaddress() {
		return tenantaddress;
	}

	/**
	 * Sets the tenantaddress.
	 * 
	 * @param tenantaddress
	 *            the new tenantaddress
	 */
	public void setTenantaddress(String tenantaddress) {
		this.tenantaddress = tenantaddress;
	}

	/**
	 * Gets the tenantemail.
	 * 
	 * @return the tenantemail
	 */
	public String getTenantemail() {
		return tenantemail;
	}

	/**
	 * Sets the tenantemail.
	 * 
	 * @param tenantemail
	 *            the new tenantemail
	 */
	public void setTenantemail(String tenantemail) {
		this.tenantemail = tenantemail;
	}

	/**
	 * Gets the tenantcontactno.
	 * 
	 * @return the tenantcontactno
	 */
	public Long getTenantcontactno() {
		return tenantcontactno;
	}

	/**
	 * Sets the tenantcontactno.
	 * 
	 * @param tenantcontactno
	 *            the new tenantcontactno
	 */
	public void setTenantcontactno(Long tenantcontactno) {
		this.tenantcontactno = tenantcontactno;
	}

	/**
	 * Gets the dateformat.
	 * 
	 * @return the dateformat
	 */
	public String getDateformat() {
		return dateformat;
	}

	/**
	 * Sets the dateformat.
	 * 
	 * @param dateformat
	 *            the new dateformat
	 */
	public void setDateformat(String dateformat) {
		this.dateformat = dateformat;
	}

	/**
	 * Gets the currencyformat.
	 * 
	 * @return the currencyformat
	 */
	public String getCurrencyformat() {
		return currencyformat;
	}

	/**
	 * Sets the currencyformat.
	 * 
	 * @param currencyformat
	 *            the new currencyformat
	 */
	public void setCurrencyformat(String currencyformat) {
		this.currencyformat = currencyformat;
	}

	/**
	 * Gets the thankyoumail.
	 * 
	 * @return the thankyoumail
	 */
	public int getThankyoumail() {
		return thankyoumail;
	}

	/**
	 * Sets the thankyoumail.
	 * 
	 * @param thankyoumail
	 *            the new thankyoumail
	 */
	public void setThankyoumail(int thankyoumail) {
		this.thankyoumail = thankyoumail;
	}

	/**
	 * Gets the remindermail.
	 * 
	 * @return the remindermail
	 */
	public int getRemindermail() {
		return remindermail;
	}

	/**
	 * Sets the remindermail.
	 * 
	 * @param remindermail
	 *            the new remindermail
	 */
	public void setRemindermail(int remindermail) {
		this.remindermail = remindermail;
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public Set<User> getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 * 
	 * @param user
	 *            the new user
	 */
	public void setUser(Set<User> user) {
		this.user = user;
	}

	/**
	 * Gets the client.
	 * 
	 * @return the client
	 */
	public Set<Client> getClient() {
		return client;
	}

	/**
	 * Sets the client.
	 * 
	 * @param client
	 *            the new client
	 */
	public void setClient(Set<Client> client) {
		this.client = client;
	}

	/**
	 * Gets the invoice.
	 * 
	 * @return the invoice
	 */
	public Set<Invoice> getInvoice() {
		return invoice;
	}

	/**
	 * Sets the invoice.
	 * 
	 * @param invoice
	 *            the new invoice
	 */
	public void setInvoice(Set<Invoice> invoice) {
		this.invoice = invoice;
	}

	/**
	 * Gets the recurringinvoice.
	 * 
	 * @return the recurringinvoice
	 */
	public Set<RecurringInvoice> getRecurringinvoice() {
		return recurringinvoice;
	}

	/**
	 * Sets the recurringinvoice.
	 * 
	 * @param recurringinvoice
	 *            the new recurringinvoice
	 */
	public void setRecurringinvoice(Set<RecurringInvoice> recurringinvoice) {
		this.recurringinvoice = recurringinvoice;
	}

	/**
	 * Gets the item.
	 * 
	 * @return the item
	 */
	public Set<Item> getItem() {
		return item;
	}

	/**
	 * Sets the item.
	 * 
	 * @param item
	 *            the new item
	 */
	public void setItem(Set<Item> item) {
		this.item = item;
	}
}
