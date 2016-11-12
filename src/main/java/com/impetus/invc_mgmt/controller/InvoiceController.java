package com.impetus.invc_mgmt.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.jfree.chart.ChartUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.Client;
import com.impetus.invc_mgmt.model.Invoice;
import com.impetus.invc_mgmt.model.InvoiceDetail;
import com.impetus.invc_mgmt.model.Item;
import com.impetus.invc_mgmt.model.Tenant;
import com.impetus.invc_mgmt.model.User;
import com.impetus.invc_mgmt.service.ClientService;
import com.impetus.invc_mgmt.service.InvoiceDetailService;
import com.impetus.invc_mgmt.service.InvoiceService;
import com.impetus.invc_mgmt.service.ItemService;
import com.impetus.invc_mgmt.util.CreateGraph;
import com.impetus.invc_mgmt.util.MailInvoice;
import com.impetus.invc_mgmt.util.ThankyouMail;

// TODO: Auto-generated Javadoc
/**
 * The Class InvoiceController takes the request from the browser and give a
 * proper response as per the request related invoice activity.
 */
@Controller
public class InvoiceController {

	/** The logger. */
	private static Logger logger = Logger.getLogger(LoginController.class);

	/** The item service. */
	@Autowired
	private ItemService itemService;

	/** The invoice service. */
	@Autowired
	private InvoiceService invoiceService;

	/** The Constant USER. */
	private static final String USER = "user";

	/** The client service. */
	@Autowired
	private ClientService clientService;

	/** The invoice detail service. */
	@Autowired
	private InvoiceDetailService invoiceDetailService;

	/** The Constant CLIENTLIST. */
	private static final String CLIENTLIST = "clientlist";

	/**
	 * Invoice.
	 * 
	 * @param model
	 *            Model
	 * @param session
	 *            http
	 * @return the invoice jsp
	 */
	@RequestMapping(value = "/invoice.html", method = RequestMethod.GET)
	public String invoice(Model model, HttpSession session) {

		try {

			User user = (User) session.getAttribute(USER);
			Tenant tenant = user.getTenant();
			int tenantId = tenant.getTenantid();
			List<Client> clientList = clientService.getAllClients(tenantId);
			List<Item> itemList = itemService.getAllItems(tenantId);

			model.addAttribute("itemList", itemList);
			model.addAttribute("clientList", clientList);
			logger.info("showing client list and item list in the invoice page");

			return "invoice";
		} catch (Exception e) {
			throw new GenericException(e.getMessage());

		}
	}

