package example.nosql;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;

public class Test {
	public static int index = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ********************************DB
				// Connection*******************************************
				CloudantClient client = null;
				try {
					client = ClientBuilder.url(new URL("http://127.0.0.1:5984/")).username("admin").password("password").build();
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("Connection is established with server version " + client.serverVersion());

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
				
				String w_id ="1";
				String d_id ="1";
				String c_id ="1";
				String i_id = "1";
				int nooflines = 1;
				int qty = 2;
				
				
				String waresearch = w_id;
				WareHouse whdoc = waredb.find(WareHouse.class,waresearch);
				
				double w_tax = whdoc.getW_TAX();
				System.out.println("w_tax "+ w_tax);
				
				String custsearch = w_id+d_id+c_id;
				Customer custdoc = customerdb.find(Customer.class,custsearch);				
				double c_discount = custdoc.getC_DISCOUNT() * 0.03;
				String c_last = custdoc.getC_LAST();
				String c_credit = "BC";
				
				String distsearch = w_id+d_id;
				District distdoc = distdb.find(District.class,distsearch);
				double d_tax = distdoc.getD_TAX() * 0.01 ;
				//String d_next_o_id = distdoc.getD_NEXT_O_ID();
				//distdoc.setD_NEXT_O_ID(d_NEXT_O_ID);
				
				String itemsearch = "1";
				Item itemdoc = itemdb.find(Item.class,itemsearch);
				int price = itemdoc.getI_PRICE();
				String itemname = itemdoc.getI_NAME();
				String i_data = itemdoc.getI_DATA();
				
				String OL_SUP_W_ID = "1";
				String OL_I_ID = "1";
				String stocksearch = OL_SUP_W_ID+OL_I_ID;
				Stock stockdoc = stockdb.find(Stock.class,stocksearch);
				
				
				System.out.println("disc" + c_discount);
				System.out.println("qty" + qty);
				System.out.println("price" + price);
				System.out.println("d_tax" + d_tax);
				//System.out.println("price" + price);
				
				double amount = qty * price;
				
				double total = (amount)*(1-c_discount)*(1+w_tax+d_tax);		
				
				System.out.println("amount "+amount+" total "+ total);
				
				

	}

}
