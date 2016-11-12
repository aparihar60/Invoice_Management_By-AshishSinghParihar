package com.impetus.invc_mgmt.util;

import static org.junit.Assert.*;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.impetus.invc_mgmt.model.Client;
import com.impetus.invc_mgmt.model.Invoice;
import com.impetus.invc_mgmt.model.InvoiceDetail;
import com.impetus.invc_mgmt.model.Tenant;
import com.itextpdf.text.DocumentException;

public class PDFInvoiceTest {
PDFInvoice pdfInvoice = new PDFInvoice();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPDFInvoice() {
		
	}

	@Test
	public void testInvoicePdf() throws DocumentException {
		OutputStream outputstream= Mockito.mock(OutputStream.class);
		Tenant tenant = new Tenant();
		tenant.setTenantid(63);
		Invoice invoice = new Invoice();
		invoice.setTenant(tenant);
		Client client = new Client();
		invoice.setClient(client);
		List<InvoiceDetail> list = new ArrayList<InvoiceDetail>();
		pdfInvoice.invoicePdf(outputstream, invoice, list);
		
	}

}