	/**
	 * Adds the invoice.
	 * 
	 * @param invoicedetailquantity
	 *            the invoicedetailquantity
	 * @param invoiceduedate
	 *            the invoiceduedate
	 * @param invoicedetailamount
	 *            the invoicedetailamount
	 * @param invoicetax
	 *            the invoicetax
	 * @param invoicedetailitemprice
	 *            the invoicedetailitemprice
	 * @param clientId
	 *            the client id
	 * @param itemId
	 *            the item id
	 * @param invoicenote
	 *            the invoicenote
	 * @param invoiceprice
	 *            the invoiceprice
	 * @param session
	 *            HttpSession
	 * @param model
	 *            the model
	 * @return the success massage
	 */
	@RequestMapping(value = "/insertinvoice.html", method = RequestMethod.POST)
	public String addinvoice(
			@RequestParam("invoicedetailquantity") String[] invoicedetailquantity,
			@RequestParam("invoiceduedate") String invoiceduedate,
			@RequestParam("invoicedetailamount") String[] invoicedetailamount,
			@RequestParam("invoicetax") String invoicetax,
			@RequestParam("invoicedetailitemprice") String[] invoicedetailitemprice,
			@RequestParam("clientList") String clientId,
			@RequestParam("itemList") String[] itemId,
			@RequestParam("invoicenote") String invoicenote,
			@RequestParam("invoiceprice") String invoiceprice,
			HttpSession session, ModelMap model) {

		try {

			Invoice invoice = new Invoice();
			List<InvoiceDetail> list = new ArrayList<InvoiceDetail>();

			Client client = new Client();
			client.setClientid(Integer.parseInt(clientId));
			Client c1 = clientService.getClientByClientId(client.getClientid());
			User user = (User) session.getAttribute(USER);

			Tenant t = user.getTenant();

			invoice.setTenant(t);
			invoice.setUser(user);
			invoice.setInvoicenote(invoicenote);
			invoice.setInvoicetax(Double.valueOf(invoicetax));
			invoice.setInvoiceprice(Double.valueOf(invoiceprice));
			invoice.setInvoicestatus("unpaid");
			invoice.setClient(c1);

			Date dateCreated = new java.sql.Date(new java.util.Date().getTime());

			invoice.setInvoiceissuedate(dateCreated);

			String dateString = invoiceduedate;

			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date convertedDate = null;
			try {
				convertedDate = dateFormat.parse(dateString);
			} catch (ParseException e2) {

			}
			invoice.setInvoiceduedate(convertedDate);
			try {
				invoice.setInvoiceduedate(dateFormat.parse(invoiceduedate));
			} catch (ParseException e) {

			}

			invoiceService.add(invoice);

			int length = itemId.length;
			InvoiceDetail invoiceItem = new InvoiceDetail();
			Item item = null;
			long invId = invoiceService.getInvoiceByMaxInvoiceId();
			Invoice inv = new Invoice();
			inv.setInvoiceid((int) invId);

			for (int i = 0; i < length; i++) {
				item = new Item();

				item = (Item) itemService.getItemByItemId(Integer
						.valueOf(itemId[i]));

				invoiceItem = new InvoiceDetail();
				invoiceItem.setInvoice(inv);

				invoiceItem.setItem(item);
				invoiceItem.setInvoicedetailquantity(Integer
						.valueOf(invoicedetailquantity[i]));
				invoiceItem.setInvoicedetailitemprice(Double
						.valueOf(invoicedetailitemprice[i]));

				invoiceItem.setInvoicedetailamount(Double
						.valueOf(invoicedetailamount[i]));
				list.add(invoiceItem);
				invoiceDetailService.add(invoiceItem);
			}

			model.addAttribute("ClientName", invoice.getClient()
					.getClientfname());

			MailInvoice mail = new MailInvoice();
			mail.invoiceEmail(invoice, list);
			logger.info("inserting a invoice by the user");

			return "invoiceinserted";
		} catch (Exception e) {
			throw new GenericException(e.getMessage());

		}
	}

	/**
	 * Show dashboard.
	 * 
	 * @return the dashboard jsp
	 */
	@RequestMapping(value = "/dashboard.html")
	public String showdashboard() {
		logger.info("returning a jsp page");

		return "dashboard";
	}

	/**
	 * Invoiceduelist.
	 * 
	 * @param model
	 *            the model
	 * @param session
	 *            HttpSession
	 * @return the invoicelist
	 */
	@RequestMapping(value = "/dashDueInv.html", method = RequestMethod.GET)
	@ResponseBody
	List<Invoice> invoiceduelist(Model model, HttpSession session) {

		try {

			User user = (User) session.getAttribute(USER);
			Tenant tenant = user.getTenant();
			int tenantId = tenant.getTenantid();
			List<Invoice> invoiceList = invoiceService
					.getDueAllnvoices(tenantId);

			for (Invoice i : invoiceList) {
				java.sql.Date d1 = new java.sql.Date(i.getInvoiceduedate()
						.getTime());
				i.setInvoiceduedate(d1);

				java.sql.Date d2 = new java.sql.Date(i.getInvoiceissuedate()
						.getTime());
				i.setInvoiceissuedate(d2);
			}
			logger.info("showing info of due invoices in a div");

			return invoiceList;
		} catch (Exception e) {
			throw new GenericException(e.getMessage());

		}
	}

