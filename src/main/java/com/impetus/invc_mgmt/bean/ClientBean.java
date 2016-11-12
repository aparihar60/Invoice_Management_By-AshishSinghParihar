package com.impetus.invc_mgmt.bean;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
// TODO: Auto-generated Javadoc
/**
 * The Class ClientBean consist the attributes of client and their
 * getter/setter.
 */
public class ClientBean {

	
	private static final int MINSIX=6, MAXFIFTY=50;
	
	/** The clientid. */

	private int clientid;

	/** The client first name. */
	@NotEmpty
	@Size ( max=MAXFIFTY)
	private String clientfname;

	/** The client last name. */
	@NotEmpty
	@Size ( max=MAXFIFTY)
	private String clientlname;

	/** The client address. */
	
	@NotEmpty
	@Size (min=MINSIX, max=MAXFIFTY)
	private String clientaddress;

	/** The client email. */
	
	@NotEmpty
	@Email(message="plz put right Email format")
	@Size (min=MINSIX, max=MAXFIFTY)
	private String clientemail;

	/** The client contactnumber. */
	
	@NotNull
	private Long clientcontactno;

	/** The client company. */
	@NotEmpty
	@Size (min=MINSIX, max=MAXFIFTY)
	private String clientcompany;

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
	 * Gets the client first name.
	 * 
	 * @return the client first name
	 */
	public String getClientfname() {
		return clientfname;
	}

	/**
	 * Sets the client first name.
	 * 
	 * @param clientfname
	 *            the new clientfname
	 */
	public void setClientfname(String clientfname) {
		this.clientfname = clientfname;
	}

	/**
	 * Gets the client last name.
	 * 
	 * @return the client last name
	 */
	public String getClientlname() {
		return clientlname;
	}

	/**
	 * Sets the client last name.
	 * 
	 * @param clientlname
	 *            the new clientlname
	 */
	public void setClientlname(String clientlname) {
		this.clientlname = clientlname;
	}

	/**
	 * Gets the client address.
	 * 
	 * @return the client address
	 */
	public String getClientaddress() {
		return clientaddress;
	}

	/**
	 * Sets the client address.
	 * 
	 * @param client
	 *            address the new client address
	 */
	public void setClientaddress(String clientaddress) {
		this.clientaddress = clientaddress;
	}

	/**
	 * Gets the client email.
	 * 
	 * @return the client email
	 */
	public String getClientemail() {
		return clientemail;
	}

	/**
	 * Sets the client email.
	 * 
	 * @param client
	 *            email the new client email
	 */
	public void setClientemail(String clientemail) {
		this.clientemail = clientemail;
	}

	/**
	 * Gets the client contactno.
	 * 
	 * @return the client contactno
	 */
	public Long getClientcontactno() {
		return clientcontactno;
	}

	/**
	 * Sets the client contactno.
	 * 
	 * @param client
	 *            contactno the new client contactno
	 */
	public void setClientcontactno(Long clientcontactno) {
		this.clientcontactno = clientcontactno;
	}

	/**
	 * Gets the client company.
	 * 
	 * @return the client company
	 */
	public String getClientcompany() {
		return clientcompany;
	}

	/**
	 * Sets the client company.
	 * 
	 * @param client
	 *            company the new client company
	 */
	public void setClientcompany(String clientcompany) {
		this.clientcompany = clientcompany;
	}

}
