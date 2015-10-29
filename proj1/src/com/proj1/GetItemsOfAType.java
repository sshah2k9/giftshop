package com.proj1;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.proj1.dao.DAOFactory;
import com.proj1.dao.interfaces.ItemDAO;
import com.proj1.model.Item;

/**
 * Servlet implementation class GetItemsOfAType
 */
@WebServlet("/GetItemsOfAType")
public class GetItemsOfAType extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetItemsOfAType() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String itemType = request.getParameter("itemType");
		if (itemType == null) {
			response.getWriter().append("Invalid item type");
			return;
		}
		int categoryId = 0;
		try {
			categoryId = Integer.parseInt(itemType);
		} catch (Exception ex) {
			response.getWriter().append("Invalid item type");
			return;
		}
		
		DAOFactory javabase = DAOFactory.getInstance("javabase.jndi");
		ItemDAO itemDAO = javabase.getItemDAO();
		List<Item> items = itemDAO.findByCategory(categoryId);
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(items);
		System.out.println("json === "+json);
		
		for (Item item : items) {
			System.out.println("Item: " + item);
		}
		// store data in session
		HttpSession session = request.getSession();
		session.setAttribute("itemList", items);

		// forward the request (not redirect)
		RequestDispatcher dispatcher = request.getRequestDispatcher("ShowItems.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
