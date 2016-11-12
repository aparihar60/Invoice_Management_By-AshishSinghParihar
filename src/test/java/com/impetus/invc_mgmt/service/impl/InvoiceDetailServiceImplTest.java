package com.impetus.invc_mgmt.service.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.impetus.invc_mgmt.dao.InvoiceDetailDao;
import com.impetus.invc_mgmt.dao.RecurringInvoiceDetailDao;
import com.impetus.invc_mgmt.model.InvoiceDetail;
import com.impetus.invc_mgmt.model.RecurringInvoiceDetail;

public class InvoiceDetailServiceImplTest {
	InvoiceDetailServiceImpl invoiceDetailServiceImpl = new InvoiceDetailServiceImpl();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		InvoiceDetailDao invoiceDetailDao = Mockito
				.mock(InvoiceDetailDao.class);
		ReflectionTestUtils.setField(invoiceDetailServiceImpl,
				"invoicedetaildao", invoiceDetailDao);
		InvoiceDetail invoiceDetail = new InvoiceDetail();
		invoiceDetailServiceImpl.add(invoiceDetail);
		Mockito.verify(invoiceDetailDao, Mockito.times(1)).add(invoiceDetail);

	}

	@Test
	public void testEdit() {
		InvoiceDetailDao invoiceDetailDao = Mockito
				.mock(InvoiceDetailDao.class);
		ReflectionTestUtils.setField(invoiceDetailServiceImpl,
				"invoicedetaildao", invoiceDetailDao);
		InvoiceDetail invoiceDetail = new InvoiceDetail();
		invoiceDetailServiceImpl.edit(invoiceDetail);
		Mockito.verify(invoiceDetailDao, Mockito.times(1)).edit(invoiceDetail);

	}

	@Test
	public void testDelete() {
		InvoiceDetailDao invoiceDetailDao = Mockito
				.mock(InvoiceDetailDao.class);
		ReflectionTestUtils.setField(invoiceDetailServiceImpl,
				"invoicedetaildao", invoiceDetailDao);
		InvoiceDetail invoiceDetail = new InvoiceDetail();
		invoiceDetailServiceImpl.delete(invoiceDetail);
		Mockito.verify(invoiceDetailDao, Mockito.times(1))
				.delete(invoiceDetail);

	}

}
