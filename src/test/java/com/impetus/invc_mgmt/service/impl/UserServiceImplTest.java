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
import com.impetus.invc_mgmt.dao.UserDao;
import com.impetus.invc_mgmt.model.Client;
import com.impetus.invc_mgmt.model.User;

public class UserServiceImplTest {
	UserServiceImpl userServiceImpl = new UserServiceImpl();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		UserDao userDao = Mockito.mock(UserDao.class);
		ReflectionTestUtils.setField(userServiceImpl, "userdao", userDao);
		User user = new User();
		userServiceImpl.add(user);
		Mockito.verify(userDao, Mockito.times(1)).add(user);

	}

	@Test
	public void testEdit() {
		UserDao userDao = Mockito.mock(UserDao.class);
		ReflectionTestUtils.setField(userServiceImpl, "userdao", userDao);
		User user = new User();
		userServiceImpl.edit(user);
		Mockito.verify(userDao, Mockito.times(1)).edit(user);

	}

	@Test
	public void testDelete() {
		UserDao userDao = Mockito.mock(UserDao.class);
		ReflectionTestUtils.setField(userServiceImpl, "userdao", userDao);
		User user = new User();
		userServiceImpl.delete(user);
		Mockito.verify(userDao, Mockito.times(1)).delete(user);

	}

	@Test
	public void testAuthenticateUser() {
		UserDao userDao = Mockito.mock(UserDao.class);
		ReflectionTestUtils.setField(userServiceImpl, "userdao", userDao);
		User user = new User();
		Mockito.when(userDao.authenticateUser("user1", "1234"))
				.thenReturn(user);
		assertEquals(user, userServiceImpl.authenticateUser("user1", "1234"));

	}
	
	@Test
	public void testAuthenticateUserwithException() {
		UserDao userDao = Mockito.mock(UserDao.class);
		ReflectionTestUtils.setField(userServiceImpl, "userdao", userDao);
		User user = new User();
		User dummyuser=null;
		Mockito.when(userDao.authenticateUser("user1", "1234"))
				.thenReturn(user);
		assertNotSame(dummyuser, userServiceImpl.authenticateUser("user1", "1234"));

	}

	@Test
	public void testListUsersByTenantId() {
		List<User> list = new ArrayList<User>();
		UserDao userDao = Mockito.mock(UserDao.class);
		ReflectionTestUtils.setField(userServiceImpl, "userdao", userDao);
		Mockito.when(userDao.listUsersByTenantId(1)).thenReturn(list);
		assertEquals(list, userServiceImpl.listUsersByTenantId(1));

	}

	@Test
	public void testListUsersByTenantIdwithException() {
		List<User> list = new ArrayList<User>();
		List<User> dummylist =null;
		UserDao userDao = Mockito.mock(UserDao.class);
		ReflectionTestUtils.setField(userServiceImpl, "userdao", userDao);
		Mockito.when(userDao.listUsersByTenantId(1)).thenReturn(list);
		assertNotSame(dummylist, userServiceImpl.listUsersByTenantId(1));

	}
	
	
	@Test
	public void testGetUserByUserId() {
		UserDao userDao = Mockito.mock(UserDao.class);
		ReflectionTestUtils.setField(userServiceImpl, "userdao", userDao);
		User user = new User();
		Mockito.when(userDao.getUserByUserId(1)).thenReturn(user);
		assertEquals(user, userServiceImpl.getUserByUserId(1));

	}
	
	

	@Test
	public void testGetUserByUserIdwithException() {
		UserDao userDao = Mockito.mock(UserDao.class);
		ReflectionTestUtils.setField(userServiceImpl, "userdao", userDao);
		User user = new User();
		User dummyuser=null;
		Mockito.when(userDao.getUserByUserId(1)).thenReturn(user);
		assertNotSame(dummyuser, userServiceImpl.getUserByUserId(1));

	}

}
