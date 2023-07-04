
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertRecords
 */
@WebServlet("/ShowRecords")
public class ShowRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowRecords() {
		super();
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/as2_yash";
			String uname = "root";
			String pass = "26101993";

			con = DriverManager.getConnection(dburl, uname, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		try {
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("select * from EMP");

			out.println(
					"<table border='1'>" + "<thead>" + "<td>Employee No</td>" + "<td>Employee Name</td>" + "<td>Department</td>" +"<td>Employee Job</td>" +"</thead>");

			while (rs.next()) {
				out.println("<tr>" + "<td>" + rs.getString("empNo") + "</td>" + "<td>" + rs.getString("empName")
						+ "</td>" + "<td>" + rs.getString("department") + "</td>" +"<td>" + rs.getString("empJob") + "</td>" + "</tr>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
