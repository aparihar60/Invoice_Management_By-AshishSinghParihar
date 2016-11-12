package com.impetus.invc_mgmt.service;

import java.util.List;

import com.impetus.invc_mgmt.model.Item;

// TODO: Auto-generated Javadoc
/**
 * The Interface ItemService consist the methods related to items.
 */
public interface ItemService {

	/**
	 * Adds the.
	 * 
	 * @param item
	 *            the item
	 */
	void add(Item item);

	/**
	 * Edits the.
	 * 
	 * @param item
	 *            the item
	 */
	void edit(Item item);

	/**
	 * Delete.
	 * 
	 * @param item
	 *            the item
	 */
	void delete(Item item);

	/**
	 * Gets the all items.
	 * 
	 * @param tenantid
	 *            the tenantid
	 * @return the all items
	 */
	List<Item> getAllItems(Integer tenantid);

	/**
	 * Gets the item by item id.
	 * 
	 * @param itemid
	 *            the itemid
	 * @return the item by item id
	 */
	Item getItemByItemId(int itemid);

}
