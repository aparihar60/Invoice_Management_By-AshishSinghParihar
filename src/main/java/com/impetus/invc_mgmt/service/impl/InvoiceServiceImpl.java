package com.impetus.invc_mgmt.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.invc_mgmt.dao.InvoiceDao;
import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.Invoice;
import com.impetus.invc_mgmt.service.InvoiceService;

// TODO: Auto-generated Javadoc

/**
 * The Class InvoiceServiceImpl implements the interface InvoiceService and
 * interacts with InvoiceDao.
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {

	/** The invoicedao. */
	@Autowired
	private InvoiceDao invoicedao;
	
	private static final String ERROR = "ERROR!";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.InvoiceService#add(com.impetus.invc_mgmt
	 * .model.Invoice)
	 */
	@Transactional
	public void add(Invoice invoice) {
		// TODO Auto-generated method stub
		try {
			invoicedao.add(invoice);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.InvoiceService#edit(com.impetus.invc_mgmt
	 * .model.Invoice)
	 */
	@Transactional
	public void edit(Invoice invoice) {
		// TODO Auto-generated method stub
		try {
			invoicedao.edit(invoice);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.InvoiceService#delete(com.impetus.invc_mgmt
	 * .model.Invoice)
	 */
	@Transactional
	public void delete(Invoice invoice) {
		// TODO Auto-generated method stub
		try {
			invoicedao.delete(invoice);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.service.InvoiceService#getMaxInvoiceId()
	 */
	@Transactional
	public Invoice getMaxInvoiceId() {
		// TODO Auto-generated method stub
		try {
			return invoicedao.getMaxInvoiceId();
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.InvoiceService#getInvoiceByMaxInvoiceId()
	 */
	@Transactional
	public int getInvoiceByMaxInvoiceId() {

		try {
			return invoicedao.getInvoiceByMaxInvoiceId();
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.service.InvoiceService#getDueAllnvoices(int)
	 */
	@Transactional
	public List<Invoice> getDueAllnvoices(int tenantId) {
		// TODO Auto-generated method stub
		try {
			return invoicedao.getDueAllnvoices(tenantId);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.InvoiceService#getlatestAllnvoices(int)
	 */
	@Transactional
	public List<Invoice> getlatestAllnvoices(int tenantId) {
		// TODO Auto-generated method stub
		try {
			return invoicedao.getlatestAllnvoices(tenantId);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.InvoiceService#getAllInvoices(java.lang
	 * .Integer)
	 */
	@Transactional
	public List<Invoice> getAllInvoices(Integer tenantid) {
		// TODO Auto-generated method stub
		try {
			return invoicedao.getAllInvoices(tenantid);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.InvoiceService#getSearchAllInvoices(java
	 * .lang.Integer, java.lang.String, java.lang.String)
	 */
	@Transactional
	public List<Invoice> getSearchAllInvoices(Integer tenantid,
			String searchby, String param) {
		// TODO Auto-generated method stub
		try {
			return invoicedao.getSearchAllInvoices(tenantid, searchby, param);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.InvoiceService#getChartValues(java.lang
	 * .String, int)
	 */
	@Transactional
	public List<Double> getChartValues(String param, int tenantid) {

		try {
			final int twentyeight = 28, four = 4, onetwenty = 120, thirty = 30, seven = 7;
			// TODO Auto-generated method stub
			List<Double> values = new ArrayList<Double>();

			Date currentDate = new java.sql.Date(new java.util.Date().getTime());

			DateTime dt = new DateTime(currentDate.getTime());

			if (param.equals("Day")) {
				dt = dt.minusDays(four);
			} else if (param.equals("Week")) {
				dt = dt.minusDays(twentyeight);
			} else if (param.equals("Month")) {
				dt = dt.minusDays(onetwenty);
			}

			for (int a = 0; a < four; a++) {
				Date fromDate = new java.sql.Date(dt.getMillis());
				if (param.equals("Day")) {
					dt = dt.plusDays(1);
				} else if (param.equals("Week")) {
					dt = dt.plusDays(seven);
				} else if (param.equals("Month")) {
					dt = dt.plusDays(thirty);
				}
				Date toDate = new java.sql.Date(dt.getMillis());

				List<Invoice> list = invoicedao.getChartInvoices(fromDate, toDate,
						"Paid", tenantid);
				values.add(getTotalAmount(list));

				list = new ArrayList<Invoice>(invoicedao.getChartInvoices(fromDate,
						toDate, tenantid));
				values.add(getTotalAmount(list));

			}

			return values;
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/**
	 * Gets the total amount.
	 * 
	 * @param list
	 *            the list
	 * @return the total amount
	 */
	public Double getTotalAmount(List<Invoice> list) {
		try {
			Double total = (double) 0;
			for (int a = 0; a < list.size(); a++) {
				total += list.get(a).getInvoiceprice();
			}
			return total;
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.service.InvoiceService#listInvoiceByDate()
	 */
	@Override
	public List<Invoice> listInvoiceByDate() {
		try {
			return invoicedao.listInvoiceByDate();
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.InvoiceService#getInvoiceByInvoiceId(int,
	 * int)
	 */
	@Transactional
	public Invoice getInvoiceByInvoiceId(int invoiceid, int tenantid) {

		try {
			return invoicedao.getInvoiceByInvoiceId(invoiceid, tenantid);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.service.InvoiceService#getUnpaidInvoices(int)
	 */
	@Transactional
	public List<Invoice> getUnpaidInvoices(int tenantId) {

		try {
			return invoicedao.getUnpaidInvoices(tenantId);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}
}
