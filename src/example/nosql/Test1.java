package example.nosql;

import java.net.MalformedURLException;
import java.net.URL;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;

public class Test1 {
	public static int index = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CloudantClient conn = null;
		try {
			conn = ClientBuilder.url(new URL("http://127.0.0.1:5984/")).username("admin").password("password").build();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Connection is established with server version " + conn.serverVersion());
		Database db1 = conn.database("district", true);
		Database db2 = conn.database("customer", true);
		Database db3 = conn.database("item", true);
		Database db4 = conn.database("stock", true);

		/*District d = new District();

		for (int wi = 1; wi <= 2; wi++) {

			for (int di = 1; di <= 10; di++) {
				d.set_id(Integer.toString(wi) + Integer.toString(di));
				d.setD_NAME(new Rand().randomIdentifier());
				d.setD_STREET_1(new Rand().randomIdentifier());
				d.setD_CITY(new Rand().randomIdentifier());
				d.setD_STATE(new Rand().randomIdentifier());
				d.setD_ZIP(new Rand().randomIdentifier());
				d.setD_TAX(7);
				d.setD_YTD(2016);

				Response r1 = db1.post(d);
				System.out.println("District data created successfully. Id: " + r1.getId() + ", rev: " + r1.getRev());

				Customer c = new Customer();
				for (int ci = 0; ci < 3000; ci++) {
					c.set_id(Integer.toString(wi) + Integer.toString(di) + Integer.toString(index++));
					c.setC_FIRST(new Rand().randomIdentifier());
					c.setC_MIDDLE(new Rand().randomIdentifier());
					c.setC_LAST(new Rand().randomIdentifier());
					c.setC_STREET_1(new Rand().randomIdentifier());
					c.setC_STREET_2(new Rand().randomIdentifier());
					c.setC_CITY(new Rand().randomIdentifier());
					c.setC_STATE(new Rand().randomIdentifier());
					c.setC_ZIP(new Rand().randomIdentifier());
					c.setC_PHONE(new Rand().randomIdentifier());
					c.setC_CREDIT(new Rand().randomIdentifier());
					c.setC_CREDIT_LIM(10000);
					c.setC_DISCOUNT(10);
					c.setC_BALANCE(100000);
					c.setC_YTD_PAYMENT(200);
					c.setC_PAYMENT_CNT(10);
					c.setC_DELIVERY_CNT(100);
					c.setC_DATA(new Rand().randomIdentifier());

					Response r2 = db2.post(c);
					System.out
							.println("District data created successfully. Id: " + r2.getId() + ", rev: " + r2.getRev());
				}

			}

		}
		
		Item it = new Item();
		
		for (int iti = 1; iti <= 100000; iti++) {
			it.set_id(Integer.toString(index++));
			it.setI_NAME(new Rand().randomIdentifier());
			it.setI_PRICE(10);
			it.setI_DATA(new Rand().randomIdentifier());
			
			Response r3 = db3.post(it);
			System.out
					.println("District data created successfully. Id: " + r3.getId() + ", rev: " + r3.getRev());
		
		}
		
		
		Item it = new Item();
		
		for (int iti = 1; iti <= 100000; iti++) {
			it.set_id(Integer.toString(index++));
			it.setI_NAME(new Rand().randomIdentifier());
			it.setI_PRICE(10);
			it.setI_DATA(new Rand().randomIdentifier());
			
			Response r3 = db3.post(it);
			System.out
					.println("District data created successfully. Id: " + r3.getId() + ", rev: " + r3.getRev());
		
		}
		
		*/
		
		Order or = new Order();
		Database db5 = conn.database("order", true);
		
		Stock sc = new Stock();
		for (int wi = 1; wi <= 2; wi++) {
			for (int sci = 1; sci <= 10000; sci++) {
				or.set_id(Integer.toString(wi) + Integer.toString(index++));
				
				or.setO_CARRIER_ID(new Rand().randomIdentifier());
				or.setO_ENTRY_D(new Rand().randomIdentifier());
				
				or.setO_OL_CNT(2016);
				or.setO_ALL_LOCAL(12);

				Response r4 = db5.post(sc);
				System.out.println("District data created successfully. Id: " + r4.getId() + ", rev: " + r4.getRev());

			}
		}

		
	}

}
