package com.impetus.invc_mgmt.util;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.invc_mgmt.model.Invoice;

// TODO: Auto-generated Javadoc
/**
 * The Class DownloadService is used to download the invoices as a excel format.
 */
@Service("downloadService")
@Transactional
public class DownloadService {

	/** The logger. */
	private static Logger logger = Logger.getLogger("service");

	/** The session factory. */
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * Processes the download for Excel format. It does the following steps:
	 * 
	 * <pre>
	 * 1. Create new workbook
	 * 2. Create new worksheet
	 * 3. Define starting indices for rows and columns
	 * 4. Build layout
	 * 5. Fill report
	 * 6. Set the HttpServletResponse properties
	 * 7. Write to the output stream
	 * </pre>
	 * 
	 * @param response
	 *            the response
	 * @param tenantId
	 *            the tenant id
	 * @param fromdate
	 *            the fromdate
	 * @param todate
	 *            the todate
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	public void downloadXLS(HttpServletResponse response, int tenantId,
			Date fromdate, Date todate) throws ClassNotFoundException {
		logger.debug("Downloading Excel report");

		// 1. Create new workbook
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 2. Create new worksheet
		HSSFSheet worksheet = workbook.createSheet("POI Worksheet");

		// 3. Define starting indices for rows and columns
		int startRowIndex = 0;
		int startColIndex = 0;

		// 4. Build layout
		// Build title, date, and column headers
		Layouter.buildReport(worksheet, startRowIndex, startColIndex);

		// 5. Fill report
		FillManager.fillReport(worksheet, startRowIndex, startColIndex,
				getDatasource(tenantId, fromdate, todate));

		// 6. Set the response properties
		String fileName = "Invoice.xls";
		response.setHeader("Content-Disposition", "inline; filename="
				+ fileName);
		// Make sure to set the correct content type
		response.setContentType("application/vnd.ms-excel");

		// 7. Write to the output stream
		Writer.write(response, worksheet);
	}

	/**
	 * Retrieves the datasource as as simple Java List. The datasource is
	 * retrieved from a Hibernate HQL query.
	 * 
	 * @param tenantId
	 *            the tenant id
	 * @param fromdate
	 *            the fromdate
	 * @param todate
	 *            the todate
	 * @return the datasource
	 */
	@SuppressWarnings("unchecked")
	private List<Invoice> getDatasource(int tenantId, Date fromdate, Date todate)

	{

		// Retrieve session
		Session session = sessionFactory.getCurrentSession();
		// Create query for retrieving products
		Query query = session
				.createQuery("FROM Invoice invoice where invoice.tenant.tenantid=:tid and invoice.invoiceissuedate>=:fromdate and invoice.invoiceduedate<=:todate");
		query.setInteger("tid", tenantId);
		query.setDate("fromdate", fromdate);
		query.setDate("todate", todate);
		// Execute query
		List<Invoice> result = query.list();

		// Return the datasource
		return result;
	}

}
