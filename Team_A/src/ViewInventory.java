

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewInventory
 */
@WebServlet("/ViewInventory")
public class ViewInventory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewInventory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		//Inventory inventory = new Inventory(UtilDB.listInventory());
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Inventory";
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
              "<body>\n" + //
              "<table style=\"width:100%\">\n" + 
              		"<tr style=\"background-color: #f0f0f0\">\n" + 
              		"<th>Item</th>\n" + 
              		"<th>Quantity</th>\n" + 
              		"<th>Storage Type</th>\n" +
              		"<th>Cost</th>\n" +
              		"</tr>");
        //TODO: change object to item
        if(!UtilDB.getInventory(user).isEmpty()) {
        	for(Item item: UtilDB.getInventory(user)) {
        		out.printf("<tr>\r\n" + 
        			"    <td>%s</td>\n" + 
        			"    <td>%d</td>\n" + 
         	 		"    <td>%s</td>\n" + 
         	 		"    <td>%.2f</td>\n" +
         	 		"  </tr>",item.getName(), item.getQuantity(), item.getStorage(), item.getCost());
           }
        }
        out.println("</table>");
        out.println("<a href=\\Team_A\\Home_Page.html>Home</a> <br>");
        out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
