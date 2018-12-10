////////////////////////////////////////////////////////////////////
// [SEBASTIANO] [CACCARO] [1142944]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

public class RestaurantBillImplTest {

	@Test
	public void test() throws RestaurantBillException {
		List<MenuItem> conto = new ArrayList<MenuItem>();
		RestaurantBillImpl cassa = new RestaurantBillImpl();
		conto.add(new MenuItem("Margherita",23));
		conto.add(new MenuItem("Margherita",24));
		conto.add(new MenuItem("Margherita",2.5));
		conto.add(new MenuItem("Margherita",3));
		double totale = cassa.getOrderPrice(conto);
		assertEquals(totale, 52.5, 0.001);
		
	}

}
