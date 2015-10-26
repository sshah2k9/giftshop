package com.proj1.dao;

import java.util.List;

import com.proj1.dao.exceptions.DAOException;
import com.proj1.dao.interfaces.OrderDAO;
import com.proj1.model.Order;

public class OrderDAOJDBC implements OrderDAO {

	// Constants
	// ----------------------------------------------------------------------------------

	private static final String SQL_FIND_BY_ID = "SELECT item_code, item_name, item_desc, price, category_id, file_name FROM ITEM WHERE item_code = ?";
	private static final String SQL_FIND_BY_SENDER_ID = "SELECT item_code, item_name, item_desc, price, category_id, file_name FROM ITEM WHERE category_id = ?";
	private static final String SQL_FIND_BY_DELIVERY_ID = "SELECT item_code, item_name, item_desc, price, category_id, file_name FROM ITEM ORDER BY item_code";
	private static final String SQL_LIST_ORDER_BY_ORDER_ID = "SELECT item_code, item_name, item_desc, price, category_id, file_name FROM ITEM ORDER BY item_code";
	private static final String SQL_INSERT = "INSERT INTO ITEM (item_name, item_desc, price, category_id, file_name) VALUES (?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE ITEM SET item_name = ?, item_desc = ?, price = ?, category_id = ?, file_name = ? WHERE item_code = ?";
	private static final String SQL_DELETE = "DELETE FROM ITEM WHERE item_code = ?";
	
	// Vars
	// ---------------------------------------------------------------------------------------

	private DAOFactory daoFactory;
	
	@Override
	public Order find(Long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findBySender(Long senderId) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findByDeliveryId(Long deliveryId) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> list() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Order Order) throws IllegalArgumentException, DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Order Order) throws IllegalArgumentException, DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Order Order) throws DAOException {
		// TODO Auto-generated method stub

	}

}
