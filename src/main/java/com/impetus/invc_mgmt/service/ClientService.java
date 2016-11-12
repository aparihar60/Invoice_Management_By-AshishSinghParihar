package com.impetus.invc_mgmt.service;

import java.util.List;

import com.impetus.invc_mgmt.model.Client;

// TODO: Auto-generated Javadoc
/**
 * The Interface ClientService consist the methods related to client.
 */
public interface ClientService {

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
	 * Gets the all clients.
	 * 
	 * @param tenantid
	 *            the tenantid
	 * @return the all clients
	 */
	List<Client> getAllClients(Integer tenantid);

	/**
	 * Gets the client by client id.
	 * 
	 * @param clientid
	 *            the clientid
	 * @return the client by client id
	 */
	Client getClientByClientId(int clientid);

}
