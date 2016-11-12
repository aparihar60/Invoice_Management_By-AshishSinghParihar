/**
 * 
 */
package com.impetus.invc_mgmt.dao;

import java.util.List;

import com.impetus.invc_mgmt.model.Item;

// TODO: Auto-generated Javadoc
/**
 * The Interface ItemDao consist the methods related to items.
 * 
 * @author Ashish
 */
public interface ItemDao {

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
	 * Gets the all item.
	 * 
	 * @param tenantid
	 *            the tenantid
	 * @return the all item
	 */
	List<Item> getAllItem(Integer tenantid);

	/**
	 * Gets the item by item id.
	 * 
	 * @param itemid
	 *            the itemid
	 * @return the item by item id
	 */
	Item getItemByItemId(int itemid);

}
