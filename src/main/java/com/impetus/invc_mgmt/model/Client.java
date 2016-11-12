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

import org.codehaus.jackson.annotate.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class Client consist the attributes related to client.A pojo class.
 * 
 * @author Ashish
 */
@Entity
@Table(name = "client")
public class Client {

	/** The Client Id. */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int clientid;

	/** The First Name. */
	@Column
	private String clientfname;

	/** The last name. */
	@Column
	private String clientlname;

	/** The clientaddress. */
	@Column
	private String clientaddress;

	/** The clientemail. */
	@Column
	private String clientemail;

	/** The clientcontactno. */
	@Column
	private Long clientcontactno;

	/** The clientcompany. */
	@Column
	private String clientcompany;

	/** The tenant. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "tenantid")
	private Tenant tenant;

	/** The invoice. */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	@JsonIgnore
	private Set<Invoice> invoice;

	/** The recurringinvoice. */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	@JsonIgnore
	private Set<RecurringInvoice> recurringinvoice;

	/**
	 * Instantiates a new client.
	 * 
	 */
	public Client() {
	}

	/**
	 * Instantiates a new client.
	 * 
	 * @param clientid
	 *            the clientid
	 * @param clientfname
	 *            the clientfname
	 * @param clientlname
	 *            the clientlname
	 * @param clientaddress
	 *            the clientaddress
	 * @param clientemail
	 *            the clientemail
	 * @param clientcontactno
	 *            the clientcontactno
	 * @param clientcompany
	 *            the clientcompany
	 */
	public Client(int clientid, String clientfname, String clientlname,
			String clientaddress, String clientemail, Long clientcontactno,
			String clientcompany) {
		super();
		this.clientid = clientid;
		this.clientfname = clientfname;
		this.clientlname = clientlname;
		this.clientaddress = clientaddress;
		this.clientemail = clientemail;
		this.clientcontactno = clientcontactno;
		this.clientcompany = clientcompany;
	}

	// getter setter
	/**
	 * Gets the clientid.
	 * 
	 * @return the clientid
	 */
	public int getClientid() {
		return clientid;
	}

	/**
	 * Sets the clientid.
	 * 
	 * @param clientid
	 *            the new clientid
	 */
	public void setClientid(int clientid) {
		this.clientid = clientid;
	}

	/**
	 * Gets the clientfname.
	 * 
	 * @return the clientfname
	 */
	public String getClientfname() {
		return clientfname;
	}

	/**
	 * Sets the clientfname.
	 * 
	 * @param clientfname
	 *            the new clientfname
	 */
	public void setClientfname(String clientfname) {
		this.clientfname = clientfname;
	}

	/**
	 * Gets the clientlname.
	 * 
	 * @return the clientlname
	 */
	public String getClientlname() {
		return clientlname;
	}

	/**
	 * Sets the clientlname.
	 * 
	 * @param clientlname
	 *            the new clientlname
	 */
	public void setClientlname(String clientlname) {
		this.clientlname = clientlname;
	}

	/**
	 * Gets the clientaddress.
	 * 
	 * @return the clientaddress
	 */
	public String getClientaddress() {
		return clientaddress;
	}

	/**
	 * Sets the clientaddress.
	 * 
	 * @param clientaddress
	 *            the new clientaddress
	 */
	public void setClientaddress(String clientaddress) {
		this.clientaddress = clientaddress;
	}

	/**
	 * Gets the clientemail.
	 * 
	 * @return the clientemail
	 */
	public String getClientemail() {
		return clientemail;
	}

	/**
	 * Sets the clientemail.
	 * 
	 * @param clientemail
	 *            the new clientemail
	 */
	public void setClientemail(String clientemail) {
		this.clientemail = clientemail;
	}

	/**
	 * Gets the clientcontactno.
	 * 
	 * @return the clientcontactno
	 */
	public Long getClientcontactno() {
		return clientcontactno;
	}

	/**
	 * Sets the clientcontactno.
	 * 
	 * @param clientcontactno
	 *            the new clientcontactno
	 */
	public void setClientcontactno(Long clientcontactno) {
		this.clientcontactno = clientcontactno;
	}

	/**
	 * Gets the clientcompany.
	 * 
	 * @return the clientcompany
	 */
	public String getClientcompany() {
		return clientcompany;
	}

	/**
	 * Sets the clientcompany.
	 * 
	 * @param clientcompany
	 *            the new clientcompany
	 */
	public void setClientcompany(String clientcompany) {
		this.clientcompany = clientcompany;
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

}
