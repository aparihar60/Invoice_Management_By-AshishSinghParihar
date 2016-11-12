package com.impetus.invc_mgmt.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impetus.invc_mgmt.dao.UserDao;
import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.exception.UserInsertException;
import com.impetus.invc_mgmt.model.User;

// TODO: Auto-generated Javadoc

/**
 * The Class UserDaoImpl implements the interface UserDao and interacts with DB.
 */
@Repository
public class UserDaoImpl implements UserDao {

	/** The Constant THREE. */
	private static final int THREE = 3;

	/** The session. */
	@Autowired
	private SessionFactory session;
	
	private static final String ERROR = "ERROR!";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.UserDao#add(com.impetus.invc_mgmt.model.User)
	 */
	@Override
	public void add(User user) throws UserInsertException {
try{
		session.getCurrentSession().save(user);
		// TODO Auto-generated method stub
}
catch(HibernateException e)
{
	throw new UserInsertException(" Login Id already exists ",e); 
	}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.UserDao#edit(com.impetus.invc_mgmt.model.User)
	 */
	@Override
	public void edit(User user) {
		// TODO Auto-generated method stub
		try {
			session.getCurrentSession().update(user);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.UserDao#delete(com.impetus.invc_mgmt.model.
	 * User)
	 */
	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		try {
			session.getCurrentSession().delete(user);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.dao.UserDao#authenticateUser(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public User authenticateUser(String logid, String pass) {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("unchecked")
			List<User> list = session
					.getCurrentSession()
					.createQuery(
							"from User where userloginid=:logid and userpassword=:pass")
					.setString("logid", logid).setString("pass", pass).list();

			if (list.size() > 0) {

				return list.get(0);
			} else {
				return null;
			}
		}catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.dao.UserDao#listUsersByTenantId(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsersByTenantId(int tenantId) {
		Query query = session
				.getCurrentSession()
				.createQuery(
						"from User as user where user.tenant.tenantid= :tid and user.role.roleid = :rid order by user.userfname asc ");
		query.setInteger("tid", tenantId);
		query.setInteger("rid", THREE);
		return query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.dao.UserDao#getUserByUserId(int)
	 */
	@Override
	public User getUserByUserId(int userid) {
		// TODO Auto-generated method stub
		try {
			return (User) session.getCurrentSession().get(User.class, userid);
		}catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

}
