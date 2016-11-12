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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Entity;

// TODO: Auto-generated Javadoc
/**
 * The Class Role consist the attributes related to Role.A pojo class.
 * 
 * @author Ashish
 */
@Entity
@Table(name = "role")
public class Role {

	/** The roleid. */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roleid;

	/** The rolename. */
	@Column
	private String rolename;

	/** The user. */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	private Set<User> user;

	/**
	 * Instantiates a new role.
	 * 
	 */
	public Role() {
	}

	/**
	 * Instantiates a new role.
	 * 
	 * @param roleid
	 *            the roleid
	 * @param rolename
	 *            the rolename
	 */
	public Role(int roleid, String rolename) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
	}

	// getter setter
	/**
	 * Gets the roleid.
	 * 
	 * @return the roleid
	 */
	public int getRoleid() {
		return roleid;
	}

	/**
	 * Sets the roleid.
	 * 
	 * @param roleid
	 *            the new roleid
	 */
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	/**
	 * Gets the rolename.
	 * 
	 * @return the rolename
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * Sets the rolename.
	 * 
	 * @param rolename
	 *            the new rolename
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
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

}
