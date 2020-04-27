

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateBudget
 */
@WebServlet("/CreateBudget")
public class CreateBudget extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBudget() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user"); // get the user whom logged in
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		String html = setupPage();
		
		if(UtilDB.getBudget(user) != null) {
			html += String.format("<p>%s already has a budget created!</p>", user.getUsername());
		} else {
			String budgetName = request.getParameter("name");
			Double income = Double.valueOf(request.getParameter("income"));
			
			Budget budget = new Budget(budgetName, income);
			UtilDB.createBudget(user, budget);
			html += "Budget created!  " + budget.getName();
		}
		html += "<a href=\\Team_A\\Home_Page.html>Home</a> <br>";
		html += "</body></html>"; // end of body, html
		out.println(html);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private String setupPage() {
        String title = "Budget";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
                "transitional//en\">\n";
        String html = docType + //
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
                "<body>\n"; //
		return html;
	}
}
