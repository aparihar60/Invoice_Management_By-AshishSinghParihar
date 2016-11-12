package com.impetus.invc_mgmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.invc_mgmt.dao.TenantDao;
import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.Tenant;
import com.impetus.invc_mgmt.service.TenantService;

// TODO: Auto-generated Javadoc

/**
 * The Class TenantServiceImpl implements the interface TenantService and
 * interacts with TenantDao.
 */
@Service
public class TenantServiceImpl implements TenantService {

	/** The tenantdao. */
	@Autowired
	private TenantDao tenantdao;
	private static final String ERROR = "ERROR!";
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.TenantService#add(com.impetus.invc_mgmt
	 * .model.Tenant)
	 */
	@Transactional
	public void add(Tenant tenant) {
		// TODO Auto-generated method stub
		try {
			tenantdao.add(tenant);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.TenantService#edit(com.impetus.invc_mgmt
	 * .model.Tenant)
	 */
	@Transactional
	public void edit(Tenant tenant) {
		// TODO Auto-generated method stub
		try {
			tenantdao.edit(tenant);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.TenantService#delete(com.impetus.invc_mgmt
	 * .model.Tenant)
	 */
	@Transactional
	public void delete(Tenant tenant) {
		// TODO Auto-generated method stub
		try {
			tenantdao.delete(tenant);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.service.TenantService#getTenantByTenantId(int)
	 */
	@Transactional
	public Tenant getTenantByTenantId(int tenantid) {
		// TODO Auto-generated method stub
		try {
			return tenantdao.getTenantByTenantId(tenantid);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

}
