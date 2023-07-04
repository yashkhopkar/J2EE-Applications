package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FriendDAO;
import models.M_93_Friend;

@WebServlet("/C_93_AddFriend")
public class C_93_AddFriend extends HttpServlet {

	private FriendDAO friendDAO;

	public void init() {
		String jdbcURL = "jdbc:mysql://localhost:3306/W11yash";
		String jdbcUsername = "root";
		String jdbcPassword = "26101993";
		friendDAO = new FriendDAO(jdbcURL, jdbcUsername, jdbcPassword);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		String color = request.getParameter("color");
		
		// validate input
		if (name == null || name.trim().isEmpty() || email == null || email.trim().isEmpty() ||
				age == null || age.trim().isEmpty() || color == null || color.trim().isEmpty()) {
			String message = "All fields are required.";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/V_93_error.jsp").forward(request, response);
			return;
		}

		int ageInt = 0;
		try {
			ageInt = Integer.parseInt(age);
		} catch (NumberFormatException e) {
			String message = "Age must be a number.";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/V_93_error.jsp").forward(request, response);
			return;
		}

		M_93_Friend friend = new M_93_Friend();
		friend.setName(name);
		friend.setEmail(email);
		friend.setAge(ageInt);
		friend.setColor(color);

		try {
			friendDAO.insertFriend(friend);
			response.sendRedirect("C_93_ViewFriends");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
