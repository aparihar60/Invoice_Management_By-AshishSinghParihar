package com.impetus.invc_mgmt.exception;

import org.hibernate.HibernateException;

public class UserInsertException extends HibernateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 127975367576161603L;

	private Exception hiddenException;
	public UserInsertException(String message, Exception root) {
		super(message);
		hiddenException = root;
	}
	public Exception getHiddenException() {
		return hiddenException;
	}

	
}
