package com.impetus.invc_mgmt.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.impetus.invc_mgmt.bean.ItemBean;
import com.impetus.invc_mgmt.model.Item;
import com.impetus.invc_mgmt.model.Tenant;
import com.impetus.invc_mgmt.model.User;
import com.impetus.invc_mgmt.service.ItemService;

public class ItemControllerTest {

	@Autowired
	private MockHttpServletRequest request;

	javax.servlet.http.HttpSession session;

	ItemController itemController = new ItemController();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testItem() {
		ItemService itemService = Mockito.mock(ItemService.class);
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils
				.setField(itemController, "itemService", itemService);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		List<Item> itemlist = new ArrayList<Item>();
		Mockito.when(itemService.getAllItems(1)).thenReturn(itemlist);
		assertEquals("showitem", itemController.item(session, model));

	}

	@Test
	public void testAdditem() {
		ModelMap modelMap = new ModelMap();
		assertEquals("additem", itemController.additem(modelMap));
	}

	@Test
	public void testItemlist() {
		ItemService itemService = Mockito.mock(ItemService.class);
		this.request = new MockHttpServletRequest();
		ModelMap modelMap = new ModelMap();
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils
				.setField(itemController, "itemService", itemService);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		List<Item> itemlist = new ArrayList<Item>();
		Mockito.when(itemService.getAllItems(1)).thenReturn(itemlist);
		assertEquals("itemlist", itemController.itemlist(session, modelMap));
	}

	@Test
	public void testAdditemItemBeanHttpSessionModel() {
		ItemService itemService = Mockito.mock(ItemService.class);
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		Tenant tenant = new Tenant();
		session.setAttribute("tenant", tenant);
		ItemBean itemBean = new ItemBean();
		ReflectionTestUtils
				.setField(itemController, "itemService", itemService);
		itemBean.setItemname("monitor");
		assertEquals("itemregistered",
				itemController.additem(itemBean, session, model));
	}

	@Test
	public void testDeleteitem() {
		ItemService itemService = Mockito.mock(ItemService.class);
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils
				.setField(itemController, "itemService", itemService);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		List<Item> itemlist = new ArrayList<Item>();
		Mockito.when(itemService.getAllItems(1)).thenReturn(itemlist);
		assertEquals("showitem", itemController.deleteitem(12, session, model));
	}

	@Test
	public void testEdititem() {
		ItemService itemService = Mockito.mock(ItemService.class);
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils
				.setField(itemController, "itemService", itemService);
		Mockito.when(itemService.getItemByItemId(12)).thenReturn(new Item());
		assertEquals("edititem", itemController.edititem(12, session, model));
	}

	@Test
	public void testItemamount() {
		ItemService itemService = Mockito.mock(ItemService.class);
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils
				.setField(itemController, "itemService", itemService);
		Mockito.when(itemService.getItemByItemId(12)).thenReturn(new Item());
		assertEquals("itemamount",
				itemController.itemamount(12, session, model));
	}

	@Test
	public void testEditcurrentitem() {
		ItemService itemService = Mockito.mock(ItemService.class);
		this.request = new MockHttpServletRequest();
		Model model = Mockito.mock(Model.class);
		this.session = (MockHttpSession) request.getSession();
		ReflectionTestUtils
				.setField(itemController, "itemService", itemService);
		User user = new User();
		Tenant tenant = new Tenant();
		tenant.setTenantid(1);
		user.setTenant(tenant);
		session.setAttribute("user", user);
		List<Item> itemlist = new ArrayList<Item>();
		Mockito.when(itemService.getAllItems(1)).thenReturn(itemlist);
		assertEquals("showitem",
				itemController.editcurrentitem(new Item(), session, model));
	}

}
