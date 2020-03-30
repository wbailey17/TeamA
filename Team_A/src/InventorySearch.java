

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchForItem
 */
@WebServlet("/SearchForItem")
public class InventorySearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventorySearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String keyword = request.getParameter("item");
        search(keyword, response);
	}

	void search(String keyword, HttpServletResponse response) throws IOException {
		List<Item> items = UtilDB.listInventory(keyword);
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
        for(Item item: items) {
        	 out.println("<tr>\r\n" + 
         	 		"    <td>"+ item.getName() + "</td>\n" + 
         	 		"    <td>"+ item.getQuantity() + "</td>\n" + 
         	 		"    <td>" + item.getStorage() + "</td>\n" + 
         	 		"    <td>" + item.getCost() + "</td>\n" +
         	 		"  </tr>");
           }
        out.println("</table>");
        out.println("<a href="); //TODO: update link
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
