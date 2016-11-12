package com.impetus.invc_mgmt.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impetus.invc_mgmt.dao.InvoiceDetailDao;
import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.InvoiceDetail;

// TODO: Auto-generated Javadoc

/**
 * The Class InvoiceDetailDaoImpl implements the interface InvoiceDetailDao and
 * interacts with DB.
 */
@Repository
public class InvoiceDetailDaoImpl implements InvoiceDetailDao {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final String ERROR = "ERROR!";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.InvoiceDetailDao#add(com.impetus.invc_mgmt.
	 * model.InvoiceDetail)
	 */
	@Override
	public void add(InvoiceDetail invoicedetail) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(invoicedetail);
		}catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.InvoiceDetailDao#edit(com.impetus.invc_mgmt
	 * .model.InvoiceDetail)
	 */
	@Override
	public void edit(InvoiceDetail invoicedetail) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(invoicedetail);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.InvoiceDetailDao#delete(com.impetus.invc_mgmt
	 * .model.InvoiceDetail)
	 */
	@Override
	public void delete(InvoiceDetail invoicedetail) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(invoicedetail);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

}
