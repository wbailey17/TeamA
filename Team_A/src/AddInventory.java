

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddNewItem
 */
@WebServlet("/AddInventory")
public class AddInventory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInventory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Uncomment and remove last line
		String name = request.getParameter("name");
		int cost = Integer.valueOf(request.getParameter("cost"));
		int quantity = Integer.valueOf(request.getParameter("quantity"));
		String storage = request.getParameter("storage");
        addItem(name, cost, quantity, storage, response);
		//addItem("milk", 1, 1, "fridge", response);
	}
	
	void addItem(String name, int cost, int quantity, String storage, HttpServletResponse response) throws IOException {
		Item item = UtilDB.createItem(name, cost, quantity, storage);
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Item Added";
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
              		"</tr>" +
              		"<tr>\r\n" + 
         	 		"    <td>"+ item.getName() + "</td>\n" + 
         	 		"    <td>"+ item.getQuantity() + "</td>\n" + 
         	 		"    <td>" + item.getStorage() + "</td>\n" + 
         	 		"    <td>" + item.getCost() + "</td>\n" +
         	 		"  </tr>");
        			
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
