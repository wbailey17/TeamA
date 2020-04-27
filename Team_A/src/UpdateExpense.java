

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateExpense
 */
@WebServlet("/UpdateExpense")
public class UpdateExpense extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateExpense() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Double amount;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user"); // get the user whom logged in
		
		String name = request.getParameter("expenseName");
		String newName = request.getParameter("newName");
		if(!request.getParameter("amount").equals("")) {
			amount = Double.valueOf(request.getParameter("amount"));
		}
		else {
			amount = -1.0;
		}
		
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		String html = setupPage();
		html += editExpense(user, name, newName, amount);
		html += "<a href=\\Team_A\\Home_Page.html>Home</a> <br>";
		html += "</body></html>"; // end of body, html
		out.println(html);
	}
	
	private String editExpense(User user, String name, String newName, Double amount) {
		Budget budget = UtilDB.getBudget(user);
		String html = "";
		Expense expense = UtilDB.editExpense(budget, name, newName, amount);
		
		html += String.format("<h2>Expense added to: Budget %s </h2>", budget.getName() );
		html += String.format("%s , %.2f",expense.getName() ,expense.getAmount());
		return html;
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
