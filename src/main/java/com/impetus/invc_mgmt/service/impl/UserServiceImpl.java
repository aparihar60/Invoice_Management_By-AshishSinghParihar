package com.impetus.invc_mgmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.invc_mgmt.dao.UserDao;
import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.User;
import com.impetus.invc_mgmt.service.UserService;

// TODO: Auto-generated Javadoc

/**
 * The Class UserServiceImpl implements the interface UserService and interacts
 * with UserDao.
 */
@Service
public class UserServiceImpl implements UserService {

	/** The userdao. */
	@Autowired
	private UserDao userdao;
	private static final String ERROR = "ERROR!";
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.UserService#add(com.impetus.invc_mgmt.model
	 * .User)
	 */
	@Transactional
	public void add(User user) {
		// TODO Auto-generated method stub
		
		
		try {
			userdao.add(user);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.UserService#edit(com.impetus.invc_mgmt.
	 * model.User)
	 */
	@Transactional
	public void edit(User user) {
		// TODO Auto-generated method stub
		try {
			userdao.edit(user);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.UserService#delete(com.impetus.invc_mgmt
	 * .model.User)
	 */
	@Transactional
	public void delete(User user) {
		// TODO Auto-generated method stub
		try {
			userdao.delete(user);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.UserService#authenticateUser(java.lang.
	 * String, java.lang.String)
	 */
	@Transactional
	public User authenticateUser(String logid, String pass) {
		try {
			return userdao.authenticateUser(logid, pass);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.service.UserService#listUsersByTenantId(int)
	 */
	@Transactional
	public List<User> listUsersByTenantId(int tenantId) {
		// TODO Auto-generated method stub
		try {
			return userdao.listUsersByTenantId(tenantId);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.service.UserService#getUserByUserId(int)
	 */
	@Transactional
	public User getUserByUserId(int userid) {
		// TODO Auto-generated method stub
		try {
			return userdao.getUserByUserId(userid);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

}
