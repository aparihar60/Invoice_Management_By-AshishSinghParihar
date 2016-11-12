package com.impetus.invc_mgmt.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impetus.invc_mgmt.dao.ItemDao;
import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.Item;

// TODO: Auto-generated Javadoc

/**
 * The Class ItemDaoImpl implements the interface ItemDao and interacts with DB.
 */
@Repository
public class ItemDaoImpl implements ItemDao {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final String ERROR = "ERROR!";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.ItemDao#add(com.impetus.invc_mgmt.model.Item)
	 */
	@Override
	public void add(Item item) {
		try {
			sessionFactory.getCurrentSession().save(item);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.ItemDao#edit(com.impetus.invc_mgmt.model.Item)
	 */
	@Override
	public void edit(Item item) {
		try {
			sessionFactory.getCurrentSession().update(item);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.dao.ItemDao#delete(com.impetus.invc_mgmt.model.
	 * Item)
	 */
	@Override
	public void delete(Item item) {
		try {
			sessionFactory.getCurrentSession().delete(item);
		}catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.dao.ItemDao#getAllItem(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getAllItem(Integer tenantid) {
		try {
			return sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Item item where tenantid=:tenantid order by item.itemname asc")
					.setInteger("tenantid", tenantid).list();
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.dao.ItemDao#getItemByItemId(int)
	 */
	@Override
	public Item getItemByItemId(int itemid) {

		try {
			Item item = (Item) sessionFactory.getCurrentSession().get(Item.class,
					itemid);

			return item;
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

}
