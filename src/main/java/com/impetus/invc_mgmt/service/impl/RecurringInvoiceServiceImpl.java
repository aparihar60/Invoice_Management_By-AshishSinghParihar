package com.impetus.invc_mgmt.service.impl;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.invc_mgmt.dao.RecurringInvoiceDao;
import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.RecurringInvoice;
import com.impetus.invc_mgmt.service.RecurringInvoiceService;

// TODO: Auto-generated Javadoc

/**
 * The Class RecurringInvoiceServiceImpl implements the interface
 * RecurringInvoiceService and interacts with RecurringInvoiceDao.
 */
@Service
public class RecurringInvoiceServiceImpl implements RecurringInvoiceService {

	/** The logger. */
	private Logger logger = LoggerFactory
			.getLogger(RecurringInvoiceServiceImpl.class);

	/** The recurringinvoicedao. */
	@Autowired
	private RecurringInvoiceDao recurringinvoicedao;

	
	private static final String ERROR = "ERROR!";
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.RecurringInvoiceService#add(com.impetus
	 * .invc_mgmt.model.RecurringInvoice)
	 */
	@Transactional
	public void add(RecurringInvoice recurringinvoice) {
		// TODO Auto-generated method stub
		try {
			recurringinvoicedao.add(recurringinvoice);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.RecurringInvoiceService#edit(com.impetus
	 * .invc_mgmt.model.RecurringInvoice)
	 */
	@Transactional
	public void edit(RecurringInvoice recurringinvoice) {
		// TODO Auto-generated method stub
		try {
			recurringinvoicedao.edit(recurringinvoice);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.RecurringInvoiceService#delete(com.impetus
	 * .invc_mgmt.model.RecurringInvoice)
	 */
	@Transactional
	public void delete(RecurringInvoice recurringinvoice) {
		// TODO Auto-generated method stub
		try {
			recurringinvoicedao.delete(recurringinvoice);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.service.RecurringInvoiceService#
	 * getRecurringInvoiceByMaxRecurringInvoiceId()
	 */
	@Transactional
	public int getRecurringInvoiceByMaxRecurringInvoiceId() {
		// TODO Auto-generated method stub
		try {
			return recurringinvoicedao.getRecurringInvoiceByMaxRecurringInvoiceId();
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.RecurringInvoiceService#getAllRecurringInvoices
	 * (java.sql.Date)
	 */
	@Transactional
	public List<RecurringInvoice> getAllRecurringInvoices(Date dateCreated) {
		// TODO Auto-generated method stub
		try {
			logger.info("ServiceImpl");
			return recurringinvoicedao.getAllRecurringInvoices(dateCreated);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

}
