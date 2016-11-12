/**
 * 
 */
package com.impetus.invc_mgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class User consist the attributes related to Tenant.A pojo class
 * 
 * @author Ashish
 */
@Entity
@Table(name = "user")
public class User {

	/** The userid. */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;

	/** The userfname. */
	@Column
	private String userfname;

	/** The userlname. */
	@Column
	private String userlname;

	/** The userloginid. */
	@Column(unique=true)
	private String userloginid;

	/** The userpassword. */
	@Column
	private String userpassword;

	/** The useremail. */
	@Column
	private String useremail;

	/** The usercontactno. */
	@Column
	private Long usercontactno;

	/** The role. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roleid")
	private Role role;

	/** The tenant. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tenantid")
	private Tenant tenant;

	/**
	 * Instantiates a new user.
	 * 
	 */
	public User() {
	}

	/**
	 * Instantiates a new user.
	 * 
	 * @param userid
	 *            the userid
	 * @param userfname
	 *            the userfname
	 * @param userlname
	 *            the userlname
	 * @param userloginid
	 *            the userloginid
	 * @param userpassword
	 *            the userpassword
	 * @param useremail
	 *            the useremail
	 * @param usercontactno
	 *            the usercontactno
	 */
	public User(int userid, String userfname, String userlname,
			String userloginid, String userpassword, String useremail,
			Long usercontactno) {
		super();
		this.userid = userid;
		this.userfname = userfname;
		this.userlname = userlname;
		this.userloginid = userloginid;
		this.userpassword = userpassword;
		this.useremail = useremail;
		this.usercontactno = usercontactno;
	}

	// getter setter
	/**
	 * Gets the userid.
	 * 
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}

	/**
	 * Sets the userid.
	 * 
	 * @param userid
	 *            the new userid
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}

	/**
	 * Gets the userfname.
	 * 
	 * @return the userfname
	 */
	public String getUserfname() {
		return userfname;
	}

	/**
	 * Sets the userfname.
	 * 
	 * @param userfname
	 *            the new userfname
	 */
	public void setUserfname(String userfname) {
		this.userfname = userfname;
	}

	/**
	 * Gets the userlname.
	 * 
	 * @return the userlname
	 */
	public String getUserlname() {
		return userlname;
	}

	/**
	 * Sets the userlname.
	 * 
	 * @param userlname
	 *            the new userlname
	 */
	public void setUserlname(String userlname) {
		this.userlname = userlname;
	}

	/**
	 * Gets the userloginid.
	 * 
	 * @return the userloginid
	 */
	public String getUserloginid() {
		return userloginid;
	}

	/**
	 * Sets the userloginid.
	 * 
	 * @param userloginid
	 *            the new userloginid
	 */
	public void setUserloginid(String userloginid) {
		this.userloginid = userloginid;
	}

	/**
	 * Gets the userpassword.
	 * 
	 * @return the userpassword
	 */
	public String getUserpassword() {
		return userpassword;
	}

	/**
	 * Sets the userpassword.
	 * 
	 * @param userpassword
	 *            the new userpassword
	 */
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	/**
	 * Gets the useremail.
	 * 
	 * @return the useremail
	 */
	public String getUseremail() {
		return useremail;
	}

	/**
	 * Sets the useremail.
	 * 
	 * @param useremail
	 *            the new useremail
	 */
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	/**
	 * Gets the usercontactno.
	 * 
	 * @return the usercontactno
	 */
	public Long getUsercontactno() {
		return usercontactno;
	}

	/**
	 * Sets the usercontactno.
	 * 
	 * @param usercontactno
	 *            the new usercontactno
	 */
	public void setUsercontactno(Long usercontactno) {
		this.usercontactno = usercontactno;
	}

	/**
	 * Gets the role.
	 * 
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 * 
	 * @param role
	 *            the new role
	 */
	public void setRole(Role role) {
		this.role = role;
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

}
