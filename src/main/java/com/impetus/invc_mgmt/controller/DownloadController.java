package com.impetus.invc_mgmt.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.Tenant;
import com.impetus.invc_mgmt.model.User;
import com.impetus.invc_mgmt.util.DownloadService;

// TODO: Auto-generated Javadoc
/**
 * The Class DownloadController takes the request from the browser and give a
 * proper response as per the request related excel sheet download.
 */
@Controller
@RequestMapping("/download.html")
public class DownloadController {

	/** The logger. */
	private static Logger logger = Logger.getLogger("controller");

	/** The download service. */
	@Resource(name = "downloadService")
	private DownloadService downloadService;

	/**
	 * Downloads the report as an Excel format.
	 * 
	 * @param fromdate
	 *            the fromdate
	 * @param todate
	 *            the todate
	 * @param response
	 *            HttpServletResponse
	 * @param model
	 *            Model
	 * @param session
	 *            HttpSession
	 * @return the xls
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@RequestMapping(value = "/xls", method = RequestMethod.GET)
	public void getXLS(@RequestParam("fromdate") String fromdate,
			@RequestParam("todate") String todate,
			HttpServletResponse response, Model model, HttpSession session)
			throws ClassNotFoundException {

		logger.debug("Received request to download report as an XLS");

		User user = (User) session.getAttribute("user");
		Tenant tenant = user.getTenant();
		int tenantid = tenant.getTenantid();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date from = null;
		Date to = null;
		try {
			from = new java.sql.Date(dateFormat.parse(fromdate).getTime());
			to = new java.sql.Date(dateFormat.parse(todate).getTime());
		} catch (Exception e) {
			throw new GenericException("ERROR!");

		}

		downloadService.downloadXLS(response, tenantid, from, to);
	}

}
