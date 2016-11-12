package com.impetus.invc_mgmt.service;

import com.impetus.invc_mgmt.model.Role;

// TODO: Auto-generated Javadoc
/**
 * The Interface RoleService consist the methods related to roles.
 */
public interface RoleService {

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