	/**
	 * Invoicelatestlist.
	 * 
	 * @param model
	 *            the model
	 * @param session
	 *            HttpSession
	 * @return the invoicelist
	 */
	@RequestMapping(value = "/dashDueInv1.html", method = RequestMethod.GET)
	@ResponseBody
	List<Invoice> invoicelatestlist(Model model, HttpSession session) {

		try {

			User user = (User) session.getAttribute(USER);
			Tenant tenant = user.getTenant();
			int tenantId = tenant.getTenantid();
			List<Invoice> invoiceList = invoiceService
					.getlatestAllnvoices(tenantId);

			for (Invoice i : invoiceList) {
				java.sql.Date d1 = new java.sql.Date(i.getInvoiceduedate()
						.getTime());
				i.setInvoiceduedate(d1);

				java.sql.Date d2 = new java.sql.Date(i.getInvoiceissuedate()
						.getTime());
				i.setInvoiceissuedate(d2);
			}
			logger.info("showing info of latest invoices in a div");
			return invoiceList;
		} catch (Exception e) {
			throw new GenericException(e.getMessage());

		}
	}

	/* view list of invoices */

	/**
	 * Invoicelist.
	 * 
	 * @param session
	 *            HttpSession
	 * @param model
	 *            Model
	 * @return the showinvoices jsp
	 */
	@RequestMapping(value = "/invoicelist.html", method = RequestMethod.GET)
	public String invoicelist(HttpSession session, Model model) {

		try {
			User user = (User) session.getAttribute(USER);
			Integer tenantid = user.getTenant().getTenantid();
			List<Invoice> invoicelist = invoiceService.getAllInvoices(tenantid);
			for (Invoice i : invoicelist) {
				java.sql.Date d1 = new java.sql.Date(i.getInvoiceduedate()
						.getTime());
				i.setInvoiceduedate(d1);

				java.sql.Date d2 = new java.sql.Date(i.getInvoiceissuedate()
						.getTime());
				i.setInvoiceissuedate(d2);
			}

			model.addAttribute("invoicelist", invoicelist);
			logger.info("showing invoices list as per the tenant");
			return "showinvoices";
		} catch (Exception e) {
			throw new GenericException(e.getMessage());

		}
	}

	/**
	 * Searchinvoice.
	 * 
	 * @param session
	 *            the session
	 * @param model
	 *            the model
	 * @return the searchinvoice jsp
	 */
	@RequestMapping(value = "/searchinvoice.html", method = RequestMethod.GET)
	public String searchinvoice(HttpSession session, ModelMap model) {

		try {
			User user = (User) session.getAttribute(USER);
			Integer tenantid = user.getTenant().getTenantid();
			List<Client> clientlist = clientService.getAllClients(tenantid);

			model.addAttribute(CLIENTLIST, clientlist);
			logger.info("returning a jsp page");

			return "searchinvoice";
		} catch (Exception e) {
			throw new GenericException(e.getMessage());

		}
	}

	/**
	 * Searchinvoicelist.
	 * 
	 * @param searchby
	 *            the searchby
	 * @param param
	 *            the param
	 * @param session
	 *            HttpSession
	 * @param model
	 *            the model
	 * @return the searchinvoice jsp
	 * @RequestParam
	 */
	@RequestMapping(value = "/searchinvoice1.html", method = RequestMethod.POST)
	public String searchinvoicelist(@RequestParam("searchby") String searchby,
			@RequestParam("param") String param, HttpSession session,
			Model model) {

		try {
			User user = (User) session.getAttribute(USER);
			Integer tenantid = user.getTenant().getTenantid();
			List<Invoice> invoicelist = invoiceService.getSearchAllInvoices(
					tenantid, searchby, param);
			for (Invoice i : invoicelist) {
				java.sql.Date d1 = new java.sql.Date(i.getInvoiceduedate()
						.getTime());
				i.setInvoiceduedate(d1);

				java.sql.Date d2 = new java.sql.Date(i.getInvoiceissuedate()
						.getTime());
				i.setInvoiceissuedate(d2);
			}

			model.addAttribute("invoicelist", invoicelist);
			logger.info("searching a invoice acoording to id and client name");
			return "searchinvoice";
		} catch (Exception e) {
			throw new GenericException(e.getMessage());

		}
	}

	/* for graph */
	/* daily */

