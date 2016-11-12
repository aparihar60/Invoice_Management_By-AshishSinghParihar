/**
 * 
 */
package com.impetus.invc_mgmt.dao;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import com.impetus.invc_mgmt.model.Invoice;

// TODO: Auto-generated Javadoc
/**
 * The Interface InvoiceDao consist the methods related to invoice.
 * 
 * @author Ashish
 */
public interface InvoiceDao {

	/**
	 * Adds the.
	 * 
	 * @param invoice
	 *            the invoice
	 */
	void add(Invoice invoice);

	/**
	 * Edits the.
	 * 
	 * @param invoice
	 *            the invoice
	 */
	void edit(Invoice invoice);

	/**
	 * Delete.
	 * 
	 * @param invoice
	 *            the invoice
	 */
	void delete(Invoice invoice);

	/**
	 * Gets the max invoice id.
	 * 
	 * @return the max invoice id
	 */
	Invoice getMaxInvoiceId();

	/**
	 * Gets the invoice by max invoice id.
	 * 
	 * @return the invoice by max invoice id
	 */
	int getInvoiceByMaxInvoiceId();

	/**
	 * Gets the due allnvoices.
	 * 
	 * @param tenantId
	 *            the tenant id
	 * @return the due allnvoices
	 */
	List<Invoice> getDueAllnvoices(int tenantId);

	/**
	 * Gets the latest allnvoices.
	 * 
	 * @param tenantId
	 *            the tenant id
	 * @return the latest allnvoices
	 */
	List<Invoice> getlatestAllnvoices(int tenantId);

	/**
	 * Gets the all invoices.
	 * 
	 * @param tenantid
	 *            the tenantid
	 * @return the all invoices
	 */
	List<Invoice> getAllInvoices(Integer tenantid);

	/**
	 * Gets the search all invoices.
	 * 
	 * @param tenantid
	 *            the tenantid
	 * @param searchby
	 *            the searchby
	 * @param param
	 *            the param
	 * @return the search all invoices
	 */
	List<Invoice> getSearchAllInvoices(Integer tenantid, String searchby,
			String param);

	/**
	 * Gets the chart invoices.
	 * 
	 * @param fromDate
	 *            the from date
	 * @param toDate
	 *            the to date
	 * @param string
	 *            the string
	 * @param tenantid
	 *            the tenantid
	 * @return the chart invoices
	 */
	List<Invoice> getChartInvoices(Date fromDate, Date toDate, String string,
			int tenantid);

	/**
	 * Gets the chart invoices.
	 * 
	 * @param fromDate
	 *            the from date
	 * @param toDate
	 *            the to date
	 * @param tenantid
	 *            the tenantid
	 * @return the chart invoices
	 */
	Collection<? extends Invoice> getChartInvoices(Date fromDate, Date toDate,
			int tenantid);

	/**
	 * List invoice by date.
	 * 
	 * @return the list
	 */
	List<Invoice> listInvoiceByDate();

	/**
	 * Gets the invoice by invoice id.
	 * 
	 * @param invoiceid
	 *            the invoiceid
	 * @param tenantid
	 *            the tenantid
	 * @return the invoice by invoice id
	 */
	Invoice getInvoiceByInvoiceId(int invoiceid, int tenantid);

	/**
	 * Gets the unpaid invoices.
	 * 
	 * @param tenantId
	 *            the tenant id
	 * @return the unpaid invoices
	 */
	List<Invoice> getUnpaidInvoices(int tenantId);

}
