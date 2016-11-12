/**
 * 
 */
package com.impetus.invc_mgmt.service;

import com.impetus.invc_mgmt.model.Tenant;

// TODO: Auto-generated Javadoc
/**
 * The Interface TenantService consist the methods related to tenant.
 * 
 * @author Ashish
 */
public interface TenantService {

	/**
	 * Adds the.
	 * 
	 * @param tenant
	 *            the tenant
	 */
	void add(Tenant tenant);

	/**
	 * Edits the.
	 * 
	 * @param tenant
	 *            the tenant
	 */
	void edit(Tenant tenant);

	/**
	 * Delete.
	 * 
	 * @param tenant
	 *            the tenant
	 */
	void delete(Tenant tenant);

	/**
	 * Gets the tenant by tenant id.
	 * 
	 * @param tenantid
	 *            the tenantid
	 * @return the tenant by tenant id
	 */
	Tenant getTenantByTenantId(int tenantid);

}
