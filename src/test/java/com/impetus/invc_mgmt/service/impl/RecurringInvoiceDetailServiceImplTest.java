package com.impetus.invc_mgmt.service.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.impetus.invc_mgmt.dao.ClientDao;
import com.impetus.invc_mgmt.dao.RecurringInvoiceDetailDao;
import com.impetus.invc_mgmt.model.Client;
import com.impetus.invc_mgmt.model.RecurringInvoiceDetail;

public class RecurringInvoiceDetailServiceImplTest {
	RecurringInvoiceDetailServiceImpl recurringInvoiceDetailServiceImpl = new RecurringInvoiceDetailServiceImpl();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		RecurringInvoiceDetailDao recurringInvoiceDetailDao = Mockito
				.mock(RecurringInvoiceDetailDao.class);
		ReflectionTestUtils.setField(recurringInvoiceDetailServiceImpl,
				"recurringinvoicedetaildao", recurringInvoiceDetailDao);
		RecurringInvoiceDetail recurringInvoiceDetail = new RecurringInvoiceDetail();
		recurringInvoiceDetailServiceImpl.add(recurringInvoiceDetail);
		Mockito.verify(recurringInvoiceDetailDao, Mockito.times(1)).add(
				recurringInvoiceDetail);

	}

	@Test
	public void testEdit() {
		RecurringInvoiceDetailDao recurringInvoiceDetailDao = Mockito
				.mock(RecurringInvoiceDetailDao.class);
		ReflectionTestUtils.setField(recurringInvoiceDetailServiceImpl,
				"recurringinvoicedetaildao", recurringInvoiceDetailDao);
		RecurringInvoiceDetail recurringInvoiceDetail = new RecurringInvoiceDetail();
		recurringInvoiceDetailServiceImpl.edit(recurringInvoiceDetail);
		Mockito.verify(recurringInvoiceDetailDao, Mockito.times(1)).edit(
				recurringInvoiceDetail);

	}

	@Test
	public void testDelete() {
		RecurringInvoiceDetailDao recurringInvoiceDetailDao = Mockito
				.mock(RecurringInvoiceDetailDao.class);
		ReflectionTestUtils.setField(recurringInvoiceDetailServiceImpl,
				"recurringinvoicedetaildao", recurringInvoiceDetailDao);
		RecurringInvoiceDetail recurringInvoiceDetail = new RecurringInvoiceDetail();
		recurringInvoiceDetailServiceImpl.delete(recurringInvoiceDetail);
		Mockito.verify(recurringInvoiceDetailDao, Mockito.times(1)).delete(
				recurringInvoiceDetail);

	}

}
