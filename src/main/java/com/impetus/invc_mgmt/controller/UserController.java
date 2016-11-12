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

import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.exception.UserInsertException;
import com.impetus.invc_mgmt.model.Role;
import com.impetus.invc_mgmt.model.Tenant;
import com.impetus.invc_mgmt.model.User;
import com.impetus.invc_mgmt.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserController takes the request from the browser and give a proper
 * response as per the request related to user.
 */
@Controller
public class UserController {

	/** The logger. */
	private static Logger logger = Logger.getLogger(UserController.class);

	/** The user service. */
	@Autowired
	private UserService userService;

	/** The Constant USER. */
	private static final String USER = "user";

	/** The Constant TENANT. */
	private static final String TENANT = "tenant";

	/** The Constant USERLIST. */
	private static final String USERLIST = "userList";
	
	private static final String ERROR = "ERROR!";

	/**
	 * Adds the user.
	 * 
	 * @param user
	 *            the user
	 * @param session
	 *            the session
	 * @param model
	 *            the model
	 * @return the WelcomeUser jsp
	 */
	@RequestMapping(value = "/userregistration.html", method = RequestMethod.POST)
	public String addUser(@ModelAttribute(USER) User user, HttpSession session,
			Model model) {
		try {
			Tenant tenant = ((Tenant) session.getAttribute(TENANT));
			user.setTenant(tenant);
			Role role = new Role();
			role.setRoleid(1);
			role.setRolename("SuperAdmin");
			user.setRole(role);
			
			
			try {
				userService.add(user);
			} catch (UserInsertException e) {
			
				model.addAttribute("userInserException", e.getMessage());
				return "userregistration";
				
			}
			
			
			model.addAttribute(USER, user);
			logger.info("registration of new user");

			return "WelcomeUser";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}
	}

	/**
	 * Show form.
	 * 
	 * @return the userregistration jsp
	 */
	@RequestMapping(value = "/adduser.html", method = RequestMethod.GET)
	public String showForm() {
		logger.info("adding a new user by the tenant");

		return "userregistration";
	}

