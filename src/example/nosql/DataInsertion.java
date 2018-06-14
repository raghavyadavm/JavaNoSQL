package example.nosql;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;

/**
 * Servlet implementation class ListOfTables
 */
@WebServlet("/DataInsertion")
public class DataInsertion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataInsertion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		CloudantClient client1 = ClientBuilder
				.url(new URL("https://34f09895-fa40-463e-bdf1-95adf1093f35-bluemix.cloudant.com"))
				.username("34f09895-fa40-463e-bdf1-95adf1093f35-bluemix")
				.password("968944adcb6085fac098fab6eb69dcd86f4ffb2666c19020f844ab9fd0a66517").build();
		
		
		response.getWriter().println("Connection is established with server version "+client1.serverVersion());
		
		//******************************Insertion of Data**********************************
		/*Database db1 = client1.database("test", false);
		
				Person person = new Person();
				person.set_id("Robert");
				person.setName("Robert Downey JR");
				person.setAge("40");
				person.setHobby("IronMan");
				
				Response r = db1.post(person);
						
				response.getWriter().println("Person created successfully. Id: " + r.getId() + ", rev: " + r.getRev());
			*/
				Database db2 = client1.database("warehouse", false);
				
				WareHouse wh = new WareHouse();
				wh.set_id("1");
				wh.setW_NAME("a");
				wh.setW_STREET_1("apartment no : 1");
				wh.setW_STREET_2("street : 1");
				wh.setW_CITY("NewYork");
				wh.setW_STATE("NY");
				wh.setW_TAX(7);
				wh.setW_YTD(2016);
		
				
				Response r1 = db2.post(wh);
						
				response.getWriter().println("Warehouse data created successfully. Id: " + r1.getId() + ", rev: " + r1.getRev());		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
