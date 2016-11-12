package com.impetus.invc_mgmt.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.impetus.invc_mgmt.bean.ItemBean;
import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.Item;
import com.impetus.invc_mgmt.model.Tenant;
import com.impetus.invc_mgmt.model.User;
import com.impetus.invc_mgmt.service.ItemService;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemController takes the request from the browser and give a proper
 * response as per the request related to items.
 */

@Controller
public class ItemController {

	/** The logger. */
	private static Logger logger = Logger.getLogger(ItemController.class);

	/** The item service. */
	@Autowired
	private ItemService itemService;

	/** The Constant USER. */
	private static final String USER = "user";

	/** The Constant ITEMLIST. */
	private static final String ITEMLIST = "itemlist";
	
	private static final String ERROR = "ERROR!";

	/**
	 * Item.
	 * 
	 * @param session
	 *            HttpSession
	 * @param model
	 *            Model
	 * @return the showitem jsp
	 */
	@RequestMapping(value = "/item.html", method = RequestMethod.GET)
	public String item(HttpSession session, Model model) {

		try {
			User user = (User) session.getAttribute(USER);
			Integer tenantid = user.getTenant().getTenantid();
			List<Item> itemlist = itemService.getAllItems(tenantid);

			model.addAttribute(ITEMLIST, itemlist);
			logger.info("showing item list");
			return "showitem";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}
	}

	/**
	 * Additem.
	 * 
	 * @param model
	 *            Model
	 * @return the additem jsp
	 */
	@RequestMapping(value = "/additem.html", method = RequestMethod.GET)
	public String additem(ModelMap model) {

		model.addAttribute("Item", new ItemBean());
		logger.info("adding a new item");
		return "additem";
	}

	/**
	 * Itemlist.
	 * 
	 * @param session
	 *            HttpSession
	 * @param model
	 *            Model
	 * @return the itemlist jsp
	 */
	@RequestMapping(value = "/itemlist.html", method = RequestMethod.GET)
	public String itemlist(HttpSession session, ModelMap model) {
		try {
			User user = (User) session.getAttribute(USER);
			Integer tenantid = user.getTenant().getTenantid();
			List<Item> itemlist = itemService.getAllItems(tenantid);

			model.addAttribute(ITEMLIST, itemlist);
			logger.info("showing item list as per the tenant");
			return ITEMLIST;
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}
	}

	/**
	 * Simple.
	 * 
	 * @param itemBean
	 *            the item bean
	 * @param session
	 *            HttpSession
	 * @param model
	 *            Model
	 * @return the itemregistered jsp
	 */
	@RequestMapping(value = "/insertitem.html", method = RequestMethod.POST)
	public String additem(@ModelAttribute("Item") ItemBean itemBean,
			HttpSession session, Model model) {
		try {

			Tenant tenant = ((Tenant) session.getAttribute("tenant"));
			Item item = new Item();
			item.setItemname(itemBean.getItemname());
			item.setItemprice(itemBean.getItemprice());
			item.setTenant(tenant);
			itemService.add(item);
			model.addAttribute("item", item);
			logger.info("new item inserted");

			return "itemregistered";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}

	/**
	 * Deleteitem.
	 * 
	 * @param itemid
	 *            the itemid
	 * @param session
	 *            HttpSession
	 * @param model
	 *            Model
	 * @return the showitem jsp
	 */
	@RequestMapping(value = "/deleteitem.html", method = RequestMethod.GET)
	public String deleteitem(@RequestParam("itemId") int itemid,
			HttpSession session, Model model) {

		try {
			Item item = new Item();
			item.setItemid(itemid);
			itemService.delete(item);
			User user = (User) session.getAttribute(USER);
			Integer tenantid = user.getTenant().getTenantid();
			List<Item> itemlist = itemService.getAllItems(tenantid);
			model.addAttribute(ITEMLIST, itemlist);
			logger.info("deleting a item and return a itemlist page");

			return "showitem";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}

	/**
	 * Edititem.
	 * 
	 * @param itemid
	 *            the itemid
	 * @param session
	 *            HttpSession
	 * @param model
	 *            Model
	 * @return the edititem
	 */
	@RequestMapping(value = "/edititem.html", method = RequestMethod.GET)
	public String edititem(@RequestParam("itemId") int itemid,
			HttpSession session, Model model) {

		try {

			Item item = itemService.getItemByItemId(itemid);

			model.addAttribute("item", item);
			logger.info("update a item info");

			return "edititem";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}

	/**
	 * Itemamount.
	 * 
	 * @param itemid
	 *            the itemid
	 * @param session
	 *            HttpSession
	 * @param model
	 *            Model
	 * @return the itemamount jsp
	 */
	@RequestMapping(value = "/itemamount.html", method = RequestMethod.GET)
	public String itemamount(@RequestParam("itemId") int itemid,
			HttpSession session, Model model) {

		try {

			Item item = itemService.getItemByItemId(itemid);

			model.addAttribute("item", item);
			logger.info("amount of item as per the request ");

			return "itemamount";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}

	/**
	 * Editcurrentitem.
	 * 
	 * @param item
	 *            the item
	 * @param session
	 *            HttpSession
	 * @param model
	 *            Model
	 * @return the showitem jsp
	 */
	@RequestMapping(value = "/editcurrentitem.html", method = RequestMethod.POST)
	public String editcurrentitem(@ModelAttribute("Item") Item item,
			HttpSession session, Model model) {

		try {

			itemService.edit(item);
			User user = (User) session.getAttribute(USER);
			Integer tenantid = user.getTenant().getTenantid();
			List<Item> itemlist = itemService.getAllItems(tenantid);
			model.addAttribute(ITEMLIST, itemlist);
			logger.info("edit the current item a sper the tanant");
			return "showitem";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}

}
