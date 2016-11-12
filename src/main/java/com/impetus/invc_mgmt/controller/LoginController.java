package com.impetus.invc_mgmt.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.User;
import com.impetus.invc_mgmt.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController takes the request from the browser and give a
 * proper response as per the request related to login condition.
 */
@Controller
public class LoginController {

	/** The Constant THREE. */
	private static final int THREE = 3;

	/** The logger. */
	private static Logger logger = Logger.getLogger(LoginController.class);

	/** The user service. */
	@Autowired
	private UserService userService;

	/**
	 * Simple.
	 * 
	 * @param user
	 *            the user
	 * @param session
	 *            HttpSession
	 * @param model
	 *            ModelMap
	 * @return the index,dashboard,normaluserhome,usertypeselect jsp as per the
	 *         credencials
	 */
	@RequestMapping(value = "/userlogin.html", method = RequestMethod.POST)
	public String simple(@ModelAttribute("User") User user,
			HttpSession session, ModelMap model) {

		try {

			logger.info("Login Controller- Received request to redirect On Login page");

			String logid = user.getUserloginid();
			String pass = user.getUserpassword();

			User user1 = userService.authenticateUser(logid, pass);

			if (user1 == null) {
				return "index";
			}

			else {

				session.setAttribute("user", user1);
				session.setAttribute("tenant", user1.getTenant());
				if (user1.getRole().getRoleid() == 2) {

					return "dashboard";
				} else if (user1.getRole().getRoleid() == THREE) {
					return "dashboard";

				} else {
					return "usertypeselect";
				}

			}
		} catch (Exception e) {
			throw new GenericException("ERROR!");

		}

	}
}
