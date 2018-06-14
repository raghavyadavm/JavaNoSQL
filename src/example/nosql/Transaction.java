package example.nosql;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;

/**
 * Servlet implementation class Transaction
 */
@WebServlet("/Transaction")
public class Transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Transaction() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter out = response.getWriter();
		

		String warehouse = request.getParameter("warehouse");
		String district = request.getParameter("district");
		String customer = request.getParameter("customer");
		String OL_I_ID = request.getParameter("OL_I_ID");
		String OL_Supply_W_ID = request.getParameter("OL_Supply_W_ID");
		int OL_Quantity = Integer.parseInt(request.getParameter("OL_Quantity"));
		System.out.println(OL_Quantity);

		// ********************************DB
		// Connection*******************************************
		CloudantClient client = ClientBuilder
				.url(new URL("https://34f09895-fa40-463e-bdf1-95adf1093f35-bluemix.cloudant.com"))
				.username("34f09895-fa40-463e-bdf1-95adf1093f35-bluemix")
				.password("968944adcb6085fac098fab6eb69dcd86f4ffb2666c19020f844ab9fd0a66517").build();

		response.getWriter().println("New Order Transaction ");

		// *****************************Finding
		// Records*******************************

		Database waredb = client.database("warehouse", false);
		Database distdb = client.database("district", false);
		Database customerdb = client.database("customer", false);
		Database orderdb = client.database("order", false);
		Database neworderdb = client.database("neworder", false);
		Database historydb = client.database("history", false);
		Database itemdb = client.database("item", false);
		Database stockdb = client.database("stock", false);
		Database orderlinedb = client.database("orderline", false);
		
		String systime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		
		String w_id =warehouse;
		String d_id =district;
		String c_id =customer;
		String i_id = OL_I_ID;
		int nooflines = 1;
		int qty = OL_Quantity;
		
		
		String waresearch = w_id;
		System.out.println("waresearch "+waresearch);
		WareHouse whdoc = waredb.find(WareHouse.class,waresearch);
		
		double w_tax = whdoc.getW_TAX() * 0.1;
		//response.getWriter().println("w_tax "+ w_tax);
		
		String custsearch = w_id+d_id+c_id;
		System.out.println("custsearch"+custsearch);
		Customer custdoc = customerdb.find(Customer.class,custsearch);				
		double c_discount = custdoc.getC_DISCOUNT() * 0.03;
		String c_last = custdoc.getC_LAST();
		String c_credit = "BC";
		
		String distsearch = w_id+d_id;
		System.out.println("distsearch"+distsearch);
		District distdoc = distdb.find(District.class,distsearch);
		double d_tax = distdoc.getD_TAX() * 0.01 ;
		//String d_next_o_id = distdoc.getD_NEXT_O_ID();
		//distdoc.setD_NEXT_O_ID(d_NEXT_O_ID);
		
		String itemsearch = OL_I_ID;
		System.out.println("itemsearch"+itemsearch);
		Item itemdoc = itemdb.find(Item.class,itemsearch);
		int price = itemdoc.getI_PRICE();
		String itemname = itemdoc.getI_NAME();
		String i_data = itemdoc.getI_DATA();
		
		
		String stocksearch = OL_Supply_W_ID+i_id ;
		System.out.println("stocksearch"+stocksearch);
		Stock stockdoc = stockdb.find(Stock.class,stocksearch);

		double amount = qty * price;
		
		double total = (amount)*(1-c_discount)*(1+w_tax+d_tax);		
		
		
		response.getWriter().println("<html><head><style>"
				+ "table, th, td "
				+ "{    border: 1px solid black;"
				+ "    border-collapse: collapse;}</style></head><body>"
				+ "<table style='width:100%'><table class='table table-bordered'>"
				
			    + "<tbody>");
		response.getWriter().println("<tr> "
				+ "<td> Warehouse : "+warehouse+"</td>"
				+ "<td> District : "+district+"</td>"
				+ "<td> Date : "+systime+"</td>"
				+ "<td> </td>"
				+ "</tr>");
		response.getWriter().println("<tr> "
				+ "<td> Customer : "+customer+"</td>"
				+ "<td> Name : "+c_last+"</td>"
				+ "<td> Credit : "+c_credit+"</td>"
				+ "<td> %Disc : "+c_discount+"</td>"
				+ "</tr>");
		response.getWriter().println("<tr> "
				+ "<td> order no : "+(district+warehouse+customer)+"</td>"
				+ "<td> No of Lines : 1</td>"
				+ "<td> W_tax : "+w_tax+"</td>"
				+ "<td> D_tax : "+d_tax+"</td>"
				+ "</tr><br");
		response.getWriter().println("</tbody>"
				+"</table>");
		
		response.getWriter().println("<html><head><style>"
				+ "table, th, td "
				+ "{    border: 1px solid black;"
				+ "    border-collapse: collapse;}</style></head><body>"
				+ "<table style='width:100%'><table class='table table-bordered'>"
				
			    + "<thead>	");
		response.getWriter().println("<tr> "
				+ "<th> Supp_w : </th>"
				+ "<th> Item id :</th>"
				+ "<th> Item Name : </th>"
				+ "<th> Quantity: </th>"
				+ "<th> B/G: </th>"
				+ "<th> Price: </th>"
				+ "<th> Amount: </th>"
				+ "</tr></thead><tbody>");
		response.getWriter().println("<tr> "
				+ "<td> "+OL_Supply_W_ID+"</td>"
				+ "<td>  "+i_id+"</td>"
				+ "<td>"+itemname+"</td>"
				+ "<td> "+qty+"</td>"
				+ "<td> G </td>"
				+ "<td> "+price+"</td>"
				+ "<td> "+amount+"</td>"
				+ "</tr>");
		response.getWriter().println("<tr> "
				+ "<td> </td>"
				+ "<td>  </td>"
				+ "<td></td>"
				+ "<td> </td>"
				+ "<td> </td>"
				+ "<td> Total</td>"
				+ "<td> "+total+"</td>"
				+ "</tr>");
		response.getWriter().println("</tbody>"
				+"</table></body></html>");	
		
		
		
		
	}

}
