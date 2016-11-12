package com.impetus.invc_mgmt.dao.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.invc_mgmt.dao.RecurringInvoiceDao;
import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.RecurringInvoice;

// TODO: Auto-generated Javadoc

/**
 * The Class RecurringInvoiceDaoImpl implements the interface
 * RecurringInvoiceDao and interacts with DB.
 */
@Repository
public class RecurringInvoiceDaoImpl implements RecurringInvoiceDao {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final String ERROR = "ERROR!";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.RecurringInvoiceDao#add(com.impetus.invc_mgmt
	 * .model.RecurringInvoice)
	 */
	@Override
	public void add(RecurringInvoice recurringinvoice) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(recurringinvoice);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.RecurringInvoiceDao#edit(com.impetus.invc_mgmt
	 * .model.RecurringInvoice)
	 */
	@Override
	public void edit(RecurringInvoice recurringinvoice) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(recurringinvoice);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.RecurringInvoiceDao#delete(com.impetus.invc_mgmt
	 * .model.RecurringInvoice)
	 */
	@Override
	public void delete(RecurringInvoice recurringinvoice) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(recurringinvoice);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.dao.RecurringInvoiceDao#
	 * getRecurringInvoiceByMaxRecurringInvoiceId()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int getRecurringInvoiceByMaxRecurringInvoiceId() {
		// TODO Auto-generated method stub

		try {
			List<Integer> list = sessionFactory
					.getCurrentSession()
					.createQuery(
							"select max(recurringinvoice.recurringinvoiceid) from RecurringInvoice recurringinvoice")
					.list();

			return list.get(0);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.RecurringInvoiceDao#getAllRecurringInvoices
	 * (java.sql.Date)
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<RecurringInvoice> getAllRecurringInvoices(Date dateCreated) {
		// TODO Auto-generated method stub
		Integer zero = 0;

		try {
			return sessionFactory
					.getCurrentSession()
					.createQuery(
							"from RecurringInvoice recurringinvoice where recurringinvoice.recurringinvoiceissuedate=:dateCreated and recurringinvoice.recurringinvoiceoccurence >:occ")
					.setInteger("occ", zero)
					.setDate("dateCreated", dateCreated).list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
