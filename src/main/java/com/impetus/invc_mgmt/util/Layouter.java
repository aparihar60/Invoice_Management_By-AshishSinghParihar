package com.impetus.invc_mgmt.util;

import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

// TODO: Auto-generated Javadoc
/**
 * The Class Layouter is used to maintain the number of rows and columns os
 * excel sheet generated..
 */

public final class Layouter {

	/** The Constant FIVEHUNDRED. */
	private static final int THREE = 3, FIVETHOUSAND = 5000, FIVE = 5,
			FOUR = 4, TWOEIGHTY = 280, FIVEHUNDRED = 500;

	/**
	 * Instantiates a new layouter.
	 */
	private Layouter() {
	}

	/**
	 * Builds the report layout.
	 * <p>
	 * This doesn't have any data yet. This is my template.
	 * 
	 * @param worksheet
	 *            the worksheet
	 * @param startRowIndex
	 *            the start row index
	 * @param startColIndex
	 *            the start col index
	 */
	public static void buildReport(HSSFSheet worksheet, int startRowIndex,
			int startColIndex) {
		// Set column widths
		worksheet.setColumnWidth(0, FIVETHOUSAND);
		worksheet.setColumnWidth(1, FIVETHOUSAND);
		worksheet.setColumnWidth(2, FIVETHOUSAND);
		worksheet.setColumnWidth(THREE, FIVETHOUSAND);
		worksheet.setColumnWidth(FOUR, FIVETHOUSAND);
		worksheet.setColumnWidth(FIVE, FIVETHOUSAND);

		// Build the title and date headers
		buildTitle(worksheet, startRowIndex, startColIndex);
		// Build the column headers
		buildHeaders(worksheet, startRowIndex, startColIndex);
	}

	/**
	 * Builds the report title and the date header.
	 * 
	 * @param worksheet
	 *            the worksheet
	 * @param startRowIndex
	 *            starting row offset
	 * @param startColIndex
	 *            starting column offset
	 */
	public static void buildTitle(HSSFSheet worksheet, int startRowIndex,
			int startColIndex) {
		// Create font style for the report title
		Font fontTitle = worksheet.getWorkbook().createFont();
		fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD);
		fontTitle.setFontHeight((short) TWOEIGHTY);

		// Create cell style for the report title
		HSSFCellStyle cellStyleTitle = worksheet.getWorkbook()
				.createCellStyle();
		cellStyleTitle.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyleTitle.setWrapText(true);
		cellStyleTitle.setFont(fontTitle);

		// Create report title
		HSSFRow rowTitle = worksheet.createRow((short) startRowIndex);
		rowTitle.setHeight((short) FIVEHUNDRED);
		HSSFCell cellTitle = rowTitle.createCell(startColIndex);
		cellTitle.setCellValue("Invoice Records");
		cellTitle.setCellStyle(cellStyleTitle);

		// Create merged region for the report title
		worksheet.addMergedRegion(new CellRangeAddress(0, 0, 0, FIVE));

		// Create date header
		HSSFRow dateTitle = worksheet.createRow((short) startRowIndex + 1);
		HSSFCell cellDate = dateTitle.createCell(startColIndex);
		cellDate.setCellValue("This report was generated at " + new Date());
	}

	/**
	 * Builds the column headers.
	 * 
	 * @param worksheet
	 *            the worksheet
	 * @param startRowIndex
	 *            starting row offset
	 * @param startColIndex
	 *            starting column offset
	 */
	public static void buildHeaders(HSSFSheet worksheet, int startRowIndex,
			int startColIndex) {
		// Create font style for the headers
		Font font = worksheet.getWorkbook().createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);

		// Create cell style for the headers
		HSSFCellStyle headerCellStyle = worksheet.getWorkbook()
				.createCellStyle();
		headerCellStyle.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
		headerCellStyle.setFillPattern(CellStyle.FINE_DOTS);
		headerCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		headerCellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		headerCellStyle.setWrapText(true);
		headerCellStyle.setFont(font);
		headerCellStyle.setBorderBottom(CellStyle.BORDER_THIN);

		// Create the column headers
		HSSFRow rowHeader = worksheet.createRow((short) startRowIndex + 2);
		rowHeader.setHeight((short) FIVEHUNDRED);

		HSSFCell cell1 = rowHeader.createCell(startColIndex + 0);
		cell1.setCellValue("Id");
		cell1.setCellStyle(headerCellStyle);

		HSSFCell cell2 = rowHeader.createCell(startColIndex + 1);
		cell2.setCellValue("invoiceissuedate");
		cell2.setCellStyle(headerCellStyle);

		HSSFCell cell3 = rowHeader.createCell(startColIndex + 2);
		cell3.setCellValue("invoiceduedate");
		cell3.setCellStyle(headerCellStyle);

		HSSFCell cell4 = rowHeader.createCell(startColIndex + THREE);
		cell4.setCellValue("invoiceprice");
		cell4.setCellStyle(headerCellStyle);

		HSSFCell cell5 = rowHeader.createCell(startColIndex + FOUR);
		cell5.setCellValue("invoicenote");
		cell5.setCellStyle(headerCellStyle);

		HSSFCell cell6 = rowHeader.createCell(startColIndex + FIVE);
		cell6.setCellValue("clientname");
		cell6.setCellStyle(headerCellStyle);

	}

}
