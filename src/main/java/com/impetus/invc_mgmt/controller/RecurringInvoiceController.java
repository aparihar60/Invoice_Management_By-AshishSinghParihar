package com.impetus.invc_mgmt.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.Client;
import com.impetus.invc_mgmt.model.Item;
import com.impetus.invc_mgmt.model.RecurringInvoice;
import com.impetus.invc_mgmt.model.RecurringInvoiceDetail;
import com.impetus.invc_mgmt.model.Tenant;
import com.impetus.invc_mgmt.model.User;
import com.impetus.invc_mgmt.service.ClientService;
import com.impetus.invc_mgmt.service.ItemService;
import com.impetus.invc_mgmt.service.RecurringInvoiceDetailService;
import com.impetus.invc_mgmt.service.RecurringInvoiceService;

// TODO: Auto-generated Javadoc

/**
 * The Class RecurringInvoiceController takes the request from the browser and
 * give a proper response as per the request related recurring invoice.
 */

@Controller
public class RecurringInvoiceController {

	/** The logger. */
	private static Logger logger = Logger
			.getLogger(RecurringInvoiceController.class);

	/** The recurringinvoice service. */
	@Autowired
	private RecurringInvoiceService recurringinvoiceService;

	/** The item service. */
	@Autowired
	private ItemService itemService;

	/** The client service. */
	@Autowired
	private ClientService clientService;

	/** The recurring invoice detail service. */
	@Autowired
	private RecurringInvoiceDetailService recurringInvoiceDetailService;

	/**
	 * Invoice.
	 * 
	 * @param model
	 *            the model
	 * @param session
	 *            HttpSession
	 * @return the recurringinvoice jsp
	 */
	@RequestMapping(value = "/recurringinvoice.html", method = RequestMethod.GET)
	public String invoice(Model model, HttpSession session) {

		try {

			User user = (User) session.getAttribute("user");
			Tenant tenant = user.getTenant();
			int tenantId = tenant.getTenantid();
			List<Client> clientList = clientService.getAllClients(tenantId);
			List<Item> itemList = itemService.getAllItems(tenantId);

			model.addAttribute("itemList", itemList);
			model.addAttribute("clientList", clientList);
			logger.info("showing client list and item list in the recurring invoice");

			return "recurringinvoice";
		} catch (Exception e) {
			throw new GenericException("ERROR!");

		}
	}

	/**
	 * Adds the invoice.
	 * 
	 * @param recurringinvoicedetailquantity
	 *            the recurringinvoicedetailquantity
	 * @param recurringinvoicedetailamount
	 *            the recurringinvoicedetailamount
	 * @param recurringinvoicetax
	 *            the recurringinvoicetax
	 * @param recurringinvoicedetailprice
	 *            the recurringinvoicedetailprice
	 * @param clientId
	 *            the client id
	 * @param itemId
	 *            the item id
	 * @param recurringinvoiceoccurence
	 *            the recurringinvoiceoccurence
	 * @param recurringinvoicenote
	 *            the recurringinvoicenote
	 * @param recurringinvoicefrequency
	 *            the recurringinvoicefrequency
	 * @param recurringinvoiceprice
	 *            the recurringinvoiceprice
	 * @param invoiceissuedate
	 *            the invoiceissuedate
	 * @param session
	 *            HttpSession
	 * @param model
	 *            the model
	 * @return the null
	 */
	@RequestMapping(value = "/insertrecurringinvoice.html", method = RequestMethod.POST)
	String addInvoice(
			@RequestParam("recurringinvoicedetailquantity") String[] recurringinvoicedetailquantity,

			@RequestParam("recurringinvoicedetailamount") String[] recurringinvoicedetailamount,
			@RequestParam("recurringinvoicetax") String recurringinvoicetax,
			@RequestParam("recurringinvoicedetailprice") String[] recurringinvoicedetailprice,
			@RequestParam("clientList") String clientId,
			@RequestParam("itemList") String[] itemId,
			@RequestParam("recurringinvoiceoccurence") int recurringinvoiceoccurence,
			@RequestParam("recurringinvoicenote") String recurringinvoicenote,
			@RequestParam("recurringinvoicefrequency") String recurringinvoicefrequency,
			@RequestParam("recurringinvoiceprice") String recurringinvoiceprice,
			@RequestParam("invoiceissuedate") String invoiceissuedate,
			HttpSession session, ModelMap model) {

		try {

			RecurringInvoice recinvoice = new RecurringInvoice();
			List<RecurringInvoiceDetail> list = new ArrayList<RecurringInvoiceDetail>();

			Client client = new Client();
			client.setClientid(Integer.parseInt(clientId));

			User user = (User) session.getAttribute("user");

			Tenant t = user.getTenant();

			recinvoice.setTenant(t);
			recinvoice.setUser(user);
			recinvoice.setRecurringinvoicenote(recurringinvoicenote);
			recinvoice.setRecurringinvoicetax(Double
					.valueOf(recurringinvoicetax));
			recinvoice.setRecurringinvoiceprice(Double
					.valueOf(recurringinvoiceprice));
			recinvoice.setClient(client);
			recinvoice.setRecurringinvoicefrequency(recurringinvoicefrequency);

			String dateString = invoiceissuedate;

			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date convertedDate = null;
			try {
				convertedDate = dateFormat.parse(dateString);
			} catch (ParseException e2) {

			}
			recinvoice.setRecurringinvoiceissuedate(convertedDate);

			recinvoice.setRecurringinvoiceoccurence(recurringinvoiceoccurence);

			recurringinvoiceService.add(recinvoice);

			int length = itemId.length;
			RecurringInvoiceDetail recinvoiceItem = new RecurringInvoiceDetail();
			Item item = null;
			long invId = recurringinvoiceService
					.getRecurringInvoiceByMaxRecurringInvoiceId();
			RecurringInvoice recinv = new RecurringInvoice();
			recinv.setRecurringinvoiceid((int) invId);

			for (int i = 0; i < length; i++) {
				item = new Item();
				item.setItemid(Integer.valueOf(itemId[i]));

				recinvoiceItem = new RecurringInvoiceDetail();
				recinvoiceItem.setRecurringinvoice(recinv);

				recinvoiceItem.setItem(item);
				recinvoiceItem.setRecurringinvoicedetailquantity(Integer
						.valueOf(recurringinvoicedetailquantity[i]));
				recinvoiceItem.setRecurringinvoicedetailprice(Double
						.valueOf(recurringinvoicedetailprice[i]));

				recinvoiceItem.setRecurringinvoicedetailamount(Double
						.valueOf(recurringinvoicedetailamount[i]));
				list.add(recinvoiceItem);
				recurringInvoiceDetailService.add(recinvoiceItem);
			}
			model.addAttribute("ClientName", recinvoice.getClient()
					.getClientfname());

			logger.info("insert a new recurring invoice");

			return "recurringinvoiceinserted";
		} catch (Exception e) {
			throw new GenericException("ERROR!");

		}

	}
}
