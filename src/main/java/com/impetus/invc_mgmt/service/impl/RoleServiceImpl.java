package com.impetus.invc_mgmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.invc_mgmt.dao.RoleDao;
import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.Role;
import com.impetus.invc_mgmt.service.RoleService;

// TODO: Auto-generated Javadoc

/**
 * The Class RoleServiceImpl implements the interface RoleService and interacts
 * with RoleDao.
 */
@Service
public class RoleServiceImpl implements RoleService {

	/** The roledao. */
	@Autowired
	private RoleDao roledao;
	
	private static final String ERROR = "ERROR!";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.RoleService#add(com.impetus.invc_mgmt.model
	 * .Role)
	 */
	@Transactional
	public void add(Role role) {
		// TODO Auto-generated method stub
		try {
			roledao.add(role);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.RoleService#edit(com.impetus.invc_mgmt.
	 * model.Role)
	 */
	@Transactional
	public void edit(Role role) {
		// TODO Auto-generated method stub
		try {
			roledao.edit(role);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.RoleService#delete(com.impetus.invc_mgmt
	 * .model.Role)
	 */
	@Transactional
	public void delete(Role role) {
		// TODO Auto-generated method stub
		try {
			roledao.delete(role);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

}
