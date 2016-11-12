package com.impetus.invc_mgmt.service.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.impetus.invc_mgmt.dao.ClientDao;
import com.impetus.invc_mgmt.dao.TenantDao;
import com.impetus.invc_mgmt.model.Client;
import com.impetus.invc_mgmt.model.Tenant;

public class TenantServiceImplTest {
	TenantServiceImpl tenantServiceImpl = new TenantServiceImpl();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		TenantDao tenantDao = Mockito.mock(TenantDao.class);
		ReflectionTestUtils.setField(tenantServiceImpl, "tenantdao", tenantDao);
		Tenant tenant = new Tenant();
		tenantServiceImpl.add(tenant);
		Mockito.verify(tenantDao, Mockito.times(1)).add(tenant);

	}

	@Test
	public void testEdit() {
		TenantDao tenantDao = Mockito.mock(TenantDao.class);
		ReflectionTestUtils.setField(tenantServiceImpl, "tenantdao", tenantDao);
		Tenant tenant = new Tenant();
		tenantServiceImpl.edit(tenant);
		Mockito.verify(tenantDao, Mockito.times(1)).edit(tenant);

	}

	@Test
	public void testDelete() {
		TenantDao tenantDao = Mockito.mock(TenantDao.class);
		ReflectionTestUtils.setField(tenantServiceImpl, "tenantdao", tenantDao);
		Tenant tenant = new Tenant();
		tenantServiceImpl.delete(tenant);
		Mockito.verify(tenantDao, Mockito.times(1)).delete(tenant);

	}

	@Test
	public void testGetTenantByTenantId() {
		TenantDao tenantDao = Mockito.mock(TenantDao.class);
		ReflectionTestUtils.setField(tenantServiceImpl, "tenantdao", tenantDao);
		Tenant tenant = new Tenant();
		Mockito.when(tenantDao.getTenantByTenantId(1)).thenReturn(tenant);
		assertEquals(tenant, tenantServiceImpl.getTenantByTenantId(1));

	}
	
	@Test
	public void testGetTenantByTenantIdwithException() {
		TenantDao tenantDao = Mockito.mock(TenantDao.class);
		ReflectionTestUtils.setField(tenantServiceImpl, "tenantdao", tenantDao);
		Tenant tenant = new Tenant();
		Tenant dummytenant=null;
		Mockito.when(tenantDao.getTenantByTenantId(1)).thenReturn(tenant);
		assertNotSame(dummytenant, tenantServiceImpl.getTenantByTenantId(1));

	}

}
