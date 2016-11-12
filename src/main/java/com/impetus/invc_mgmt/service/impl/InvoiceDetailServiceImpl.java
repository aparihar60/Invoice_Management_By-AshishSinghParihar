package com.impetus.invc_mgmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.invc_mgmt.dao.InvoiceDetailDao;
import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.InvoiceDetail;
import com.impetus.invc_mgmt.service.InvoiceDetailService;

// TODO: Auto-generated Javadoc

/**
 * The Class InvoiceDetailServiceImpl implements the interface
 * InvoiceDetailService and interacts with InvoiceDetailDao.
 */
@Service
public class InvoiceDetailServiceImpl implements InvoiceDetailService {

	/** The invoicedetaildao. */
	@Autowired
	private InvoiceDetailDao invoicedetaildao;
	
	private static final String ERROR = "ERROR!";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.InvoiceDetailService#add(com.impetus.invc_mgmt
	 * .model.InvoiceDetail)
	 */
	@Transactional
	public void add(InvoiceDetail invoicedetail) {
		// TODO Auto-generated method stub
		try {
			invoicedetaildao.add(invoicedetail);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.InvoiceDetailService#edit(com.impetus.invc_mgmt
	 * .model.InvoiceDetail)
	 */
	@Transactional
	public void edit(InvoiceDetail invoicedetail) {
		// TODO Auto-generated method stub
		try {
			invoicedetaildao.edit(invoicedetail);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.InvoiceDetailService#delete(com.impetus
	 * .invc_mgmt.model.InvoiceDetail)
	 */
	@Transactional
	public void delete(InvoiceDetail invoicedetail) {
		// TODO Auto-generated method stub
		try {
			invoicedetaildao.delete(invoicedetail);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

}
