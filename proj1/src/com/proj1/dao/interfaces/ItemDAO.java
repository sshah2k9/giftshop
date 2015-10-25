package com.proj1.dao.interfaces;

import java.util.List;

import com.proj1.dao.exceptions.DAOException;
import com.proj1.model.Item;

/**
 * This interface represents a contract for a DAO for the {@link Item} model.
 * Note that all methods which returns the {@link Item} from the DB, will not
 * fill the model with the password, due to security reasons.
 *
 */
public interface ItemDAO {

    // Actions ------------------------------------------------------------------------------------

    /**
     * Returns the Item from the database matching the given ID, otherwise null.
     * @param id The ID of the Item to be returned.
     * @return The Item from the database matching the given ID, otherwise null.
     * @throws DAOException If something fails at database level.
     */
    public Item find(Long id) throws DAOException;
    
    /**
     * Returns the Item from the database matching the given Category ID, otherwise null.
     * @param categoryId The Category ID of the Item to be returned.
     * @return The Item from the database matching the given Category ID, otherwise null.
     * @throws DAOException If something fails at database level.
     */
	public List<Item> findByCategory(int categoryId) throws DAOException;
    
    /**
     * Returns a list of all Items from the database ordered by Item ID. The list is never null and
     * is empty when the database does not contain any Item.
     * @return A list of all Items from the database ordered by Item ID.
     * @throws DAOException If something fails at database level.
     */
    public List<Item> list() throws DAOException;

    /**
     * Create the given Item in the database. The Item ID must be null, otherwise it will throw
     * IllegalArgumentException. After creating, the DAO will set the obtained ID in the given Item.
     * @param Item The Item to be created in the database.
     * @throws IllegalArgumentException If the Item ID is not null.
     * @throws DAOException If something fails at database level.
     */
    public void create(Item item) throws IllegalArgumentException, DAOException;

    /**
     * Update the given Item in the database. The Item ID must not be null, otherwise it will throw
     * IllegalArgumentException. Note: the password will NOT be updated. Use changePassword() instead.
     * @param Item The Item to be updated in the database.
     * @throws IllegalArgumentException If the Item ID is null.
     * @throws DAOException If something fails at database level.
     */
    public void update(Item item) throws IllegalArgumentException, DAOException;

    /**
     * Delete the given Item from the database. After deleting, the DAO will set the ID of the given
     * Item to null.
     * @param Item The Item to be deleted from the database.
     * @throws DAOException If something fails at database level.
     */
    public void delete(Item item) throws DAOException;

}
