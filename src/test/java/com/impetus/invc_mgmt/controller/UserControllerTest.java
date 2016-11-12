package com.impetus.invc_mgmt.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.impetus.invc_mgmt.model.Client;
import com.impetus.invc_mgmt.model.Role;
import com.impetus.invc_mgmt.model.Tenant;
import com.impetus.invc_mgmt.model.User;
import com.impetus.invc_mgmt.service.ClientService;
import com.impetus.invc_mgmt.service.UserService;

public class UserControllerTest {

	@Autowired
	private MockHttpServletRequest request;

	javax.servlet.http.HttpSession session;
	UserController userController = new UserController();

	@Test
	public void testAddUser() {
		UserService userService = Mockito.mock(UserService.class);
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils
				.setField(userController, "userService", userService);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		session.setAttribute("tenant", tenant);
		userController.addUser(user, session, model);

	}

	@Test
	public void testShowForm() {
		assertEquals("userregistration", userController.showForm());
	}

	@Test
	public void testAdduser() {
		UserService userService = Mockito.mock(UserService.class);
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils
				.setField(userController, "userService", userService);
		User user = new User();
		Role role = new Role();
		role.setRoleid(1);
		user.setRole(role);

		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		session.setAttribute("tenant", tenant);
		userController.adduser(user, session, model, 1);

	}

	@Test
	public void testLogoutForm() {
		this.request = new MockHttpServletRequest();
		this.session = (MockHttpSession) request.getSession();
		User user = new User();
		user.setUserid(1);
		session.setAttribute("user", user);

		assertEquals("index", userController.logoutForm(session));
	}

	@Test
	public void testClose() {

		assertEquals("index", userController.close());
	}

	@Test
	public void testUploadFile() {
		assertEquals("fileupload", userController.uploadFile());
	}

	@Test
	public void testShowUserManagerPage() {
		UserService userService = Mockito.mock(UserService.class);
		this.request = new MockHttpServletRequest();
		ModelMap model = new ModelMap();
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils
				.setField(userController, "userService", userService);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		List<User> tenantUserList = new ArrayList<User>();
		Mockito.when(userService.listUsersByTenantId(1)).thenReturn(
				tenantUserList);
		assertEquals("shownormalusers",
				userController.showUserManagerPage(model, session));
	}

	@Test
	public void testEdituser() {
		UserService userService = Mockito.mock(UserService.class);
		;
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils
				.setField(userController, "userService", userService);
		Mockito.when(userService.getUserByUserId(12)).thenReturn(new User());
		assertEquals("editnormaluser",
				userController.edituser(12, session, model));
	}

	@Test
	public void testEditcurrentuser() {
		UserService userService = Mockito.mock(UserService.class);
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils
				.setField(userController, "userService", userService);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		;
		Integer userid = user.getUserid();

		Mockito.when(userService.getUserByUserId(12)).thenReturn(new User());
		assertEquals("editadmin",
				userController.updateProfile(session, model));
	}

	@Test
	public void testDeleteuser() {
		UserService userService = Mockito.mock(UserService.class);
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils
				.setField(userController, "userService", userService);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		List<User> userList = new ArrayList<User>();
		Mockito.when(userService.listUsersByTenantId(1)).thenReturn(userList);
		assertEquals("shownormalusers",
				userController.deleteuser(12, session, model));
	}

	@Test
	public void testShowNormalUserForm() {
		assertEquals("addnormaluserbyadmin",
				userController.showNormalUserForm());
	}

	@Test
	public void testNormaluserbyadmin() {
		UserService userService = Mockito.mock(UserService.class);
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils
				.setField(userController, "userService", userService);
		User user = new User();
		Role role = new Role();
		role.setRoleid(1);
		user.setRole(role);

		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		session.setAttribute("tenant", tenant);
		userController.adduser(user, session, model, 1);
	}

}
