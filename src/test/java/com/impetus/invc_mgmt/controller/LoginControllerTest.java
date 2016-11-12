package com.impetus.invc_mgmt.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ModelMap;

import com.impetus.invc_mgmt.model.Role;
import com.impetus.invc_mgmt.model.Tenant;
import com.impetus.invc_mgmt.model.User;
import com.impetus.invc_mgmt.service.UserService;

public class LoginControllerTest {
	@Autowired
	private MockHttpServletRequest request;
	javax.servlet.http.HttpSession session;
	LoginController loginController = new LoginController();

	@Test
	public void testSimple() {
		User user = new User();
		user.setUserloginid("logid");
		user.setUserpassword("pass");
		this.request = new MockHttpServletRequest();
		ModelMap model = new ModelMap();
		this.session = (MockHttpSession) request.getSession();
		UserService userService = Mockito.mock(UserService.class);
		ReflectionTestUtils.setField(loginController, "userService",
				userService);
		User user2 = new User();
		user2 = null;
		Mockito.when(userService.authenticateUser("logid", "pass")).thenReturn(
				user2);
		assertEquals("index", loginController.simple(user, session, model));

	}

	@Test
	public void testSimpleWithNotNull() {
		User user = new User();
		user.setUserloginid("logid");
		user.setUserpassword("pass");
		this.request = new MockHttpServletRequest();
		ModelMap model = new ModelMap();
		this.session = (MockHttpSession) request.getSession();
		UserService userService = Mockito.mock(UserService.class);
		ReflectionTestUtils.setField(loginController, "userService",
				userService);
		User user2 = new User();
		Role role = new Role();
		role.setRoleid(2);
		user2.setRole(role);
		user2.setTenant(new Tenant());
		Mockito.when(userService.authenticateUser("logid", "pass")).thenReturn(
				user2);
		assertEquals("dashboard", loginController.simple(user, session, model));
		role.setRoleid(3);
		user2.setRole(role);
		user2.setTenant(new Tenant());
		Mockito.when(userService.authenticateUser("logid", "pass")).thenReturn(
				user2);
		assertEquals("dashboard", loginController.simple(user, session, model));
		role.setRoleid(4);
		user2.setRole(role);
		user2.setTenant(new Tenant());
		Mockito.when(userService.authenticateUser("logid", "pass")).thenReturn(
				user2);
		assertEquals("usertypeselect",
				loginController.simple(user, session, model));

	}
}
