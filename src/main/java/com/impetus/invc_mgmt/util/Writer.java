package com.impetus.invc_mgmt.util;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;

// TODO: Auto-generated Javadoc
/**
 * The Class Writer Writes the report to the output stream.
 */
public final class Writer {

	/**
	 * Instantiates a new writer.
	 */
	private Writer() {
	}

	/** The logger. */
	private static Logger logger = Logger.getLogger("service");

	/**
	 * Writes the report to the output stream.
	 * 
	 * @param response
	 *            the response
	 * @param worksheet
	 *            the worksheet
	 */
	public static void write(HttpServletResponse response, HSSFSheet worksheet) {

		logger.debug("Writing report to the stream");
		try {
			// Retrieve the output stream
			ServletOutputStream outputStream = response.getOutputStream();
			// Write to the output stream
			worksheet.getWorkbook().write(outputStream);
			// Flush the stream
			outputStream.flush();

		} catch (Exception e) {
			logger.error("Unable to write report to the output stream");
		}
	}

}
