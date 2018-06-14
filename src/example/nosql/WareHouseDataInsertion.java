package example.nosql;

import java.io.IOException;
import java.net.URL;
import java.util.List;

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
 * Servlet implementation class WareHouseDataInsertion
 */
@WebServlet("/WareHouseDataInsertion")
public class WareHouseDataInsertion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int index=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WareHouseDataInsertion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		CloudantClient client2 = ClientBuilder
				.url(new URL("https://34f09895-fa40-463e-bdf1-95adf1093f35-bluemix.cloudant.com"))
				.username("34f09895-fa40-463e-bdf1-95adf1093f35-bluemix")
				.password("968944adcb6085fac098fab6eb69dcd86f4ffb2666c19020f844ab9fd0a66517").build();

		response.getWriter().println("Connection is established with server version "+client2.serverVersion());
		
		//******************************Insertion of Data**********************************
		Database db1 = client2.database("warehouse", false);
		
				WareHouse wh = new WareHouse();
				wh.set_id("1");
				wh.setW_NAME("a");
				wh.setW_STREET_1("apartment no : 1");
				wh.setW_STREET_2("street : 1");
				wh.setW_CITY("NewYork");
				wh.setW_STATE("NY");
				wh.setW_TAX(7);
				wh.setW_YTD(2016);
		
				
				Response r = db1.post(wh);
						
				response.getWriter().println("Warehouse data created successfully. Id: " + r.getId() + ", rev: " + r.getRev());
				//*****************************Finding a specific Record*******************************		
				//WareHouse doc = db1.find(WareHouse.class,"1f9ce45ae81314472080178405fae4b4");
				//response.getWriter().println(doc.getW_ID());
				List<WareHouse> whs = db1.findByIndex("{\"W_ID\" :\"1\"}", WareHouse.class);
				for (WareHouse waredata : whs) {
					response.getWriter().println(waredata);
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
