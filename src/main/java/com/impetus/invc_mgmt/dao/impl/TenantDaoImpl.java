package com.impetus.invc_mgmt.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impetus.invc_mgmt.dao.TenantDao;
import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.Tenant;

// TODO: Auto-generated Javadoc
/**
 * The Class TenantDaoImplm implements the interface TenantDao and interacts
 * with DB.
 */
@Repository
public class TenantDaoImpl implements TenantDao {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final String ERROR = "ERROR!";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.TenantDao#add(com.impetus.invc_mgmt.model.Tenant
	 * )
	 */
	@Override
	public void add(Tenant tenant) {
		try {
			sessionFactory.getCurrentSession().save(tenant);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.TenantDao#edit(com.impetus.invc_mgmt.model.
	 * Tenant)
	 */
	@Override
	public void edit(Tenant tenant) {
		try {
			sessionFactory.getCurrentSession().update(tenant);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.TenantDao#delete(com.impetus.invc_mgmt.model
	 * .Tenant)
	 */
	@Override
	public void delete(Tenant tenant) {
		try {
			sessionFactory.getCurrentSession().delete(tenant);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.dao.TenantDao#getTenantByTenantId(int)
	 */
	@Override
	public Tenant getTenantByTenantId(int tenantid) {
		// TODO Auto-generated method stub
		try {
			Tenant tenant = (Tenant) sessionFactory.getCurrentSession().get(
					Tenant.class, tenantid);

			return tenant;
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

}
