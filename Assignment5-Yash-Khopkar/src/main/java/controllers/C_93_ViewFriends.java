package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FriendDAO;
import models.M_93_Friend;


@WebServlet("/C_93_ViewFriends")
public class C_93_ViewFriends extends HttpServlet {

    private FriendDAO friendDAO;

    public void init() {
        String jdbcURL = "jdbc:mysql://localhost:3306/W11yash";
        String jdbcUsername = "root";
        String jdbcPassword = "26101993";
        friendDAO = new FriendDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<M_93_Friend> friends = friendDAO.getAllFriends();
            request.setAttribute("friends", friends);
            request.getRequestDispatcher("V_93_allfriends.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
