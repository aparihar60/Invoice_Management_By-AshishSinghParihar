package com.impetus.invc_mgmt.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.Model;

import com.impetus.invc_mgmt.model.Tenant;
import com.impetus.invc_mgmt.model.User;
import com.impetus.invc_mgmt.service.ClientService;
import com.impetus.invc_mgmt.util.DownloadService;

public class DownloadControllerTest {
	@Autowired
	private MockHttpServletRequest request;
	javax.servlet.http.HttpSession session;
	DownloadController downloadController = new DownloadController();

	@Test
	public void testGetXLS() throws Exception {
		DownloadService downloadService = Mockito.mock(DownloadService.class);
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils.setField(downloadController, "downloadService",
				downloadService);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		/*
		 * downloadController.getXLS(null, model, session);
		 * Mockito.verify(downloadService,Mockito.times(1)).downloadXLS(null,
		 * 1);
		 */

	}

}
