package com.proj1.dao.interfaces;

import java.util.List;

import com.proj1.dao.exceptions.DAOException;
import com.proj1.model.Order;

public interface OrderDAO {

    // Actions ------------------------------------------------------------------------------------

    /**
     * Returns the Order from the database matching the given ID, otherwise null.
     * @param id The ID of the Order to be returned.
     * @return The Order from the database matching the given ID, otherwise null.
     * @throws DAOException If something fails at database level.
     */
    public Order find(Long id) throws DAOException;
    
    /**
     * Returns the Order from the database matching the given Sender ID, otherwise null.
     * @param categoryId The Sender ID of the Order to be returned.
     * @return The Order from the database matching the given Sender ID, otherwise null.
     * @throws DAOException If something fails at database level.
     */
	public List<Order> findBySender(Long senderId) throws DAOException;
	
    /**
     * Returns the Order from the database matching the given Delivery ID, otherwise null.
     * @param categoryId The Delivery ID of the Order to be returned.
     * @return The Order from the database matching the given Delivery ID, otherwise null.
     * @throws DAOException If something fails at database level.
     */
	public List<Order> findByDeliveryId(Long deliveryId) throws DAOException;
    
    /**
     * Returns a list of all Orders from the database ordered by Order ID. The list is never null and
     * is empty when the database does not contain any Order.
     * @return A list of all Orders from the database ordered by Order ID.
     * @throws DAOException If something fails at database level.
     */
    public List<Order> list() throws DAOException;

    /**
     * Create the given Order in the database. The Order ID must be null, otherwise it will throw
     * IllegalArgumentException. After creating, the DAO will set the obtained ID in the given Order.
     * @param Order The Order to be created in the database.
     * @throws IllegalArgumentException If the Order ID is not null.
     * @throws DAOException If something fails at database level.
     */
    public void create(Order Order) throws IllegalArgumentException, DAOException;

    /**
     * Update the given Order in the database. The Order ID must not be null, otherwise it will throw
     * IllegalArgumentException. Note: the password will NOT be updated. Use changePassword() instead.
     * @param Order The Order to be updated in the database.
     * @throws IllegalArgumentException If the Order ID is null.
     * @throws DAOException If something fails at database level.
     */
    public void update(Order Order) throws IllegalArgumentException, DAOException;

    /**
     * Delete the given Order from the database. After deleting, the DAO will set the ID of the given
     * Order to null.
     * @param Order The Order to be deleted from the database.
     * @throws DAOException If something fails at database level.
     */
    public void delete(Order Order) throws DAOException;
}
