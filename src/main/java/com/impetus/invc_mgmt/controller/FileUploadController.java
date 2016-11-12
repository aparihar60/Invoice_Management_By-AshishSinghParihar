package com.impetus.invc_mgmt.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.impetus.invc_mgmt.bean.FileUploadForm;
import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.Client;
import com.impetus.invc_mgmt.model.Tenant;
import com.impetus.invc_mgmt.model.User;
import com.impetus.invc_mgmt.service.ClientService;
import com.impetus.invc_mgmt.util.ClientXMLParser;

// TODO: Auto-generated Javadoc
/**
 * The Class FileUploadController takes the request from the browser and give a
 * proper response as per the request related file upload condition.
 */
@Controller
public class FileUploadController {

	/** The logger. */
	private static Logger logger = Logger.getLogger(FileUploadController.class);

	/** The client service. */
	@Autowired
	private ClientService clientService;

	/**
	 * The clist.
	 * 
	 * @return the string
	 */

	/**
	 * Display form.
	 * 
	 * @return the fileupload jsp
	 */
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String displayForm() {
		logger.info("returning a jsp page");
		return "fileupload";
	}

	/**
	 * Save.
	 * 
	 * @param uploadForm
	 *            the upload form
	 * @param map
	 *            Model
	 * @param session
	 *            Http
	 * @return the showclient jsp
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("uploadForm") FileUploadForm uploadForm,
			Model map, HttpSession session) {

		try {

			User user = (User) session.getAttribute("user");
			Tenant tenant = user.getTenant();
			List<MultipartFile> files = uploadForm.getFiles();
			List<Client> clist = null;
			List<String> fileNames = new ArrayList<String>();

			for (MultipartFile multipartFile : files) {

				clist = new ClientXMLParser()
						.retreiveClientListFromXML(multipartFile);
				String fileName = multipartFile.getOriginalFilename();
				fileNames.add(fileName);

			}

			for (Client c : clist) {
				c.setTenant(tenant);
				clientService.add(c);
			}

			List<Client> clientlist = clientService.getAllClients(tenant
					.getTenantid());

			map.addAttribute("clientlist", clientlist);

			map.addAttribute("files", fileNames);
			logger.info("showing the client list");
			return "showclient";
		} catch (Exception e) {

			throw new GenericException("Format of xml file is not correct");
		}
	}

	/**
	 * Savetenantlogo.
	 * 
	 * @param uploadForm
	 *            the upload form
	 * @param map
	 *            Model
	 * @param session
	 *            Http
	 * @return the edittenant jsp
	 */
	@RequestMapping(value = "/tenantlogo.html", method = RequestMethod.POST)
	public String savetenantlogo(
			@ModelAttribute("uploadForm") FileUploadForm uploadForm, Model map,
			HttpSession session) {

		User user = (User) session.getAttribute("user");

		int tenantid = user.getTenant().getTenantid();
		MultipartFile multipartFile = (MultipartFile) uploadForm
				.getFileToUpload();
		File newFile = new File(
				"D:\\apache-tomcat-7.0.20\\webapps\\invc_mgmt\\images\\"
						+ tenantid + ".jpg");

		try {
			multipartFile.transferTo(newFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			logger.info("exception1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.info("exception2");
		}
		logger.info("save the tenant logo by the user");
		return "edittenant";
	}

}
