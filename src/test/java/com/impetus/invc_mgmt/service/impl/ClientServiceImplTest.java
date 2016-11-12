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
import com.impetus.invc_mgmt.model.Client;

public class ClientServiceImplTest {
	ClientServiceImpl clientServiceImpl = new ClientServiceImpl();

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		ClientDao clientDao = Mockito.mock(ClientDao.class);
		ReflectionTestUtils.setField(clientServiceImpl, "clientdao", clientDao);
		Client client = new Client();
		clientServiceImpl.add(client);
		Mockito.verify(clientDao, Mockito.times(1)).add(client);

	}

	@Test
	public void testEdit() {
		ClientDao clientDao = Mockito.mock(ClientDao.class);
		ReflectionTestUtils.setField(clientServiceImpl, "clientdao", clientDao);
		Client client = new Client();
		clientServiceImpl.edit(client);
		Mockito.verify(clientDao, Mockito.times(1)).edit(client);

	}

	@Test
	public void testDelete() {
		ClientDao clientDao = Mockito.mock(ClientDao.class);
		ReflectionTestUtils.setField(clientServiceImpl, "clientdao", clientDao);
		Client client = new Client();
		clientServiceImpl.delete(client);
		Mockito.verify(clientDao, Mockito.times(1)).delete(client);

	}

	@Test
	public void testGetAllClients() {
		List<Client> list = new ArrayList<Client>();
		ClientDao clientDao = Mockito.mock(ClientDao.class);
		ReflectionTestUtils.setField(clientServiceImpl, "clientdao", clientDao);
		Mockito.when(clientDao.getAllClient(1)).thenReturn(list);
		assertEquals(list, clientServiceImpl.getAllClients(1));

	}
	
	
	@Test
	public void testGetAllClientswithException() {
		List<Client> list = new ArrayList<Client>();
		List<Client> dummylist=null;
		ClientDao clientDao = Mockito.mock(ClientDao.class);
		ReflectionTestUtils.setField(clientServiceImpl, "clientdao", clientDao);
		Mockito.when(clientDao.getAllClient(1)).thenReturn(list);
		assertNotSame(dummylist, clientServiceImpl.getAllClients(2));

	}

	@Test
	public void testGetClientByClientId() {
		ClientDao clientDao = Mockito.mock(ClientDao.class);
		ReflectionTestUtils.setField(clientServiceImpl, "clientdao", clientDao);
		Client client = new Client();
		Mockito.when(clientDao.getClientByClientId(1)).thenReturn(client);
		assertEquals(client, clientServiceImpl.getClientByClientId(1));
	}
	
	
	@Test
	public void testGetClientByClientIdwithException() {
		ClientDao clientDao = Mockito.mock(ClientDao.class);
		ReflectionTestUtils.setField(clientServiceImpl, "clientdao", clientDao);
		Client client = new Client();
		Client dummyclient = null;
		
		Mockito.when(clientDao.getClientByClientId(1)).thenReturn(client);
		assertNotSame(dummyclient, clientServiceImpl.getClientByClientId(1));
	}

}
