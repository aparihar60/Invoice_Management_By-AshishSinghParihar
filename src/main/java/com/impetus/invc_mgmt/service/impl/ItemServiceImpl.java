package com.impetus.invc_mgmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.invc_mgmt.dao.ItemDao;
import com.impetus.invc_mgmt.exception.GenericException;
import com.impetus.invc_mgmt.model.Item;
import com.impetus.invc_mgmt.service.ItemService;

// TODO: Auto-generated Javadoc

/**
 * The Class ItemServiceImpl implements the interface ItemService and interacts
 * with ItemDao.
 */
@Service
public class ItemServiceImpl implements ItemService {

	/** The itemdao. */
	@Autowired
	private ItemDao itemdao;

	
	private static final String ERROR = "ERROR!";
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.ItemService#add(com.impetus.invc_mgmt.model
	 * .Item)
	 */
	@Transactional
	public void add(Item item) {
		// TODO Auto-generated method stub
		try {
			itemdao.add(item);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.ItemService#edit(com.impetus.invc_mgmt.
	 * model.Item)
	 */
	@Transactional
	public void edit(Item item) {
		// TODO Auto-generated method stub
		try {
			itemdao.edit(item);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.ItemService#delete(com.impetus.invc_mgmt
	 * .model.Item)
	 */
	@Transactional
	public void delete(Item item) {
		// TODO Auto-generated method stub
		try {
			itemdao.delete(item);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.impetus.invc_mgmt.service.ItemService#getAllItems(java.lang.Integer)
	 */
	@Transactional
	public List<Item> getAllItems(Integer tenantid) {
		try {
			return itemdao.getAllItem(tenantid);
		}  catch (Exception e) {
			throw new GenericException(ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impetus.invc_mgmt.service.ItemService#getItemByItemId(int)
	 */
	@Transactional
	public Item getItemByItemId(int itemid) {
		try {
			return itemdao.getItemByItemId(itemid);
		} catch (Exception e) {
			throw new GenericException(ERROR);
		}
	}

}
