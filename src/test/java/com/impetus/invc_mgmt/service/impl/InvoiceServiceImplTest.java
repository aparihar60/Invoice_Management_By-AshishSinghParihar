package com.impetus.invc_mgmt.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.impetus.invc_mgmt.dao.InvoiceDao;
import com.impetus.invc_mgmt.dao.UserDao;
import com.impetus.invc_mgmt.model.Invoice;
import com.impetus.invc_mgmt.model.User;

public class InvoiceServiceImplTest {
	InvoiceServiceImpl invoiceServiceImpl = new InvoiceServiceImpl();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		InvoiceDao invoiceDao = Mockito.mock(InvoiceDao.class);
		ReflectionTestUtils.setField(invoiceServiceImpl, "invoicedao",
				invoiceDao);
		Invoice invoice = new Invoice();
		invoiceServiceImpl.add(invoice);
		Mockito.verify(invoiceDao, Mockito.times(1)).add(invoice);

	}

	@Test
	public void testEdit() {
		InvoiceDao invoiceDao = Mockito.mock(InvoiceDao.class);
		ReflectionTestUtils.setField(invoiceServiceImpl, "invoicedao",
				invoiceDao);
		Invoice invoice = new Invoice();
		invoiceServiceImpl.edit(invoice);
		Mockito.verify(invoiceDao, Mockito.times(1)).edit(invoice);

	}

	@Test
	public void testDelete() {
		InvoiceDao invoiceDao = Mockito.mock(InvoiceDao.class);
		ReflectionTestUtils.setField(invoiceServiceImpl, "invoicedao",
				invoiceDao);
		Invoice invoice = new Invoice();
		invoiceServiceImpl.delete(invoice);
		Mockito.verify(invoiceDao, Mockito.times(1)).delete(invoice);

	}

	@Test
	public void testGetMaxInvoiceId() {
		InvoiceDao invoiceDao = Mockito.mock(InvoiceDao.class);
		ReflectionTestUtils.setField(invoiceServiceImpl, "invoicedao",
				invoiceDao);
		Invoice invoice = new Invoice();
		Mockito.when(invoiceDao.getMaxInvoiceId()).thenReturn(invoice);
		assertEquals(invoice, invoiceServiceImpl.getMaxInvoiceId());

	}
	
	
	@Test
	public void testGetMaxInvoiceIdwithException() {
		InvoiceDao invoiceDao = Mockito.mock(InvoiceDao.class);
		ReflectionTestUtils.setField(invoiceServiceImpl, "invoicedao",
				invoiceDao);
		Invoice invoice = new Invoice();
		Invoice dummyinvoice = null;
		Mockito.when(invoiceDao.getMaxInvoiceId()).thenReturn(invoice);
		assertNotSame(dummyinvoice, invoiceServiceImpl.getMaxInvoiceId());

	}

	@Test
	public void testGetInvoiceByMaxInvoiceId() {
		InvoiceDao invoiceDao = Mockito.mock(InvoiceDao.class);
		ReflectionTestUtils.setField(invoiceServiceImpl, "invoicedao",
				invoiceDao);
		Mockito.when(invoiceDao.getInvoiceByMaxInvoiceId()).thenReturn(1);
		assertEquals(1, invoiceServiceImpl.getInvoiceByMaxInvoiceId());
	}
	
	
	@Test
	public void testGetInvoiceByMaxInvoiceIdwithException() {
		InvoiceDao invoiceDao = Mockito.mock(InvoiceDao.class);
		ReflectionTestUtils.setField(invoiceServiceImpl, "invoicedao",
				invoiceDao);
		Mockito.when(invoiceDao.getInvoiceByMaxInvoiceId()).thenReturn(1);
		assertNotSame(2, invoiceServiceImpl.getInvoiceByMaxInvoiceId());
	}

	@Test
	public void testGetDueAllnvoices() {
		List<Invoice> list = new ArrayList<Invoice>();
		InvoiceDao invoiceDao = Mockito.mock(InvoiceDao.class);
		ReflectionTestUtils.setField(invoiceServiceImpl, "invoicedao",
				invoiceDao);
		Mockito.when(invoiceDao.getDueAllnvoices(1)).thenReturn(list);
		assertEquals(list, invoiceServiceImpl.getDueAllnvoices(1));

	}
	
	@Test
	public void testGetDueAllnvoiceswithException() {
		List<Invoice> list = new ArrayList<Invoice>();
		List<Invoice> dummylist=null;
		InvoiceDao invoiceDao = Mockito.mock(InvoiceDao.class);
		ReflectionTestUtils.setField(invoiceServiceImpl, "invoicedao",
				invoiceDao);
		Mockito.when(invoiceDao.getDueAllnvoices(1)).thenReturn(list);
		assertNotSame(dummylist, invoiceServiceImpl.getDueAllnvoices(1));

	}
	

	@Test
	public void testGetlatestAllnvoices() {
		List<Invoice> list = new ArrayList<Invoice>();
		InvoiceDao invoiceDao = Mockito.mock(InvoiceDao.class);
		ReflectionTestUtils.setField(invoiceServiceImpl, "invoicedao",
				invoiceDao);
		Mockito.when(invoiceDao.getlatestAllnvoices(1)).thenReturn(list);
		assertEquals(list, invoiceServiceImpl.getlatestAllnvoices(1));
	}
	
	@Test
	public void testGetlatestAllnvoiceswithException() {
		List<Invoice> list = new ArrayList<Invoice>();
		List<Invoice> dummylist=null;
		InvoiceDao invoiceDao = Mockito.mock(InvoiceDao.class);
		ReflectionTestUtils.setField(invoiceServiceImpl, "invoicedao",
				invoiceDao);
		Mockito.when(invoiceDao.getlatestAllnvoices(1)).thenReturn(list);
		assertNotSame(dummylist, invoiceServiceImpl.getlatestAllnvoices(1));
	}
	

	@Test
	public void testGetAllInvoices() {
		List<Invoice> list = new ArrayList<Invoice>();
		InvoiceDao invoiceDao = Mockito.mock(InvoiceDao.class);
		ReflectionTestUtils.setField(invoiceServiceImpl, "invoicedao",
				invoiceDao);
		Mockito.when(invoiceDao.getAllInvoices(1)).thenReturn(list);
		assertEquals(list, invoiceServiceImpl.getAllInvoices(1));
	}
	
	

	@Test
	public void testGetAllInvoiceswithException() {
		List<Invoice> list = new ArrayList<Invoice>();
		List<Invoice> dummylist=null;
		InvoiceDao invoiceDao = Mockito.mock(InvoiceDao.class);
		ReflectionTestUtils.setField(invoiceServiceImpl, "invoicedao",
				invoiceDao);
		Mockito.when(invoiceDao.getAllInvoices(1)).thenReturn(list);
		assertNotSame(dummylist, invoiceServiceImpl.getAllInvoices(1));
	}


	@Test
	public void testGetSearchAllInvoices() {
		List<Invoice> list = new ArrayList<Invoice>();
		InvoiceDao invoiceDao = Mockito.mock(InvoiceDao.class);
		ReflectionTestUtils.setField(invoiceServiceImpl, "invoicedao",
				invoiceDao);
		Mockito.when(invoiceDao.getSearchAllInvoices(1, "name", "param1"))
				.thenReturn(list);
		assertEquals(list,
				invoiceServiceImpl.getSearchAllInvoices(1, "name", "param1"));
	}
	
	
	@Test
	public void testGetSearchAllInvoiceswithexception() {
		List<Invoice> list = new ArrayList<Invoice>();
		List<Invoice> dummylist=null;
		InvoiceDao invoiceDao = Mockito.mock(InvoiceDao.class);
		ReflectionTestUtils.setField(invoiceServiceImpl, "invoicedao",
				invoiceDao);
		Mockito.when(invoiceDao.getSearchAllInvoices(1, "name", "param1"))
				.thenReturn(list);
		assertNotSame(dummylist,
				invoiceServiceImpl.getSearchAllInvoices(1, "name", "param1"));
	}
	

}
