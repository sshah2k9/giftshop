package com.proj1.dao;

import static com.proj1.dao.utils.DAOUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proj1.dao.exceptions.DAOException;
import com.proj1.dao.interfaces.ItemDAO;
import com.proj1.model.Item;

/**
 * This class represents a concrete JDBC implementation of the {@link ItemDAO}
 * interface.
 */
public class ItemDAOJDBC implements ItemDAO {

	// Constants
	// ----------------------------------------------------------------------------------

	private static final String SQL_FIND_BY_ID = "SELECT item_code, item_name, item_desc, price, category_id, file_name FROM Item WHERE item_code = ?";
	private static final String SQL_FIND_BY_CATEGORY_ID = "SELECT item_code, item_name, item_desc, price, category_id, file_name FROM Item WHERE category_id = ?";
	private static final String SQL_LIST_ORDER_BY_ITEM_CODE = "SELECT item_code, item_name, item_desc, price, category_id, file_name FROM Item ORDER BY item_code";
	private static final String SQL_INSERT = "INSERT INTO Item (item_name, item_desc, price, category_id, file_name) VALUES (?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE Item SET item_name = ?, item_desc = ?, price = ?, category_id = ?, file_name = ? WHERE item_code = ?";
	private static final String SQL_DELETE = "DELETE FROM Item WHERE item_code = ?";

	// Vars
	// ---------------------------------------------------------------------------------------

	private DAOFactory daoFactory;

	// Constructors
	// -------------------------------------------------------------------------------

	/**
	 * Construct an Item DAO for the given DAOFactory. Package private so that
	 * it can be constructed inside the DAO package only.
	 * 
	 * @param daoFactory
	 *            The DAOFactory to construct this Item DAO for.
	 */
	ItemDAOJDBC(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	// Actions
	// ------------------------------------------------------------------------------------

	@Override
	public Item find(Long id) throws DAOException {
		return find(SQL_FIND_BY_ID, id);
	}

	@Override
	public List<Item> findByCategory(int categoryId) throws DAOException {
		return findMultipleRecords(SQL_FIND_BY_CATEGORY_ID, categoryId);
	}

	private List<Item> findMultipleRecords(String sql, Object... values) throws DAOException {
		List<Item> items = new ArrayList<>();

		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, sql, true, values);
				ResultSet resultSet = statement.executeQuery();) {
			while (resultSet.next()) {
				items.add(map(resultSet));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return items;
	}

	private Item find(String sql, Object... values) throws DAOException {
		Item item = null;

		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, sql, true, values);
				ResultSet resultSet = statement.executeQuery();) {
			if (resultSet.next()) {
				item = map(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return item;
	}

	@Override
	public List<Item> list() throws DAOException {
		List<Item> items = new ArrayList<>();

		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL_LIST_ORDER_BY_ITEM_CODE);
				ResultSet resultSet = statement.executeQuery();) {
			while (resultSet.next()) {
				items.add(map(resultSet));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return items;
	}

	@Override
	public void create(Item item) throws IllegalArgumentException, DAOException {
		if (item.getItemCode() != 0) {
			throw new IllegalArgumentException("Item is already created, the item code is not 0.");
		}

		Object[] values = { item.getItemName(), item.getItemDesc(), item.getPrice(), item.getCategoryId(),
				item.getFileName() };

		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, SQL_INSERT, true, values);) {
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new DAOException("Creating item failed, no rows affected.");
			}

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					item.setItemCode(generatedKeys.getLong(1));
				} else {
					throw new DAOException("Creating item failed, no generated key obtained.");
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void update(Item item) throws DAOException {
		if (item.getItemCode() == 0) {
			throw new IllegalArgumentException("Item is not created yet, the item code is 0.");
		}

		Object[] values = { item.getItemCode(), item.getItemName(), item.getItemDesc(), item.getPrice(),
				item.getCategoryId(), item.getFileName() };

		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, SQL_UPDATE, false, values);) {
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new DAOException("Updating item failed, no rows affected.");
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void delete(Item item) throws DAOException {
		Object[] values = { item.getItemCode() };

		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, SQL_DELETE, false, values);) {
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new DAOException("Deleting item failed, no rows affected.");
			} else {
				item.setItemCode(0);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	// Helpers
	// ------------------------------------------------------------------------------------

	/**
	 * Map the current row of the given ResultSet to an Item.
	 * 
	 * @param resultSet
	 *            The ResultSet of which the current row is to be mapped to an
	 *            Item.
	 * @return The mapped Item from the current row of the given ResultSet.
	 * @throws SQLException
	 *             If something fails at database level.
	 */
	private static Item map(ResultSet resultSet) throws SQLException {
		Item item = new Item();
		item.setItemCode(resultSet.getLong("item_code"));
		item.setItemName(resultSet.getString("item_name"));
		item.setItemDesc(resultSet.getString("item_desc"));
		item.setPrice(resultSet.getFloat("price"));
		item.setCategoryId(resultSet.getInt("category_id"));
		item.setFileName(resultSet.getString("file_name"));
		return item;
	}

}
