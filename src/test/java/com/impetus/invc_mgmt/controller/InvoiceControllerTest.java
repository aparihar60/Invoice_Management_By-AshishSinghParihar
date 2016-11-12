package com.impetus.invc_mgmt.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.Client;
import com.impetus.invc_mgmt.model.Invoice;
import com.impetus.invc_mgmt.model.Item;
import com.impetus.invc_mgmt.model.Tenant;
import com.impetus.invc_mgmt.model.User;
import com.impetus.invc_mgmt.service.ClientService;
import com.impetus.invc_mgmt.service.InvoiceDetailService;
import com.impetus.invc_mgmt.service.InvoiceService;
import com.impetus.invc_mgmt.service.ItemService;

public class InvoiceControllerTest {
	@Autowired
	private MockHttpServletRequest request;
	MockHttpServletResponse httpServletResponse;
	javax.servlet.http.HttpSession session;
	InvoiceController invoiceController = new InvoiceController();

	@Test
	public void testInvoice() {
		ClientService clientService = Mockito.mock(ClientService.class);
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils.setField(invoiceController, "clientService",
				clientService);
		ItemService itemService = Mockito.mock(ItemService.class);
		ReflectionTestUtils.setField(invoiceController, "itemService",
				itemService);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		List<Client> clientlist = new ArrayList<Client>();
		Mockito.when(clientService.getAllClients(1)).thenReturn(clientlist);
		List<Item> itemList = new ArrayList<Item>();
		Mockito.when(itemService.getAllItems(1)).thenReturn(itemList);
		assertEquals("invoice", invoiceController.invoice(model, session));
	}

	@Test
	public void testAddinvoice() {
		String[] invoicedetailquantity = new String[2];
		invoicedetailquantity[0] = "1";
		invoicedetailquantity[1] = "2";
		String[] invoicedetailamount = new String[2];
		invoicedetailamount[0] = "1";
		invoicedetailamount[1] = "2";
		String[] invoicedetailitemprice = new String[2];
		invoicedetailitemprice[0] = "12";
		invoicedetailitemprice[1] = "13";
		String[] itemId = new String[2];
		itemId[0] = "2";
		itemId[1] = "1";
		ItemService itemService = Mockito.mock(ItemService.class);
		ReflectionTestUtils.setField(invoiceController, "itemService",
				itemService);
		ClientService clientService = Mockito.mock(ClientService.class);
		this.request = new MockHttpServletRequest();
		ModelMap model = new ModelMap();
		this.session = (MockHttpSession) request.getSession();
		InvoiceService invoiceService = Mockito.mock(InvoiceService.class);
		InvoiceDetailService invoiceDetailService = Mockito
				.mock(InvoiceDetailService.class);
		ReflectionTestUtils.setField(invoiceController, "clientService",
				clientService);
		ReflectionTestUtils.setField(invoiceController, "invoiceDetailService",
				invoiceDetailService);
		ReflectionTestUtils.setField(invoiceController, "invoiceService",
				invoiceService);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		Client client = new Client();
		Mockito.when(clientService.getClientByClientId(1)).thenReturn(client);
		Mockito.when(invoiceService.getInvoiceByMaxInvoiceId()).thenReturn(1);
		Mockito.when(itemService.getItemByItemId(Integer.valueOf("1")))
				.thenReturn(new Item());
		assertEquals("invoiceinserted", invoiceController.addinvoice(
				invoicedetailquantity, "02/02/1989", invoicedetailamount,
				"2134.435", invoicedetailitemprice, "1", itemId, "invoicenote",
				"2342.2134", session, model));
	}

	@Test
	public void testShowdashboard() {
		assertEquals("dashboard", invoiceController.showdashboard());
	}

	@Test
	public void testInvoiceduelist() {
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		List<Invoice> invoiceList = new ArrayList<Invoice>();
		Invoice invoice = new Invoice();
		Date invoiceduedate = new Date();
		Date invoiceissuedate = new Date();
		invoice.setInvoiceissuedate(invoiceissuedate);
		invoice.setInvoiceduedate(invoiceduedate);

		invoiceList.add(invoice);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		InvoiceService invoiceService = Mockito.mock(InvoiceService.class);
		ReflectionTestUtils.setField(invoiceController, "invoiceService",
				invoiceService);
		Mockito.when(invoiceService.getDueAllnvoices(1))
				.thenReturn(invoiceList);
		assertEquals(invoiceList,
				invoiceController.invoiceduelist(model, session));
	}

