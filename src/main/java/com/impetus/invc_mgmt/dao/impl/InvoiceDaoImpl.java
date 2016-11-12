package com.impetus.invc_mgmt.dao.impl;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impetus.invc_mgmt.dao.InvoiceDao;
import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.Invoice;

// TODO: Auto-generated Javadoc
/**
 * The Class InvoiceDaoImpl implements the interface InvoiceDao and interacts
 * with DB.
 */
@Repository
public class InvoiceDaoImpl implements InvoiceDao {

	/** The Constant THREE. */
	private static final int THREE = 3;

	/** The Constant STAT. */
	private static final String STAT = "stat";

	/** The Constant DATE. */
	private static final String DATE = "date";

	/** The Constant PAID. */
	private static final String PAID = "Paid";

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(InvoiceDaoImpl.class);
	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/** The Constant UNCHECKED. */
	private static final String UNCHECKED = "unchecked";
	
	private static final String ERROR = "ERROR!";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.InvoiceDao#add(com.impetus.invc_mgmt.model.
	 * Invoice)
	 */
	@Override
	public void add(Invoice invoice) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(invoice);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.InvoiceDao#edit(com.impetus.invc_mgmt.model
	 * .Invoice)
	 */
	@Override
	public void edit(Invoice invoice) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(invoice);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.InvoiceDao#delete(com.impetus.invc_mgmt.model
	 * .Invoice)
	 */
	@Override
	public void delete(Invoice invoice) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(invoice);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.dao.InvoiceDao#getMaxInvoiceId()
	 */
	@Override
	public Invoice getMaxInvoiceId() {
		try {
			@SuppressWarnings(UNCHECKED)
			List<Invoice> list = sessionFactory.getCurrentSession().createQuery("from invoice where max(invoiceid)").list();
			return list.get(0);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.dao.InvoiceDao#getInvoiceByMaxInvoiceId()
	 */
	@SuppressWarnings(UNCHECKED)
	@Override
	public int getInvoiceByMaxInvoiceId() {
		try {
			List<Integer> list = sessionFactory
					.getCurrentSession()
					.createQuery(
							"select max(invoice.invoiceid) from Invoice invoice")
					.list();

			return list.get(0);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.dao.InvoiceDao#getDueAllnvoices(int)
	 */
	@SuppressWarnings(UNCHECKED)
	@Override
	public List<Invoice> getDueAllnvoices(int tenantId) {

		try {
			return sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Invoice invoice where tenantId=:tenantId and invoice.invoicestatus='unpaid'")
					.setInteger("tenantId", tenantId).setMaxResults(THREE).list();
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.dao.InvoiceDao#getUnpaidInvoices(int)
	 */
	@SuppressWarnings(UNCHECKED)
	@Override
	public List<Invoice> getUnpaidInvoices(int tenantId) {

		try {
			return sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Invoice invoice where tenantId=:tenantId and invoice.invoicestatus='unpaid' order by invoice.invoiceid desc")
					.setInteger("tenantId", tenantId).list();
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.dao.InvoiceDao#getlatestAllnvoices(int)
	 */
	@SuppressWarnings(UNCHECKED)
	@Override
	public List<Invoice> getlatestAllnvoices(int tenantId) {
		// TODO Auto-generated method stub
		try {
			return sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Invoice invoice where tenantId=:tenantId order by invoice.invoiceid desc")
					.setInteger("tenantId", tenantId).setMaxResults(THREE).list();
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.InvoiceDao#getAllInvoices(java.lang.Integer)
	 */
	@SuppressWarnings(UNCHECKED)
	@Override
	public List<Invoice> getAllInvoices(Integer tenantid) {
		// TODO Auto-generated method stub
		try {
			return sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Invoice invoice where tenantid=:tenantid order by invoice.invoiceid desc")
					.setInteger("tenantid", tenantid).list();
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.InvoiceDao#getSearchAllInvoices(java.lang.Integer
	 * , java.lang.String, java.lang.String)
	 */
	@SuppressWarnings(UNCHECKED)
	@Override
	public List<Invoice> getSearchAllInvoices(Integer tenantid,
			String searchby, String param) {
		// TODO Auto-generated method stub
		try {
			if (searchby.equals("invoice")) {
				return sessionFactory
						.getCurrentSession()
						.createQuery(
								"from Invoice where invoiceid=:id and tenantid=:tid ")
						.setInteger("tid", tenantid)
						.setInteger("id", Integer.parseInt(param)).list();
			}
			if (searchby.equals("client")) {
				return sessionFactory
						.getCurrentSession()
						.createQuery(
								"from Invoice invoice where invoice.client.clientfname=:name and invoice.tenant.tenantid=:tid ")
						.setInteger("tid", tenantid).setString("name", param)
						.list();
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.dao.InvoiceDao#getChartInvoices(java.sql.Date,
	 * java.sql.Date, java.lang.String, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Invoice> getChartInvoices(Date fromDate, Date toDate,
			String status, int tenantid) {
		try {
			return sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Invoice where invoiceissuedate>:date and invoiceissuedate<=:tdate and invoicestatus=:stat and tenantid=:id")
					.setDate(DATE, fromDate).setDate("tdate", toDate)
					.setString(STAT, status).setInteger("id", tenantid).list();
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.dao.InvoiceDao#getChartInvoices(java.sql.Date,
	 * java.sql.Date, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<? extends Invoice> getChartInvoices(Date fromDate,
			Date toDate, int tenantid) {
		// TODO Auto-generated method stub
		try {
			return sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Invoice where invoiceissuedate>:date and invoiceissuedate<=:tdate and invoicestatus!=:stat and tenantid=:id")
					.setDate(DATE, fromDate).setDate("tdate", toDate)
					.setString(STAT, PAID).setInteger("id", tenantid).list();
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.dao.InvoiceDao#listInvoiceByDate()
	 */
	@Override
	public List<Invoice> listInvoiceByDate() {
		try {
			java.util.Date currentDate = new java.util.Date();
			java.sql.Date cDate = new java.sql.Date(currentDate.getTime());
			String ppaid = "unpaid";
			List<Invoice> list = sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Invoice where invoiceduedate=:date  and invoicestatus!=:sstatus")
					.setDate("date", cDate).setString("sstatus", ppaid).list();

			logger.info("hi");
			logger.info("List is " + list.size());

			return list;
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.dao.InvoiceDao#getInvoiceByInvoiceId(int, int)
	 */
	@Override
	public Invoice getInvoiceByInvoiceId(int invoiceid, int tenantid) {
		try {
			return (Invoice) sessionFactory.getCurrentSession().get(Invoice.class,
					invoiceid);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

}
