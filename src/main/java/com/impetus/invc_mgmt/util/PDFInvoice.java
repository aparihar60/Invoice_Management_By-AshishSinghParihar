package com.impetus.invc_mgmt.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.impetus.invc_mgmt.model.Invoice;
import com.impetus.invc_mgmt.model.InvoiceDetail;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class PDFInvoice is used to generate the invoice detail in pdf format.
 */
public class PDFInvoice {

	/** The Constant TWELVE. */
	private static final int TWOTWOFIVE = 225, SIXTEEN = 16, THREE = 3,
			FOUR = 4, HUNDRED = 100, EIGHT = 8, TWELVE = 12;

	/** The Constant TEN. */
	private static final float HUNDREDS = 100f, TEN = 10f;

	/** The logger. */
	private static Logger logger = Logger.getLogger(PDFInvoice.class);

	/** The b. */
	private static BaseColor b = new BaseColor(TWOTWOFIVE, TWOTWOFIVE,
			TWOTWOFIVE);

	/**
	 * Instantiates a new pDF invoice.
	 */
	public PDFInvoice() {

		// TODO Auto-generated constructor stub
	}

	/** The sub font. */
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN,
			SIXTEEN, Font.BOLD);

	/**
	 * Invoice pdf.
	 * 
	 * @param outputstream
	 *            the outputstream
	 * @param invoice
	 *            the invoice
	 * @param list
	 *            the list
	 * @throws DocumentException
	 *             the document exception
	 */
	public void invoicePdf(OutputStream outputstream, Invoice invoice,
			List<InvoiceDetail> list) throws DocumentException {

		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, outputstream);
		document.open();

		document.setMargins(TEN, HUNDREDS, 0.0f, 0.0f);

		Paragraph preface = new Paragraph();
		
		String total = String.valueOf(invoice.getInvoiceprice());

		addEmptyLine(preface, 1);

		Image image = null;
		try {
			image = Image
					.getInstance("D:\\invoice_mgmt\\invc_mgmt\\src\\main\\webapp\\images\\"
							+ invoice.getTenant().getTenantid() + ".jpg");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			logger.info("Exception");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.info("Exception");
		}
		document.add(image);

		addEmptyLine(preface, 1);

		preface.add(new Paragraph("Client's Name:  "
				+ invoice.getClient().getClientfname()));
		preface.add(new Paragraph("Client's Address:  "
				+ invoice.getClient().getClientaddress()));

		addEmptyLine(preface, 2);
		addEmptyLine(preface, 1);

		preface.add(createTable(invoice));

		addEmptyLine(preface, THREE);
		PdfPTable table1 = new PdfPTable(FOUR);
		table1.setWidthPercentage(HUNDRED);

		table1 = createTable1();
		preface.add(table1);

		for (int i = 0; i < list.size(); i++) {
			Integer q = list.get(i).getInvoicedetailquantity();
			Double m = list.get(i).getInvoicedetailitemprice();
			Double n = list.get(i).getInvoicedetailamount();
			String name = list.get(i).getItem().getItemname();
			{
				addRow(name, m.toString(), q.toString(), n.toString(), preface);
			}
		}

		addBelowTable("Total Amount =  " + total, preface);

		document.add(preface);
		Font footFont = new Font(Font.FontFamily.TIMES_ROMAN, EIGHT,
				Font.NORMAL);

		Paragraph footerHeadOfficeAdd = new Paragraph(
				"Impetus It park,Indore, Tel:", footFont);

		Paragraph footPara = new Paragraph();

		footPara.add(footerHeadOfficeAdd);
		document.add(footPara);

		document.newPage();
		document.close();
	}

	/**
	 * Creates the table.
	 * 
	 * @param invoice
	 *            the invoice
	 * @return the pdf p table
	 */
	private PdfPTable createTable(Invoice invoice) {
		PdfPTable table = new PdfPTable(FOUR);

		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_BOTTOM);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.setWidthPercentage(HUNDRED);
		PdfPCell c1 = new PdfPCell(new Phrase("", subFont));
		c1.setBorder(Rectangle.NO_BORDER);

		table.addCell(c1);

		c1 = new PdfPCell(new Phrase());
		c1.setBorder(Rectangle.NO_BORDER);
		table.addCell(c1);
		c1 = new PdfPCell(new Phrase());

		c1.setBackgroundColor(b);
		c1.addElement(new Phrase("Invoice Id:"));
		c1.addElement(new Phrase("Due Date:"));

		table.addCell(c1);
		c1 = new PdfPCell(new Phrase());
		c1.setHorizontalAlignment(Element.ALIGN_LEFT);

		c1.addElement(new Phrase("" + invoice.getInvoiceid()));
		c1.addElement(new Phrase("" + invoice.getInvoiceduedate()));

		table.addCell(c1);
		return table;
	}

	/**
	 * Creates the table1.
	 * 
	 * @return the pdf p table
	 */
	private PdfPTable createTable1() {
		PdfPTable table1 = new PdfPTable(FOUR);
		table1.setWidthPercentage(HUNDRED);

		PdfPCell c2 = new PdfPCell(new Phrase("ItemName",
				new Font(Font.FontFamily.TIMES_ROMAN, TWELVE, Font.BOLD,
						BaseColor.BLACK)));
		c2.setBackgroundColor(b);
		table1.addCell(c2);

		c2 = new PdfPCell(new Phrase("Unitprice",
				new Font(Font.FontFamily.TIMES_ROMAN, TWELVE, Font.BOLD,
						BaseColor.BLACK)));
		c2.setBackgroundColor(b);
		table1.addCell(c2);

		c2 = new PdfPCell(new Phrase("Quantity",
				new Font(Font.FontFamily.TIMES_ROMAN, TWELVE, Font.BOLD,
						BaseColor.BLACK)));
		c2.setBackgroundColor(b);
		table1.addCell(c2);

		c2 = new PdfPCell(new Phrase("Amount",
				new Font(Font.FontFamily.TIMES_ROMAN, TWELVE, Font.BOLD,
						BaseColor.BLACK)));
		c2.setBackgroundColor(b);
		table1.addCell(c2);
		return table1;
	}

	/**
	 * Adds the below table.
	 * 
	 * @param content
	 *            the content
	 * @param preface
	 *            the preface
	 */
	private static void addBelowTable(String content, Paragraph preface) {
		PdfPTable table2 = new PdfPTable(2);
		table2.setWidthPercentage(HUNDRED);
		PdfPCell c3 = new PdfPCell(new Phrase());
		c3.setBorder(Rectangle.NO_BORDER);
		table2.addCell(c3);
		c3 = new PdfPCell(new Phrase(content));
		c3.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table2.addCell(c3);
		preface.add(table2);

	}

	/**
	 * Adds the row.
	 * 
	 * @param i
	 *            the i
	 * @param d
	 *            the d
	 * @param u
	 *            the u
	 * @param q
	 *            the q
	 * @param perface1
	 *            the perface1
	 * @throws DocumentException
	 *             the document exception
	 */
	private static void addRow(String i, String d, String u, String q,
			Paragraph perface1) throws DocumentException {
		PdfPTable table = new PdfPTable(FOUR);
		table.setWidthPercentage(HUNDRED);
		PdfPCell c2 = new PdfPCell(new Phrase(i, new Font(
				Font.FontFamily.TIMES_ROMAN, TWELVE, Font.NORMAL,
				BaseColor.BLACK)));

		table.addCell(c2);
		c2 = new PdfPCell(new Phrase(d, new Font(Font.FontFamily.TIMES_ROMAN,
				TWELVE, Font.NORMAL, BaseColor.BLACK)));

		table.addCell(c2);
		c2 = new PdfPCell(new Phrase(u, new Font(Font.FontFamily.TIMES_ROMAN,
				TWELVE, Font.NORMAL, BaseColor.BLACK)));

		table.addCell(c2);
		c2 = new PdfPCell(new Phrase(q, new Font(Font.FontFamily.TIMES_ROMAN,
				TWELVE, Font.NORMAL, BaseColor.BLACK)));

		table.addCell(c2);
		perface1.add(table);

	}

	/**
	 * Adds the empty line.
	 * 
	 * @param paragraph
	 *            the paragraph
	 * @param number
	 *            the number
	 */
	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
}
