package com.impetus.invc_mgmt.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.Tenant;
import com.impetus.invc_mgmt.model.User;
import com.impetus.invc_mgmt.service.TenantService;

// TODO: Auto-generated Javadoc
/**
 * The Class TenantController takes the request from the browser and give a
 * proper response as per the request related to tenant.
 */
@Controller
public class TenantController {

	/** The logger. */
	private static Logger logger = Logger.getLogger(TenantController.class);

	/** The tenant service. */
	@Autowired
	private TenantService tenantService;

	/** The Constant TENANT. */
	private static final String TENANT = "tenant";

	/**
	 * Show form.
	 * 
	 * @return the tenantregistration jsp
	 */
	@RequestMapping(value = "/Tenant.html", method = RequestMethod.GET)
	public String showForm() {
		logger.info("return a registration form of the tenant");

		return "tenantregistration";
	}

	/**
	 * Show excel.
	 * 
	 * @return the excel jsp
	 */
	@RequestMapping(value = "/excel.html", method = RequestMethod.GET)
	public String showExcel() {
		logger.info("link to download excel format of invoices");

		return "excel";
	}

	/**
	 * Show index.
	 * 
	 * @return the index jsp
	 */
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String showIndex() {
		logger.info("showing login page");

		return "index";
	}

	/**
	 * Edititem.
	 * 
	 * @param tenantid
	 *            the tenantid
	 * @param session
	 *            HttpSession
	 * @param model
	 *            Model
	 * @return the edittenant jsp
	 */
	@RequestMapping(value = "/edittenant.html", method = RequestMethod.GET)
	public String edittenant(@RequestParam("tenantId") int tenantid,
			HttpSession session, Model model) {
		try {

			Tenant tenant = tenantService.getTenantByTenantId(tenantid);

			model.addAttribute(TENANT, tenant);
			logger.info("update the tenant information");

			return "edittenant";
		} catch (Exception e) {
			throw new GenericException("ERROR!");

		}

	}

	/**
	 * Editcurrenttenant.
	 * 
	 * @param tenant
	 *            the tenant
	 * @param session
	 *            HttpSession
	 * @param model
	 *            Model
	 * @return the edittenant jsp
	 */
	@RequestMapping(value = "/editcurrenttenant.html", method = RequestMethod.POST)
	public String editcurrenttenant(@ModelAttribute(TENANT) Tenant tenant,
			HttpSession session, Model model) {
		try {

			tenantService.edit(tenant);
			User user = (User) session.getAttribute("user");
			Tenant tenant1 = user.getTenant();

			model.addAttribute(TENANT, tenant1);
			logger.info("upadate the current tenant by its own admin");
			return "header";
		} catch (Exception e) {
			throw new GenericException("ERROR!");

		}

	}

	/**
	 * Simple.
	 * 
	 * @param tenant
	 *            the tenant
	 * @param session
	 *            HttpSession
	 * @param model
	 *            Model
	 */
	@RequestMapping(value = "/registrationsuccess.html", method = RequestMethod.POST)
	public void addtenant(@ModelAttribute(TENANT) Tenant tenant,
			HttpSession session, Model model) {

		try {

			session.setAttribute(TENANT, tenant);
			tenantService.add(tenant);
			model.addAttribute(TENANT, tenant);
			logger.info("successfull registration of tenant");
		} catch (Exception e) {
			throw new GenericException("ERROR!");

		}

	}

}
