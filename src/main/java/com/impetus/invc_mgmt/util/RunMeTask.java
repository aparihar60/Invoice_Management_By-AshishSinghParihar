package com.impetus.invc_mgmt.util;

import java.sql.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.impetus.invc_mgmt.model.Invoice;
import com.impetus.invc_mgmt.model.RecurringInvoice;
import com.impetus.invc_mgmt.service.InvoiceService;
import com.impetus.invc_mgmt.service.RecurringInvoiceService;

// TODO: Auto-generated Javadoc
/**
 * The Class RunMeTask.
 */
public class RunMeTask {

	/** The invoice service. */
	@Autowired
	private InvoiceService invoiceService;

	/** The recurring invoice service. */
	@Autowired
	private RecurringInvoiceService recurringInvoiceService;

	/** The Constant THREESIXFIVE. */
	private static final int SEVEN = 7, THIRTY = 30, THREESIXFIVE = 365;

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(RunMeTask.class);

	/** The invoice service. */

	public void printMe() {

		Date dateCreated = new java.sql.Date(new java.util.Date().getTime());

		List<RecurringInvoice> recurringinvoicelist = recurringInvoiceService
				.getAllRecurringInvoices(dateCreated);

		for (int i = 0; i < recurringinvoicelist.size(); i++) {

			Invoice invoice = new Invoice();

			invoice.setInvoicetax(recurringinvoicelist.get(i)
					.getRecurringinvoicetax());
			invoice.setInvoiceissuedate(recurringinvoicelist.get(i)
					.getRecurringinvoiceissuedate());
			invoice.setInvoiceprice(recurringinvoicelist.get(i)
					.getRecurringinvoiceprice());
			invoice.setInvoicenote(recurringinvoicelist.get(i)
					.getRecurringinvoicenote());
			invoice.setUser(recurringinvoicelist.get(i).getUser());
			invoice.setClient(recurringinvoicelist.get(i).getClient());
			invoice.setTenant(recurringinvoicelist.get(i).getTenant());

			invoiceService.add(invoice);

		}

		for (int i = 0; i < recurringinvoicelist.size(); i++) {

			recurringinvoicelist.get(i)
					.setRecurringinvoiceoccurence(
							recurringinvoicelist.get(i)
									.getRecurringinvoiceoccurence() - 1);

			if (recurringinvoicelist.get(i).getRecurringinvoicefrequency()
					.equals("weekly"))

			{

				Date date = new java.sql.Date(recurringinvoicelist.get(i)
						.getRecurringinvoiceissuedate().getTime());

				DateTime datetime = new DateTime(date.getTime());
				datetime = datetime.plusDays(SEVEN);
				recurringinvoicelist.get(i).setRecurringinvoiceissuedate(date);

			}

			if (recurringinvoicelist.get(i).getRecurringinvoicefrequency()
					.equals("monthly"))

			{

				Date date = new java.sql.Date(recurringinvoicelist.get(i)
						.getRecurringinvoiceissuedate().getTime());

				DateTime datetime = new DateTime(date.getTime());
				datetime = datetime.plusDays(THIRTY);
				recurringinvoicelist.get(i).setRecurringinvoiceissuedate(date);

			}

			if (recurringinvoicelist.get(i).getRecurringinvoicefrequency()
					.equals("yearly"))

			{

				Date date = new java.sql.Date(recurringinvoicelist.get(i)
						.getRecurringinvoiceissuedate().getTime());

				DateTime datetime = new DateTime(date.getTime());
				datetime = datetime.plusDays(THREESIXFIVE);
				recurringinvoicelist.get(i).setRecurringinvoiceissuedate(date);

			}

			recurringInvoiceService.edit(recurringinvoicelist.get(i));
			logger.info("recurring invoice ");

		}

	}
}
