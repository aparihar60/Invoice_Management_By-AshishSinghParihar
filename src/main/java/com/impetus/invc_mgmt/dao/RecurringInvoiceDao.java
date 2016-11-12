/**
 * 
 */
package com.impetus.invc_mgmt.dao;

import java.sql.Date;
import java.util.List;

import com.impetus.invc_mgmt.model.RecurringInvoice;

// TODO: Auto-generated Javadoc
/**
 * The Interface RecurringInvoiceDao consist the methods related to recuring
 * invoice.
 * 
 * @author Ashish
 */
public interface RecurringInvoiceDao {

	/**
	 * Adds the.
	 * 
	 * @param recurringinvoice
	 *            the recurringinvoice
	 */
	void add(RecurringInvoice recurringinvoice);

	/**
	 * Edits the.
	 * 
	 * @param recurringinvoice
	 *            the recurringinvoice
	 */
	void edit(RecurringInvoice recurringinvoice);

	/**
	 * Delete.
	 * 
	 * @param recurringinvoice
	 *            the recurringinvoice
	 */
	void delete(RecurringInvoice recurringinvoice);

	/**
	 * Gets the recurring invoice by max recurring invoice id.
	 * 
	 * @return the recurring invoice by max recurring invoice id
	 */
	int getRecurringInvoiceByMaxRecurringInvoiceId();

	/**
	 * Gets the all recurring invoices.
	 * 
	 * @param dateCreated
	 *            the date created
	 * @return the all recurring invoices
	 */
	List<RecurringInvoice> getAllRecurringInvoices(Date dateCreated);

}
