
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertFormRecords
 */
@WebServlet("/InsertFormRecords")
public class InsertFormRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertFormRecords() {
		super();
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
			String empNo = request.getParameter("empNo");
			String empName = request.getParameter("empName");
			String department = request.getParameter("department");
			String empJob = request.getParameter("empJob");

			PreparedStatement pst = con.prepareStatement("insert into EMP values(?, ?, ?, ?)");
			pst.setString(1, empNo);
			pst.setString(2, empName);
			pst.setString(3, department);
			pst.setString(4, empJob);
			pst.executeUpdate();
			
			out.print("Record Added!");

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
