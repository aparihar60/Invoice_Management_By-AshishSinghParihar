package com.impetus.invc_mgmt.util;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellStyle;
import com.impetus.invc_mgmt.model.Invoice;

// TODO: Auto-generated Javadoc
/**
 * The Class FillManager is used to maintain the indexing of excel sheet
 * generated.
 */
public final class FillManager {

	/**
	 * Instantiates a new fill manager.
	 */
	private FillManager() {
	}

	/**
	 * Fills the report with content.
	 * 
	 * @param worksheet
	 *            the worksheet
	 * @param startRowIndex
	 *            starting row offset
	 * @param startColIndex
	 *            starting column offset
	 * @param datasource
	 *            the data source
	 */
	@SuppressWarnings("deprecation")
	public static void fillReport(HSSFSheet worksheet, int startRowIndex,
			int startColIndex, List<Invoice> datasource) {
		// Row offset
		int stRowIndex = startRowIndex;
		final int three = 3, four = 4, five = 5;
		stRowIndex = stRowIndex + 2;

		// Create cell style for the body
		HSSFCellStyle bodyCellStyle = worksheet.getWorkbook().createCellStyle();
		bodyCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		bodyCellStyle.setWrapText(true);

		// Create body
		for (int i = stRowIndex; i + stRowIndex - 2 < datasource.size() + 2; i++) {
			// Create a new row
			HSSFRow row = worksheet.createRow((short) i + 1);

			// Retrieve the id value
			HSSFCell cell1 = row.createCell(startColIndex + 0);
			cell1.setCellValue(datasource.get(i - 2).getInvoiceid());
			cell1.setCellStyle(bodyCellStyle);

			// Retrieve the tax value
			HSSFCell cell2 = row.createCell(startColIndex + 1);
			cell2.setCellValue(datasource.get(i - 2).getInvoiceissuedate()
					.toLocaleString());
			cell2.setCellStyle(bodyCellStyle);

			// Retrieve the price value
			HSSFCell cell3 = row.createCell(startColIndex + 2);
			cell3.setCellValue(datasource.get(i - 2).getInvoiceduedate()
					.toLocaleString());
			cell3.setCellStyle(bodyCellStyle);

			// Retrieve the note value
			HSSFCell cell4 = row.createCell(startColIndex + three);
			cell4.setCellValue(datasource.get(i - 2).getInvoiceprice());
			cell4.setCellStyle(bodyCellStyle);

			// Retrieve the issuedate value
			HSSFCell cell5 = row.createCell(startColIndex + four);
			cell5.setCellValue(datasource.get(i - 2).getInvoicenote());
			cell5.setCellStyle(bodyCellStyle);

			// Retrieve the duedate value
			HSSFCell cell6 = row.createCell(startColIndex + five);
			cell6.setCellValue(datasource.get(i - 2).getClient()
					.getClientfname());
			cell6.setCellStyle(bodyCellStyle);

		}
	}

}
