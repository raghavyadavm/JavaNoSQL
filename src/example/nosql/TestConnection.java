package example.nosql;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;

public class TestConnection {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		 CloudantClient client = ClientBuilder.url(new URL("https://34f09895-fa40-463e-bdf1-95adf1093f35-bluemix.cloudant.com"))
		            .username("34f09895-fa40-463e-bdf1-95adf1093f35-bluemix")
		            .password("968944adcb6085fac098fab6eb69dcd86f4ffb2666c19020f844ab9fd0a66517")
		            .build();
		 
		List<String> l = client.getAllDbs();
		
		for (String string : l) {
			System.out.println(string);
		}
		
		//Database db = client.database("sample", true);
		
		//System.out.println("Database available - " + db.getDBUri());

	}

}
