package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FriendDAO;

@WebServlet("/C_93_DeleteFriend")
public class C_93_DeleteFriend extends HttpServlet {
	
	private FriendDAO friendDAO;

	public void init() {
		String jdbcURL = "jdbc:mysql://localhost:3306/W11yash";
		String jdbcUsername = "root";
		String jdbcPassword = "26101993";
		friendDAO = new FriendDAO(jdbcURL, jdbcUsername, jdbcPassword);
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // retrieve friend ID from request parameters
        int friendId = Integer.parseInt(request.getParameter("id"));
        
        // delete friend from database
        try {
			friendDAO.deleteFriend(friendId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // redirect to view all friends page
        response.sendRedirect("C_93_ViewFriends");
    }

}
