package com.impetus.invc_mgmt.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.impetus.invc_mgmt.bean.ClientBean;
import com.impetus.invc_mgmt.model.Client;
import com.impetus.invc_mgmt.model.Tenant;
import com.impetus.invc_mgmt.model.User;
import com.impetus.invc_mgmt.service.ClientService;

public class ClientControllerTest {
	@Autowired
	private MockHttpServletRequest request;

	javax.servlet.http.HttpSession session;

	ClientController clientController = new ClientController();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testClient() {
		ClientService clientService = Mockito.mock(ClientService.class);
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils.setField(clientController, "clientService",
				clientService);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		List<Client> clientlist = new ArrayList<Client>();
		Mockito.when(clientService.getAllClients(1)).thenReturn(clientlist);
		assertEquals("showclient", clientController.client(session, model));

	}

	@Test
	public void testAddclient() {
		ModelMap modelMap = new ModelMap();
		assertEquals("addclient", clientController.addclient(modelMap));
	}

	@Test
	public void testClintlist() {
		ClientService clientService = Mockito.mock(ClientService.class);
		this.request = new MockHttpServletRequest();
		ModelMap modelMap = new ModelMap();
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils.setField(clientController, "clientService",
				clientService);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		List<Client> clientlist = new ArrayList<Client>();
		Mockito.when(clientService.getAllClients(1)).thenReturn(clientlist);
		assertEquals("clintlist", clientController.clientlist(session, modelMap));
	}

	@Test
	public void testSimple() {
		ClientService clientService = Mockito.mock(ClientService.class);
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		ModelMap modelMap = new ModelMap();
		BindingResult bindingResult=Mockito.mock(BindingResult.class);
		this.session = (MockHttpSession) request.getSession();
		Tenant tenant = new Tenant();
		session.setAttribute("tenant", tenant);
		ClientBean clientBean = new ClientBean();
		ReflectionTestUtils.setField(clientController, "clientService",
				clientService);
		clientBean.setClientemail("asp.gmail.com");
		assertEquals("clientregistered",
				clientController.simple(clientBean,bindingResult, session, modelMap));
	}

	@Test
	public void testDeleteclient() {
		ClientService clientService = Mockito.mock(ClientService.class);
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils.setField(clientController, "clientService",
				clientService);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		List<Client> clientlist = new ArrayList<Client>();
		Mockito.when(clientService.getAllClients(1)).thenReturn(clientlist);
		assertEquals("showclient",
				clientController.deleteclient(12, session, model));
	}

	@Test
	public void testEditclient() {
		ClientService clientService = Mockito.mock(ClientService.class);
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils.setField(clientController, "clientService",
				clientService);
		Mockito.when(clientService.getClientByClientId(12)).thenReturn(
				new Client());
		assertEquals("editclient",
				clientController.editclient(12, session, model));
	}

	@Test
	public void testEditcurrentclient() {
		ClientService clientService = Mockito.mock(ClientService.class);
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils.setField(clientController, "clientService",
				clientService);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		List<Client> clientlist = new ArrayList<Client>();
		Mockito.when(clientService.getAllClients(1)).thenReturn(clientlist);
		assertEquals("showclient", clientController.editcurrentclient(
				new Client(), session, model));
	}

}