	/**
	 * Simple.
	 * 
	 * @param user
	 *            the user
	 * @param session
	 *            HttpSession
	 * @param model
	 *            Model
	 * @param roleid
	 *            the roleid
	 * @return the userregistrationsuccessfully jsp
	 */
	@RequestMapping(value = "/adduserdetail.html", method = RequestMethod.POST)
	public String adduser(@ModelAttribute(USER) User user, HttpSession session,
			Model model, @RequestParam("roleid") int roleid) {

		try {

			Tenant tenant = ((Tenant) session.getAttribute(TENANT));
			user.setTenant(tenant);
			user.getTenant().getTenantid();
			Role role = new Role();
			role.setRoleid(roleid);
			user.setRole(role);

			userService.add(user);
			model.addAttribute(TENANT, user);
			logger.info("showing a registration page of user");

			return "userregistrationsuccessfully";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}

	/**
	 * Logout form.
	 * 
	 * @param session
	 *            HttpSession
	 * @return the index jsp
	 */
	@RequestMapping(value = "/logout.html", method = RequestMethod.GET)
	public String logoutForm(HttpSession session) {

		try {

			session.invalidate();
			logger.info("invalidate the current session");

			return "index";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}
	}

	/**
	 * Close.
	 * 
	 * @return the string
	 */
	@RequestMapping(value = "/close.html", method = RequestMethod.GET)
	public String close() {

		return "index";
	}

	/**
	 * Upload file.
	 * 
	 * @return the fileupload jsp
	 */
	@RequestMapping(value = "/uploadclient.html", method = RequestMethod.GET)
	public String uploadFile() {
		logger.info("upload a client list in a excel format");

		return "fileupload";
	}

	/**
	 * Show user manager page.
	 * 
	 * @param model
	 *            the model
	 * @param session
	 *            HttpSession
	 * @return the shownormalusers jsp
	 */
	@RequestMapping("/normaluser.html")
	public String showUserManagerPage(ModelMap model, HttpSession session) {

		try {
			User currentUser = (User) session.getAttribute(USER);
			Tenant tenant = currentUser.getTenant();
			int tenantId = tenant.getTenantid();
			List<User> tenantUserList = userService
					.listUsersByTenantId(tenantId);

			model.addAttribute(USERLIST, tenantUserList);
			logger.info("normal user list of a specific tenant");
			return "shownormalusers";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}
	}

	/**
	 * Edititem.
	 * 
	 * @param userid
	 *            the userid
	 * @param session
	 *            HttpSession
	 * @param model
	 *            Model
	 * @return the editnormaluser jsp
	 */
	@RequestMapping(value = "/edituser.html", method = RequestMethod.GET)
	public String edituser(@RequestParam("userId") int userid,
			HttpSession session, Model model) {

		try {

			User user = userService.getUserByUserId(userid);

			model.addAttribute(USER, user);
			logger.info("update the user information");

			return "editnormaluser";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}

	/**
	 * Update profile.
	 * 
	 * @param session
	 *            the session
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/updateprofile.html", method = RequestMethod.GET)
	public String updateProfile(HttpSession session, Model model) {

		try {
			User user1 = (User) session.getAttribute(USER);
			Integer userid = user1.getUserid();
			User user = userService.getUserByUserId(userid);

			model.addAttribute(USER, user);
			logger.info("update the user information");

			return "editadmin";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}

	/**
	 * Editcurrentuserprofile.
	 * 
	 * @param user
	 *            the user
	 * @param session
	 *            the session
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/editprofile.html", method = RequestMethod.POST)
	public String editcurrentuserprofile(@ModelAttribute(USER) User user,
			HttpSession session, Model model) {

		try {

			userService.edit(user);
			User user1 = (User) session.getAttribute(USER);
			Integer tenantid = user1.getTenant().getTenantid();
			List<User> userList = userService.listUsersByTenantId(tenantid);
			model.addAttribute(USERLIST, userList);
			logger.info("update the current user information of a specific tenant");
			return "header";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}

	/**
	 * Editcurrentitem.
	 * 
	 * @param user
	 *            the user
	 * @param session
	 *            the session
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/editcurrentuser.html", method = RequestMethod.POST)
	public String editcurrentuser(@ModelAttribute(USER) User user,
			HttpSession session, Model model) {

		try {

			userService.edit(user);
			User user1 = (User) session.getAttribute(USER);
			Integer tenantid = user1.getTenant().getTenantid();
			List<User> userList = userService.listUsersByTenantId(tenantid);
			model.addAttribute(USERLIST, userList);
			logger.info("update the current user information of a specific tenant");
			return "shownormalusers";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}

	/**
	 * Deleteuser.
	 * 
	 * @param userid
	 *            the userid
	 * @param session
	 *            HttpSession
	 * @param model
	 *            Model
	 * @return the shownormalusers
	 */
	@RequestMapping(value = "/deleteuser.html", method = RequestMethod.GET)
	public String deleteuser(@RequestParam("userId") int userid,
			HttpSession session, Model model) {
		try {
			User user = new User();
			user.setUserid(userid);
			userService.delete(user);
			User user1 = (User) session.getAttribute(USER);
			Integer tenantid = user1.getTenant().getTenantid();
			List<User> userList = userService.listUsersByTenantId(tenantid);
			model.addAttribute(USERLIST, userList);
			logger.info("delete the normal user");

			return "shownormalusers";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}

	/**
	 * Show normal user form.
	 * 
	 * @return the addnormaluserbyadmin jsp
	 */
	@RequestMapping(value = "/addnormaluser.html", method = RequestMethod.GET)
	public String showNormalUserForm() {
		logger.info("add the normal user");

		return "addnormaluserbyadmin";
	}

	/**
	 * Normal user by admin.
	 * 
	 * @param user
	 *            the user
	 * @param session
	 *            HttpSession
	 * @param model
	 *            Model
	 * @param roleid
	 *            the roleid
	 * @return the normaluser jsp
	 */
	@RequestMapping(value = "/addnormaluserdetail.html", method = RequestMethod.POST)
	public String normaluserbyadmin(@ModelAttribute(USER) User user,
			HttpSession session, Model model, @RequestParam("roleid") int roleid) {
		try {

			Tenant tenant = ((Tenant) session.getAttribute(TENANT));
			user.setTenant(tenant);

			Role role = new Role();
			role.setRoleid(roleid);
			user.setRole(role);

			userService.add(user);
			model.addAttribute(TENANT, user);
			logger.info("add normal user as per the role by the tenant");

			return "redirect:/normaluser.html";
		} catch (Exception e) {
			throw new GenericException(ERROR);

		}

	}

}