	/**
	 * Show daily graph.
	 * 
	 * @param res
	 *            the res
	 * @param session
	 *            the session
	 * @return the http servlet response
	 */
	@RequestMapping(value = "/dashDueInv2.html", method = RequestMethod.GET)
	@ResponseBody
	public HttpServletResponse showDailyGraph(HttpServletResponse res,
			HttpSession session) {
		final int sixtwofive = 625, fivezerozero = 500;

		List<Double> list = invoiceService.getChartValues("Day",
				((User) session.getAttribute(USER)).getTenant().getTenantid());

		try {
			OutputStream out = res.getOutputStream();
			CreateGraph chart = new CreateGraph();

			ChartUtilities.writeChartAsPNG(out, chart.getChartImg("Day", list),
					sixtwofive, fivezerozero);
		} catch (IOException e) {

		}
		res.setContentType("image/png");

		return res;
	}

	/* weekly */

	/**
	 * Show weekly graph.
	 * 
	 * @param res
	 *            the res
	 * @param session
	 *            the session
	 * @return the http servlet response
	 */
	@RequestMapping(value = "/dashDueInv2weekly.html", method = RequestMethod.GET)
	@ResponseBody
	public HttpServletResponse showWeeklyGraph(HttpServletResponse res,
			HttpSession session) {
		final int sixtwofive = 625, fivezerozero = 500;

		List<Double> list = invoiceService.getChartValues("Week",
				((User) session.getAttribute(USER)).getTenant().getTenantid());

		try {
			OutputStream out = res.getOutputStream();
			CreateGraph chart = new CreateGraph();

			ChartUtilities.writeChartAsPNG(out,
					chart.getChartImg("Week", list), sixtwofive, fivezerozero);
		} catch (IOException e) {

		}
		res.setContentType("image/png");

		return res;
	}

	/* yearly */

	/**
	 * Show monthly graph.
	 * 
	 * @param res
	 *            the res
	 * @param session
	 *            the session
	 * @return the http servlet response
	 */
	@RequestMapping(value = "/dashDueInv2monthly.html", method = RequestMethod.GET)
	@ResponseBody
	public HttpServletResponse showMonthlyGraph(HttpServletResponse res,
			HttpSession session) {
		final int sixtwofive = 625, fivezerozero = 500;

		List<Double> list = invoiceService.getChartValues("Month",
				((User) session.getAttribute(USER)).getTenant().getTenantid());

		try {
			OutputStream out = res.getOutputStream();
			CreateGraph chart = new CreateGraph();

			ChartUtilities.writeChartAsPNG(out,
					chart.getChartImg("Month", list), sixtwofive, fivezerozero);
		} catch (IOException e) {

		}
		res.setContentType("image/png");

		return res;
	}

	/**
	 * Unpaidinvoicelist.
	 * 
	 * @param session
	 *            the session
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/unpaidinvoicelist.html", method = RequestMethod.GET)
	public String unpaidinvoicelist(HttpSession session, Model model) {

		try {
			User user = (User) session.getAttribute(USER);
			Integer tenantid = user.getTenant().getTenantid();
			List<Invoice> invoicelist = invoiceService
					.getUnpaidInvoices(tenantid);
			for (Invoice i : invoicelist) {
				java.sql.Date d1 = new java.sql.Date(i.getInvoiceduedate()
						.getTime());
				i.setInvoiceduedate(d1);

				java.sql.Date d2 = new java.sql.Date(i.getInvoiceissuedate()
						.getTime());
				i.setInvoiceissuedate(d2);
			}

			model.addAttribute("invoicelist", invoicelist);
			logger.info("showing invoices list as per the tenant");
			return "showunpaidinvoices";
		} catch (Exception e) {
			throw new GenericException(e.getMessage());

		}
	}

	/**
	 * Edititem.
	 * 
	 * @param invoiceid
	 *            the invoiceid
	 * @param session
	 *            the session
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/editstatus.html", method = RequestMethod.GET)
	public String edititem(@RequestParam("invoiceId") int invoiceid,
			HttpSession session, Model model) {
		try {

			User user = (User) session.getAttribute("user");
			int tenantid = user.getTenant().getTenantid();
			Invoice invoice = invoiceService.getInvoiceByInvoiceId(invoiceid,
					tenantid);

			invoice.setInvoicestatus("paid");
			invoiceService.edit(invoice);
			new ThankyouMail().thanksEmail(invoice);
			logger.info("update a item info");

			return "redirect:/unpaidinvoicelist.html";
		} catch (Exception e) {
			throw new GenericException(e.getMessage());

		}

	}

}
