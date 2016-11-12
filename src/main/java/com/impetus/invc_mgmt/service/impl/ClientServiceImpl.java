package com.impetus.invc_mgmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.invc_mgmt.dao.ClientDao;
import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.Client;
import com.impetus.invc_mgmt.service.ClientService;

// TODO: Auto-generated Javadoc

/**
 * The Class ClientServiceImpl implements the interface ClientService and
 * interacts with ClientDao.
 */
@Service
public class ClientServiceImpl implements ClientService {

	/** The clientdao. */
	@Autowired
	private ClientDao clientdao;
	
	private static final String ERROR = "ERROR!";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.ClientService#add(com.impetus.invc_mgmt
	 * .model.Client)
	 */
	@Transactional
	public void add(Client client) {
		// TODO Auto-generated method stub
		try {
			clientdao.add(client);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.ClientService#edit(com.impetus.invc_mgmt
	 * .model.Client)
	 */
	@Transactional
	public void edit(Client client) {
		// TODO Auto-generated method stub
		try {
			clientdao.edit(client);
		}catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.ClientService#delete(com.impetus.invc_mgmt
	 * .model.Client)
	 */
	@Transactional
	public void delete(Client client) {
		// TODO Auto-generated method stub
		try {
			clientdao.delete(client);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.ClientService#getAllClients(java.lang.Integer
	 * )
	 */
	@Transactional
	public List<Client> getAllClients(Integer tenantid) {
		try {
			return clientdao.getAllClient(tenantid);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.service.ClientService#getClientByClientId(int)
	 */
	@Transactional
	public Client getClientByClientId(int clientid) {
		try {
			return clientdao.getClientByClientId(clientid);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

}
