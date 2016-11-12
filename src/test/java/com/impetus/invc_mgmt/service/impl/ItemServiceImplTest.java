package com.impetus.invc_mgmt.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.impetus.invc_mgmt.dao.ClientDao;
import com.impetus.invc_mgmt.dao.ItemDao;
import com.impetus.invc_mgmt.model.Client;
import com.impetus.invc_mgmt.model.Item;

public class ItemServiceImplTest {
	ItemServiceImpl itemServiceImpl = new ItemServiceImpl();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		ItemDao itemDao = Mockito.mock(ItemDao.class);
		ReflectionTestUtils.setField(itemServiceImpl, "itemdao", itemDao);
		Item item = new Item();
		itemServiceImpl.add(item);
		Mockito.verify(itemDao, Mockito.times(1)).add(item);

	}

	
	
	
	
	@Test
	public void testEdit() {
		ItemDao itemDao = Mockito.mock(ItemDao.class);
		ReflectionTestUtils.setField(itemServiceImpl, "itemdao", itemDao);
		Item item = new Item();
		itemServiceImpl.edit(item);
		Mockito.verify(itemDao, Mockito.times(1)).edit(item);

	}

	@Test
	public void testDelete() {
		ItemDao itemDao = Mockito.mock(ItemDao.class);
		ReflectionTestUtils.setField(itemServiceImpl, "itemdao", itemDao);
		Item item = new Item();
		itemServiceImpl.delete(item);
		Mockito.verify(itemDao, Mockito.times(1)).delete(item);

	}

	@Test
	public void testGetAllItems() {
		List<Item> list = new ArrayList<Item>();
		ItemDao itemDao = Mockito.mock(ItemDao.class);
		ReflectionTestUtils.setField(itemServiceImpl, "itemdao", itemDao);
		Mockito.when(itemDao.getAllItem(1)).thenReturn(list);
		assertEquals(list, itemServiceImpl.getAllItems(1));

	}

	@Test
	public void testGetAllItemswithException() {
		List<Item> list = new ArrayList<Item>();
		List<Item> dummylist=null;
		ItemDao itemDao = Mockito.mock(ItemDao.class);
		ReflectionTestUtils.setField(itemServiceImpl, "itemdao", itemDao);
		Mockito.when(itemDao.getAllItem(1)).thenReturn(list);
		assertNotSame(dummylist, itemServiceImpl.getAllItems(1));

	}
	
	

	@Test
	public void testGetItemByItemId() {
		Item item = new Item();
		ItemDao itemDao = Mockito.mock(ItemDao.class);
		ReflectionTestUtils.setField(itemServiceImpl, "itemdao", itemDao);
		Mockito.when(itemDao.getItemByItemId(1)).thenReturn(item);
		assertEquals(item, itemServiceImpl.getItemByItemId(1));
	}
	
	@Test
	public void testGetItemByItemIdwithexception() {
		Item item = new Item();
		Item dummyitem=null; 
		ItemDao itemDao = Mockito.mock(ItemDao.class);
		ReflectionTestUtils.setField(itemServiceImpl, "itemdao", itemDao);
		Mockito.when(itemDao.getItemByItemId(1)).thenReturn(item);
		assertNotSame(dummyitem, itemServiceImpl.getItemByItemId(1));
	}

}
