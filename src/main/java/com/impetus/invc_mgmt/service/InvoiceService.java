package com.impetus.invc_mgmt.service;

import java.util.List;

import com.impetus.invc_mgmt.model.Invoice;

// TODO: Auto-generated Javadoc
/**
 * The Interface InvoiceService consist the methods related to invoice.
 */
public interface InvoiceService {

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
	 * Gets the chart values.
	 * 
	 * @param string
	 *            the string
	 * @param tenantid
	 *            the tenantid
	 * @return the chart values
	 */
	List<Double> getChartValues(String string, int tenantid);

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
