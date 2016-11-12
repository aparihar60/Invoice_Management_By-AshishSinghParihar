/**
 * 
 */
package com.impetus.invc_mgmt.dao;

import java.util.List;

import com.impetus.invc_mgmt.model.Client;

// TODO: Auto-generated Javadoc
/**
 * The Interface ClientDao consist the methods related to client.
 * 
 * @author Ashish
 */
public interface ClientDao {

	/**
	 * Adds the.
	 * 
	 * @param client
	 *            the client
	 */
	void add(Client client);

	/**
	 * Edits the.
	 * 
	 * @param client
	 *            the client
	 */
	void edit(Client client);

	/**
	 * Delete.
	 * 
	 * @param client
	 *            the client
	 */
	void delete(Client client);

	/**
	 * Gets the all client.
	 * 
	 * @param tenantid
	 *            the tenantid
	 * @return the all client
	 */
	List<Client> getAllClient(Integer tenantid);

	/**
	 * Gets the client by client id.
	 * 
	 * @param clientid
	 *            the clientid
	 * @return the client by client id
	 */
	Client getClientByClientId(int clientid);

}
