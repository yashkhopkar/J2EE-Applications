
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImportRecords
 */
@WebServlet("/ImportRecords")
public class ImportRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	List<Employee> DUMMY_DATA = new ArrayList<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImportRecords() {
		super();
		// TODO Auto-generated constructor stub
		try {
			//first step loading up the Driver (J-Connection)
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/as2_yash";
			String uname = "root";
			String pass = "26101993";
			
			con = DriverManager.getConnection(dburl, uname, pass);
			
			Employee emp1 = new Employee("1", "John", "IT", "SDE1");
			Employee emp2 = new Employee("2", "Jane", "IT", "SDE2");
			Employee emp3 = new Employee("3", "Doe", "Accounts", "Sr Accountant");
			Employee emp4 = new Employee("4", "Walter", "Finance", "Jr Finance Analyst");
			Employee emp5 = new Employee("5", "Jesse", "HR", "Jr HR");
			Employee emp6 = new Employee("6", "Gus", "IT", "SDE1");
			Employee emp7 = new Employee("7", "Mike", "HR", "Sr HR");
			Employee emp8 = new Employee("8", "Skylar", "IT", "SDE3");
			Employee emp9 = new Employee("9", "Light", "IT", "SDE2");
			Employee emp10 = new Employee("10", "L", "HR", "Jr HR");
			
			DUMMY_DATA.add(emp1);
			DUMMY_DATA.add(emp2);
			DUMMY_DATA.add(emp3);
			DUMMY_DATA.add(emp4);
			DUMMY_DATA.add(emp5);
			DUMMY_DATA.add(emp6);
			DUMMY_DATA.add(emp7);
			DUMMY_DATA.add(emp8);
			DUMMY_DATA.add(emp9);
			DUMMY_DATA.add(emp10);

			
		}catch(Exception e) {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		

		PrintWriter out = response.getWriter();

		try {
			if(DUMMY_DATA.size() > 0) {
				for (Employee employee : DUMMY_DATA) {
					PreparedStatement pst = con.prepareStatement("insert into EMP values(?, ?, ?, ?)");
					pst.setString(1, employee.getEmpNo());
					pst.setString(2, employee.getEmpName());
					pst.setString(3, employee.getDepartment());
					pst.setString(4, employee.getEmpJob());
					pst.executeUpdate();
					}
				
				out.println("Record Added successfully");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
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
