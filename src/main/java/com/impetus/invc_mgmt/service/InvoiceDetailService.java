package com.impetus.invc_mgmt.service;

import com.impetus.invc_mgmt.model.InvoiceDetail;

// TODO: Auto-generated Javadoc
/**
 * The Interface InvoiceDetailService consist the methods related to invoice
 * details.
 */
public interface InvoiceDetailService {

	/**
	 * Adds the.
	 * 
	 * @param invoicedetail
	 *            the invoicedetail
	 */
	void add(InvoiceDetail invoicedetail);

	/**
	 * Edits the.
	 * 
	 * @param invoicedetail
	 *            the invoicedetail
	 */
	void edit(InvoiceDetail invoicedetail);

	/**
	 * Delete.
	 * 
	 * @param invoicedetail
	 *            the invoicedetail
	 */
	void delete(InvoiceDetail invoicedetail);

}
