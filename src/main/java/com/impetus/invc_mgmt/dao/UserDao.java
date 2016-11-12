/**
 * 
 */
package com.impetus.invc_mgmt.dao;

import java.util.List;

import com.impetus.invc_mgmt.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserDao consist the methods related to user.
 * 
 * @author Ashish
 */
public interface UserDao {

	/**
	 * Adds the.
	 * 
	 * @param user
	 *            the user
	 */
	void add(User user);

	/**
	 * Edits the.
	 * 
	 * @param user
	 *            the user
	 */
	void edit(User user);

	/**
	 * Delete.
	 * 
	 * @param user
	 *            the user
	 */
	void delete(User user);

	/**
	 * Authenticate user.
	 * 
	 * @param logid
	 *            the logid
	 * @param pass
	 *            the pass
	 * @return the user
	 */
	User authenticateUser(String logid, String pass);

	/**
	 * List users by tenant id.
	 * 
	 * @param tenantId
	 *            the tenant id
	 * @return the list
	 */
	List<User> listUsersByTenantId(int tenantId);

	/**
	 * Gets the user by user id.
	 * 
	 * @param userid
	 *            the userid
	 * @return the user by user id
	 */
	User getUserByUserId(int userid);

}
