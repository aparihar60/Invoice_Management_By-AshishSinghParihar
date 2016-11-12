package com.impetus.invc_mgmt.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impetus.invc_mgmt.dao.ClientDao;
import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.Client;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientDaoImpl implements the interface ClientDao and interacts with
 * DB.
 */
@Repository
public class ClientDaoImpl implements ClientDao {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final String ERROR = "ERROR!";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.ClientDao#add(com.impetus.invc_mgmt.model.Client
	 * )
	 */
	@Override
	public void add(Client client) {
		
		try {
			sessionFactory.getCurrentSession().save(client);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.ClientDao#edit(com.impetus.invc_mgmt.model.
	 * Client)
	 */
	@Override
	public void edit(Client client) {
		
		try {
			sessionFactory.getCurrentSession().update(client);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.ClientDao#delete(com.impetus.invc_mgmt.model
	 * .Client)
	 */
	@Override
	public void delete(Client client) {
		try {
			sessionFactory.getCurrentSession().delete(client);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.dao.ClientDao#getAllClient(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getAllClient(Integer tenantid) {
		try {
			return sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Client client where tenantid=:tenantid order by client.clientfname asc")
					.setInteger("tenantid", tenantid).list();
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.dao.ClientDao#getClientByClientId(int)
	 */
	@Override
	public Client getClientByClientId(int clientid) {
		try {
			Client client = (Client) sessionFactory.getCurrentSession().get(
					Client.class, clientid);

			return client;
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

}
