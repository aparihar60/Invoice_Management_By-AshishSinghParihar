package com.impetus.invc_mgmt.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impetus.invc_mgmt.dao.RoleDao;
import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.Role;

// TODO: Auto-generated Javadoc

/**
 * The Class RoleDaoImpl implements the interface RoleDao and interacts with DB.
 */
@Repository
public class RoleDaoImpl implements RoleDao {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final String ERROR = "ERROR!";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.RoleDao#add(com.impetus.invc_mgmt.model.Role)
	 */
	@Override
	public void add(Role role) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(role);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.RoleDao#edit(com.impetus.invc_mgmt.model.Role)
	 */
	@Override
	public void edit(Role role) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(role);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.RoleDao#delete(com.impetus.invc_mgmt.model.
	 * Role)
	 */
	@Override
	public void delete(Role role) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(role);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

}
