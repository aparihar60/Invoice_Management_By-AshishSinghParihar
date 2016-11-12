package com.impetus.invc_mgmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.invc_mgmt.dao.RecurringInvoiceDetailDao;
import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.RecurringInvoiceDetail;
import com.impetus.invc_mgmt.service.RecurringInvoiceDetailService;

// TODO: Auto-generated Javadoc

/**
 * The Class RecurringInvoiceDetailServiceImpl implements the interface
 * RecurringInvoiceDetailService and interacts with RecurringInvoiceDetailDao.
 */
@Service
public class RecurringInvoiceDetailServiceImpl implements
		RecurringInvoiceDetailService {

	/** The recurringinvoicedetaildao. */
	@Autowired
	private RecurringInvoiceDetailDao recurringinvoicedetaildao;
	
	private static final String ERROR = "ERROR!";
	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.RecurringInvoiceDetailService#add(com.impetus
	 * .invc_mgmt.model.RecurringInvoiceDetail)
	 */
	@Transactional
	public void add(RecurringInvoiceDetail recurringinvoicedetail) {
		try {
			recurringinvoicedetaildao.add(recurringinvoicedetail);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.RecurringInvoiceDetailService#edit(com.
	 * impetus.invc_mgmt.model.RecurringInvoiceDetail)
	 */
	@Transactional
	public void edit(RecurringInvoiceDetail recurringinvoicedetail) {
		try {
			recurringinvoicedetaildao.edit(recurringinvoicedetail);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.RecurringInvoiceDetailService#delete(com
	 * .impetus.invc_mgmt.model.RecurringInvoiceDetail)
	 */
	@Transactional
	public void delete(RecurringInvoiceDetail recurringinvoicedetail) {
		try {
			recurringinvoicedetaildao.delete(recurringinvoicedetail);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

}