	@Test
	public void testInvoicelatestlist() {
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		List<Invoice> invoiceList = new ArrayList<Invoice>();
		Invoice invoice = new Invoice();
		Date invoiceduedate = new Date();
		Date invoiceissuedate = new Date();
		invoice.setInvoiceissuedate(invoiceissuedate);
		invoice.setInvoiceduedate(invoiceduedate);
		invoiceList.add(invoice);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		InvoiceService invoiceService = Mockito.mock(InvoiceService.class);
		ReflectionTestUtils.setField(invoiceController, "invoiceService",
				invoiceService);
		Mockito.when(invoiceService.getlatestAllnvoices(1)).thenReturn(
				invoiceList);
		assertEquals(invoiceList,
				invoiceController.invoicelatestlist(model, session));
	}

	@Test
	public void testInvoicelist() {
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		List<Invoice> invoiceList = new ArrayList<Invoice>();
		Invoice invoice = new Invoice();
		Date invoiceduedate = new Date();
		Date invoiceissuedate = new Date();
		invoice.setInvoiceissuedate(invoiceissuedate);
		invoice.setInvoiceduedate(invoiceduedate);
		invoiceList.add(invoice);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		InvoiceService invoiceService = Mockito.mock(InvoiceService.class);
		ReflectionTestUtils.setField(invoiceController, "invoiceService",
				invoiceService);
		Mockito.when(invoiceService.getAllInvoices(1)).thenReturn(invoiceList);
		assertEquals("showinvoices",
				invoiceController.invoicelist(session, model));
	}

	@Test
	public void testSearchinvoice() {

		ClientService clientService = Mockito.mock(ClientService.class);
		this.request = new MockHttpServletRequest();
		ModelMap modelMap = new ModelMap();
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils.setField(invoiceController, "clientService",
				clientService);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		List<Client> clientlist = new ArrayList<Client>();
		Mockito.when(clientService.getAllClients(1)).thenReturn(clientlist);
		assertEquals("searchinvoice",
				invoiceController.searchinvoice(session, modelMap));
	}

	@Test
	public void testSearchinvoicelist() {
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		List<Invoice> invoiceList = new ArrayList<Invoice>();
		Invoice invoice = new Invoice();
		Date invoiceduedate = new Date();
		Date invoiceissuedate = new Date();
		invoice.setInvoiceissuedate(invoiceissuedate);
		invoice.setInvoiceduedate(invoiceduedate);
		invoiceList.add(invoice);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		InvoiceService invoiceService = Mockito.mock(InvoiceService.class);
		ReflectionTestUtils.setField(invoiceController, "invoiceService",
				invoiceService);
		Mockito.when(
				invoiceService.getSearchAllInvoices(1, "searchby", "param"))
				.thenReturn(invoiceList);
		assertEquals("searchinvoice", invoiceController.searchinvoicelist(
				"searchby", "param", session, model));
	}

	
	

	@Test
	public void testUnpaidinvoicelist() {
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		List<Invoice> invoiceList = new ArrayList<Invoice>();
		Invoice invoice = new Invoice();
		Date invoiceduedate = new Date();
		Date invoiceissuedate = new Date();
		invoice.setInvoiceissuedate(invoiceissuedate);
		invoice.setInvoiceduedate(invoiceduedate);
		invoiceList.add(invoice);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		InvoiceService invoiceService = Mockito.mock(InvoiceService.class);
		ReflectionTestUtils.setField(invoiceController, "invoiceService",
				invoiceService);
		Mockito.when(invoiceService.getUnpaidInvoices(1)).thenReturn(
				invoiceList);
		assertEquals("showunpaidinvoices",
				invoiceController.unpaidinvoicelist(session, model));
	}

	@Test
	public void testEdititem() {
		try{
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		User user = new User();
		Invoice invoice = new Invoice();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		InvoiceService invoiceService = Mockito.mock(InvoiceService.class);
		ReflectionTestUtils.setField(invoiceController, "invoiceService",
				invoiceService);
		Mockito.when(invoiceService.getInvoiceByInvoiceId(1, 1)).thenReturn(
				invoice);
		
	
				invoiceController.edititem(1, session, model);
		}
catch(Exception e){
	GenericException exception = (GenericException) e;
	assertEquals(null ,exception.getLocalizedMessage());
	
}
	}

}
