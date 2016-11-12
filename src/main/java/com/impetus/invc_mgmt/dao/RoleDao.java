/**
 * 
 */
package com.impetus.invc_mgmt.dao;

import com.impetus.invc_mgmt.model.Role;

// TODO: Auto-generated Javadoc
/**
 * The Interface RoleDao consist the methods related to roles.
 * 
 * @author Ashish
 */
public interface RoleDao {

	/**
	 * Adds the.
	 * 
	 * @param role
	 *            the role
	 */
	void add(Role role);

	/**
	 * Edits the.
	 * 
	 * @param role
	 *            the role
	 */
	void edit(Role role);

	/**
	 * Delete.
	 * 
	 * @param role
	 *            the role
	 */
	void delete(Role role);;

}
