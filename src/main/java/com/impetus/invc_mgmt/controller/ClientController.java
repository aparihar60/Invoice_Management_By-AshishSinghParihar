package com.impetus.invc_mgmt.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.impetus.invc_mgmt.bean.ClientBean;
import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.Client;
import com.impetus.invc_mgmt.model.Tenant;
import com.impetus.invc_mgmt.model.User;
import com.impetus.invc_mgmt.service.ClientService;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientController takes the request from the browser and give a
 * proper response as per the request related to client.
 */
@Controller
public class ClientController 

	/** The logger. */
	private static Logger logger = Logger.getLogger(LoginController.class);

	/** The client service. */
	@Autowired
	private ClientService clientService;

	/** The Constant USER. */
	private static final String USER = "user";

	/** The Constant CLIENTLIST. */
	private static final String CLIENTLIST = "clientlist";
	
	private static final String ERROR = "ERROR!";

	/**
	 * Client.
	 * 
	 * @param session
	 *            the session
	 * @param model
	 *            Model
	 * @return the showclient jsp
	 */
	@RequestMapping(value = "/client.html", method = RequestMethod.GET)
	public String client(HttpSession session, Model model) {
		try {

			User user = (User) session.getAttribute(USER);
			Integer tenantid = user.getTenant().getTenantid();
			List<Client> clientlist = clientService.getAllClients(tenantid);

			model.addAttribute(CLIENTLIST, clientlist);
			logger.info("showing all client list");
			return "showclient";
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/**
	 * Addclient.
	 * 
	 * @param model
	 *            ModelMap
	 * @return the addclient jsp
	 */
	@RequestMapping(value = "/addclient.html", method = RequestMethod.GET)
	public String addclient(ModelMap model) {

		model.addAttribute("Client", new ClientBean());
		logger.info("return a jsp page");

		return "addclient";
	}

	/**
	 * Clintlist.
	 * 
	 * @param session
	 *            the session
	 * @param model
	 *            ModelMap
	 * @return the clintlist jsp
	 */
	@RequestMapping(value = "/clintlist.html", method = RequestMethod.GET)
	public String clientlist(HttpSession session, ModelMap model) {

		try {

			User user = (User) session.getAttribute(USER);
			Integer tenantid = user.getTenant().getTenantid();
			List<Client> clientlist = clientService.getAllClients(tenantid);

			model.addAttribute(CLIENTLIST, clientlist);
			logger.info("showing client list as per tenant");
			return "clintlist";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}
	}

	/**
	 * Simple.
	 * 
	 * @param clientBean
	 *            the client bean
	 * @param session
	 *            the session
	 * @param model
	 *            Model
	 * @return the clientregistered jsp
	 */
	@RequestMapping(value = "/insertclient.html", method = RequestMethod.POST)
	public String simple(@ModelAttribute("client") @Valid ClientBean clientBean,
			BindingResult result, HttpSession session, ModelMap model) {
		

		if (result.hasErrors()) {
			return "addclient";
		}
		
		try {

			Tenant tenant = ((Tenant) session.getAttribute("tenant"));
			Client client = new Client();
			client.setClientaddress(clientBean.getClientaddress());
			client.setClientcompany(clientBean.getClientcompany());
			client.setClientcontactno(clientBean.getClientcontactno());
			client.setClientemail(clientBean.getClientemail());
			client.setClientfname(clientBean.getClientfname());
			client.setClientlname(clientBean.getClientlname());
			client.setTenant(tenant);
			clientService.add(client);
			model.addAttribute("client", client);
			logger.info("adding a new client");

			return "clientregistered";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}

	/**
	 * Deleteclient.
	 * 
	 * @param clientid
	 *            the clientid
	 * @param session
	 *            the session
	 * @param model
	 *            Model
	 * @return the showclient jsp
	 */
	@RequestMapping(value = "/deleteclient.html", method = RequestMethod.GET)
	public String deleteclient(@RequestParam("clientId") int clientid,
			HttpSession session, Model model) {

		try {
			Client client = new Client();
			client.setClientid(clientid);
			clientService.delete(client);
			User user = (User) session.getAttribute(USER);
			Integer tenantid = user.getTenant().getTenantid();
			List<Client> clientlist = clientService.getAllClients(tenantid);
			model.addAttribute(CLIENTLIST, clientlist);
			logger.info("deleting a client");
			return "showclient";
		} catch (Exception e) {
			throw new GenericException(e.getMessage());

		}

	}

	/**
	 * Edititem.
	 * 
	 * @param clientid
	 *            the clientid
	 * @param session
	 *            the session
	 * @param model
	 *            Model
	 * @return the editclient jsp
	 */
	@RequestMapping(value = "/editclient.html", method = RequestMethod.GET)
	public String editclient(@RequestParam("clientId") int clientid,
			HttpSession session, Model model) {
		try {

			Client client = clientService.getClientByClientId(clientid);

			model.addAttribute("client", client);
			logger.info("update the information of the client");
			return "editclient";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}

	/**
	 * Editcurrentitem.
	 * 
	 * @param client
	 *            the client object which is to be edited
	 * @param session
	 *            the session
	 * @param model
	 *            Model
	 * @return the showclient jsp
	 */
	@RequestMapping(value = "/editcurrentclient.html", method = RequestMethod.POST)
	public String editcurrentclient(@ModelAttribute("Client") Client client,
			HttpSession session, Model model) {

		try {

			clientService.edit(client);
			User user = (User) session.getAttribute(USER);
			Integer tenantid = user.getTenant().getTenantid();
			List<Client> clientlist = clientService.getAllClients(tenantid);
			model.addAttribute(CLIENTLIST, clientlist);
			logger.info("update the client info as per the tenant");
			return "showclient";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}

}
