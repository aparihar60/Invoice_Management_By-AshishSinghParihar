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

import com.impetus.invc_mgmt.model.Client;
import com.impetus.invc_mgmt.model.Invoice;
import com.impetus.invc_mgmt.model.Item;
import com.impetus.invc_mgmt.model.RecurringInvoice;
import com.impetus.invc_mgmt.model.Tenant;
import com.impetus.invc_mgmt.model.User;
import com.impetus.invc_mgmt.service.ClientService;
import com.impetus.invc_mgmt.service.InvoiceDetailService;
import com.impetus.invc_mgmt.service.InvoiceService;
import com.impetus.invc_mgmt.service.ItemService;
import com.impetus.invc_mgmt.service.RecurringInvoiceDetailService;
import com.impetus.invc_mgmt.service.RecurringInvoiceService;

public class RecurringInvoiceControllerTest {
	@Autowired
	private MockHttpServletRequest request;
	MockHttpServletResponse httpServletResponse;
	javax.servlet.http.HttpSession session;
	RecurringInvoiceController recurringInvoiceController = new RecurringInvoiceController();

	@Test
	public void testInvoice() {
		ClientService clientService = Mockito.mock(ClientService.class);
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils.setField(recurringInvoiceController,
				"clientService", clientService);
		ItemService itemService = Mockito.mock(ItemService.class);
		ReflectionTestUtils.setField(recurringInvoiceController, "itemService",
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
		assertEquals("recurringinvoice",
				recurringInvoiceController.invoice(model, session));
	}

	@Test
	public void testAddInvoice() {
		int recurringinvoiceoccurence = 1;
		String recurringinvoicefrequency = "weekly";
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
		ReflectionTestUtils.setField(recurringInvoiceController, "itemService",
				itemService);
		ClientService clientService = Mockito.mock(ClientService.class);
		this.request = new MockHttpServletRequest();
		ModelMap model = new ModelMap();
		this.session = (MockHttpSession) request.getSession();
		RecurringInvoiceService recurringInvoiceService = Mockito
				.mock(RecurringInvoiceService.class);
		RecurringInvoiceDetailService recurringInvoiceDetailService = Mockito
				.mock(RecurringInvoiceDetailService.class);
		ReflectionTestUtils.setField(recurringInvoiceController,
				"clientService", clientService);
		ReflectionTestUtils.setField(recurringInvoiceController,
				"recurringInvoiceDetailService", recurringInvoiceDetailService);
		ReflectionTestUtils.setField(recurringInvoiceController,
				"recurringinvoiceService", recurringInvoiceService);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		Client client = new Client();
		Mockito.when(clientService.getClientByClientId(1)).thenReturn(client);
		Mockito.when(
				recurringInvoiceService
						.getRecurringInvoiceByMaxRecurringInvoiceId())
				.thenReturn(1);
		Mockito.when(itemService.getItemByItemId(Integer.valueOf("1")))
				.thenReturn(new Item());
		assertEquals("recurringinvoiceinserted",
				recurringInvoiceController.addInvoice(invoicedetailquantity,
						invoicedetailamount, "10", invoicedetailitemprice, "1",
						itemId, recurringinvoiceoccurence, "note",
						recurringinvoicefrequency, "434.56", "02/02/1989",
						session, model));
	}

}
