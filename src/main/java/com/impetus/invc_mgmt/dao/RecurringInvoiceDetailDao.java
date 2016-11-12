/**
 * 
 */
package com.impetus.invc_mgmt.dao;

import com.impetus.invc_mgmt.model.RecurringInvoiceDetail;

// TODO: Auto-generated Javadoc
/**
 * The Interface RecurringInvoiceDetailDao consist the methods related to
 * recurring invoice detail.
 * 
 * @author Ashish
 */
public interface RecurringInvoiceDetailDao {

	/**
	 * Adds the.
	 * 
	 * @param recurringinvoicedetail
	 *            the recurringinvoicedetail
	 */
	void add(RecurringInvoiceDetail recurringinvoicedetail);

	/**
	 * Edits the.
	 * 
	 * @param recurringinvoicedetail
	 *            the recurringinvoicedetail
	 */
	void edit(RecurringInvoiceDetail recurringinvoicedetail);

	/**
	 * Delete.
	 * 
	 * @param recurringinvoicedetail
	 *            the recurringinvoicedetail
	 */
	void delete(RecurringInvoiceDetail recurringinvoicedetail);

}
