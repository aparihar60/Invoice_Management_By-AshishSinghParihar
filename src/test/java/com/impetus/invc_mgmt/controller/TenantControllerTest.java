package com.impetus.invc_mgmt.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.Model;

import com.impetus.invc_mgmt.model.Tenant;
import com.impetus.invc_mgmt.model.User;
import com.impetus.invc_mgmt.service.TenantService;

public class TenantControllerTest {
	@Autowired
	private MockHttpServletRequest request;

	javax.servlet.http.HttpSession session;
	TenantController tenantController = new TenantController();

	@Test
	public void testShowForm() {
		assertEquals("tenantregistration", tenantController.showForm());
	}

	@Test
	public void testShowExcel() {
		assertEquals("excel", tenantController.showExcel());
	}

	@Test
	public void testShowIndex() {
		assertEquals("index", tenantController.showIndex());
	}

	@Test
	public void testEdittenant() {
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		TenantService tenantService = Mockito.mock(TenantService.class);
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils.setField(tenantController, "tenantService",
				tenantService);
		Mockito.when(tenantService.getTenantByTenantId(1)).thenReturn(
				new Tenant());
		assertEquals("edittenant",
				tenantController.edittenant(1, session, model));
	}

	@Test
	public void testEditcurrenttenant() {
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		TenantService tenantService = Mockito.mock(TenantService.class);
		this.session = (MockHttpSession) request.getSession();
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		ReflectionTestUtils.setField(tenantController, "tenantService",
				tenantService);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		assertEquals("header",
				tenantController.editcurrenttenant(tenant, session, model));
	}

	@Test
	public void testAddtenant() {
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		TenantService tenantService = Mockito.mock(TenantService.class);
		this.session = (MockHttpSession) request.getSession();
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		ReflectionTestUtils.setField(tenantController, "tenantService",
				tenantService);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		tenantController.addtenant(tenant, session, model);
	}

}
