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
import com.cloudant.client.api.model.Index;
import com.cloudant.client.api.model.Response;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Connect")
public class Connection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Connection() {
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
		response.setContentType("text/html");
		
		
		//********************************DB Connection*******************************************
		CloudantClient client = ClientBuilder
				.url(new URL("https://34f09895-fa40-463e-bdf1-95adf1093f35-bluemix.cloudant.com"))
				.username("34f09895-fa40-463e-bdf1-95adf1093f35-bluemix")
				.password("968944adcb6085fac098fab6eb69dcd86f4ffb2666c19020f844ab9fd0a66517").build();

		response.getWriter().println("Connection is established with server version "+client.serverVersion());
		
		//*****************************Print the DB's in CLoudant**************************
		response.getWriter().println("<P ALIGN='center'>List of DB's<TABLE BORDER=1>");
		List<String> l = client.getAllDbs();
		Database db = client.database("talent-manager", false);
		//response.getWriter().println(db.getDBUri());//

		for (String string : l) {
			response.getWriter().println("<TR><TD>"+string+"</TD></TR></br>");
		}
		
		response.getWriter().println("</TABLE></P></br>");
		response.getWriter().println("Writing data into new db </br>");
		
		//*****************************Finding a specific Record*******************************
		
		Database db1 = client.database("test", false);
		
		
	
		
		List<Person> persons = db1.findByIndex("{\"name\" :\"Raghav M\"}", Person.class);
		for (Person persondata : persons) {
			response.getWriter().println(persondata);
		}
		
		//******************************Insertion of Data**********************************
		
		/*Person person = new Person();
		person.set_id("Tom");
		person.setName("Tom Hardy");
		person.setAge("30");
		person.setHobby("Soccer");
		
		Response r = db1.post(person);
				
		response.getWriter().println("Person created successfully. Id: " + r.getId() + ", rev: " + r.getRev());
		*/
		
		
		//*******************************To see all indices in DB***********
		
		List<Index> li = db1.listIndices();
		response.getWriter().println("<br>List Of Indices");
		response.getWriter().println("<br> "+db1.getDBUri());
		for (Index index : li) {
			response.getWriter().println(index);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
