/**
 * 
 */
package com.impetus.invc_mgmt.dao;

import com.impetus.invc_mgmt.model.InvoiceDetail;

// TODO: Auto-generated Javadoc
/**
 * The Interface InvoiceDetailDao consist the methods related to invoice detail.
 * 
 * @author Ashish
 */
public interface InvoiceDetailDao {

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
