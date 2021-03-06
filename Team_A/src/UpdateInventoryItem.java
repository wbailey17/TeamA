

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateInventoryItem
 */
@WebServlet("/UpdateInventoryItem")
public class UpdateInventoryItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInventoryItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Uncomment and remove last line
		float cost;
		int quantity;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String itemName = request.getParameter("itemName");
		String newName = request.getParameter("newName");
		if(!request.getParameter("cost").equals("")) {
			cost = Float.valueOf(request.getParameter("cost"));
		}
		else {
			cost = -1;
		}
		if(request.getParameter("quantity").equals("") == false) {
			quantity = Integer.valueOf(request.getParameter("quantity"));
		}
		else {
			quantity = -1;
		}
		String storage = request.getParameter("storage");
        updateItem(user, itemName, newName, cost, quantity, storage, response);
	}
	
	void updateItem(User user, String itemName, String newName, float cost, int quantity, String storage, HttpServletResponse response) throws IOException {
		//Inventory inventory = new Inventory(UtilDB.listInventory());
		//Item item = inventory.updateItem(itemName, newName, cost, quantity, storage);
		//Item item = user.getInventories().get(0).updateItem(itemName, newName, cost, quantity, storage);
		Item item = UtilDB.updateItem(user, itemName, newName, cost, quantity, storage);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Item Updated";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
              "transitional//en\">\n"; //
        out.printf(docType + //
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
              "<table style=\"width:100%%\">\n" + 
              		"<tr style=\"background-color: #f0f0f0\">\n" + 
              		"<th>Item</th>\n" + 
              		"<th>Quantity</th>\n" + 
              		"<th>Storage Type</th>\n" +
              		"<th>Cost</th>\n" +
              		"</tr>" +
              		"<tr>\r\n" + 
         	 		"    <td>%s</td>\n" + 
         	 		"    <td>%d</td>\n" + 
         	 		"    <td>%s</td>\n" + 
         	 		"    <td>%.2f</td>\n" + 
         	 		"    </tr>",item.getName(), item.getQuantity(), item.getStorage(), item.getCost());
        			
        out.println("</table>");
        out.println("<a href=\\Team_A\\Home_Page.html>Home</a> <br>"); //TODO: update link
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
