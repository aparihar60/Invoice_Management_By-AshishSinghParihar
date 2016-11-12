package com.impetus.invc_mgmt.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impetus.invc_mgmt.dao.RecurringInvoiceDetailDao;
import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.RecurringInvoiceDetail;

// TODO: Auto-generated Javadoc
/**
 * The Class RecurringInvoiceDetailDaoImpl implements the interface
 * RecurringInvoiceDetailDao and interacts with DB.
 */
@Repository
public class RecurringInvoiceDetailDaoImpl implements RecurringInvoiceDetailDao {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final String ERROR = "ERROR!";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.RecurringInvoiceDetailDao#add(com.impetus.invc_mgmt
	 * .model.RecurringInvoiceDetail)
	 */
	@Override
	public void add(RecurringInvoiceDetail recurringinvoivedetail) {
		try {
			sessionFactory.getCurrentSession().save(recurringinvoivedetail);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.RecurringInvoiceDetailDao#edit(com.impetus.
	 * invc_mgmt.model.RecurringInvoiceDetail)
	 */
	@Override
	public void edit(RecurringInvoiceDetail recurringinvoivedetail) {
		try {
			sessionFactory.getCurrentSession().update(recurringinvoivedetail);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.RecurringInvoiceDetailDao#delete(com.impetus
	 * .invc_mgmt.model.RecurringInvoiceDetail)
	 */
	@Override
	public void delete(RecurringInvoiceDetail recurringinvoivedetail) {
		try {
			sessionFactory.getCurrentSession().delete(recurringinvoivedetail);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

}
