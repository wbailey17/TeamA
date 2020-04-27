

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewUser
 */
@WebServlet("/NewUser")
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("name");
		if(UtilDB.newUser(username)) {
			response.sendRedirect("/Team_A/Home_Page.html");
		}
		else {
			response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        String title = "User Already Exists";
	        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
	              "transitional//en\">\n"; //
	        out.println(docType + //
	              "<html>\n" + //
	              "<head>\n"
	              + "<style>\n"
	              + "table, th, td {\n"
	              + "border: 1px solid black;\n"
	              + "border-collapse: collapse;\n}"
	              + "header {\n" + 
	              "    background-color:black;\n" + 
	              "    color:white;\n" + 
	              "    text-align:center;\n" + 
	              "    padding:5px;\n" + 
	              "}"
	              + "</style>\n"
	              + "<header>\n" + 
	              "	<h1>" + title + "</h1>\n" + 
	              "</header>"
	              + "<title>" + title + "</title></head><br>\n" + //
	              "<body>\n");        			
	        out.println("<a href=\\Team_A\\New_User.html>Try Again</a> <br>"); 
	        out.println("</body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
