
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegistration() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String zipCode = request.getParameter("zipcode");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmpassword");
		String radioBtn = request.getParameter("radio");

		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='user-output.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form>");
		out.println("<div class='align'>");
		out.print("<h1>Thank you for joining our mailing list</h1>");
		out.print("<br>");
		out.print("<b>Here is the information that you entered</b>");
		out.print("<br>");
		out.print("<br>");
		out.print("<div class='parameters'>");
		out.print("<h3>First Name: </h3>");
		out.print("<h3>Last Name: </h3>");
		out.print("<h3>Email: </h3>");
		out.print("<h3>Zip Code: </h3>");
		out.print("<h3>User Name: </h3>");
		out.print("<h3>Password: </h3>");
		out.print("<h3>Favourite Music: </h3>");
		out.print("<h3>Receive special sale notification</h3>");
		out.print("</div>");

		out.print("<div class='field-values'>");
		out.println("<h3 class='normal'>" + firstName + "</h3>");
		out.println("<h3 class='normal'>" + lastName + "</h3>");
		out.println("<h3 class='normal'>" + email + "</h3>");
		out.println("<h3 class='normal'>" + zipCode + "</h3>");
		out.println("<h3 class='normal'>" + userName + "</h3>");
		out.println("<h3 class='normal'>" + password + "</h3>");
		String[] checkboxValues = request.getParameterValues("checkbox");
		if (checkboxValues != null) {
			for (int i = 0; i < checkboxValues.length; i++) {
				out.println("<div class='position'><h3>" + checkboxValues[i] + " " + "</h3></div>");
			}
		}
		out.println("<h3>" + radioBtn + "</h3>");
		out.print("</div>");
		out.print("</div>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

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
