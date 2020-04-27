

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetBudget
 */
@WebServlet("/GetBudget")
public class GetBudget extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBudget() {
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
		html += getBudget(user);
		html += "<a href=\\Team_A\\Home_Page.html>Home</a> <br>";
		html += "</body></html>"; // end of body, html
		out.println(html);
		
	}

//	private void makeExpense(User user) {
//		Budget budget = UtilDB.getBudget(user);
//		Expense expense = new Expense("Rent", 515.0);
//		UtilDB.addExpense(budget, expense);
//		
//	}
	private String getBudget(User user) {
		String html = "";
		Budget budget = UtilDB.getBudget(user);
		html += String.format("<p> Budget: %s, Income: %.2f</p>",budget.getName(), budget.getIncome());
		for( Expense expense: UtilDB.getExpenses(budget)) {
			html += String.format("<p>Expense: %s, Amount: %.2f</p>", expense.getName(), expense.getAmount());
		}
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
