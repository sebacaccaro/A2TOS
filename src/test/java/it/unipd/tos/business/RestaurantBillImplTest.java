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
	public void getOrderPriceStandardTest() {
		List<MenuItem> conto = new ArrayList<MenuItem>();
		RestaurantBillImpl cassa = new RestaurantBillImpl();
		conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",23));
		conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",24));
        conto.add(new MenuItem(MenuItem.itemType.PRIMI,"Spaghetti",2.5));
        conto.add(new MenuItem(MenuItem.itemType.PRIMI,"Verze",3));
		double totale = 0;
        try {
            totale = cassa.getOrderPrice(conto);
        } catch (RestaurantBillException e) {
            e.printStackTrace();
        }
		assertEquals(totale, 52.5, 0.001);
		
	}
	
	@Test
	public void getOrderPrice10PiuGratisTest() {
	    List<MenuItem> conto = new ArrayList<MenuItem>();
        RestaurantBillImpl cassa = new RestaurantBillImpl();
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",13));
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",24));
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",2.5));
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",3));
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",13));
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",13));
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",4));
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",2.5));
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",3));
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",4));
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",2.5));
        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",3));
        conto.add(new MenuItem(MenuItem.itemType.PRIMI,"Spaghetti",2.5));
        conto.add(new MenuItem(MenuItem.itemType.PRIMI,"Verze",3));
        conto.add(new MenuItem(MenuItem.itemType.PRIMI,"Spaghetti",2.5));
        conto.add(new MenuItem(MenuItem.itemType.PRIMI,"Verze",3));

        double totale = 0;
        try {
            totale = cassa.getOrderPrice(conto);
        } catch (RestaurantBillException e) {
            e.printStackTrace();
        }
        assertEquals(totale, 96, 0.001);
	}
	
	
	@Test
	public void getOrderPriceMoreThan100Test() {
	    List<MenuItem> conto = new ArrayList<MenuItem>();
	    RestaurantBillImpl cassa = new RestaurantBillImpl();
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",13));
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",24));
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",2.5));
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",3));
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",43));
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",13));
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",4));
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",2.5));
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",3));
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",4));
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",2.5));
	    conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",3));
	    conto.add(new MenuItem(MenuItem.itemType.PRIMI,"Spaghetti",2.5));
	    conto.add(new MenuItem(MenuItem.itemType.PRIMI,"Verze",3));
	    conto.add(new MenuItem(MenuItem.itemType.PRIMI,"Spaghetti",2.5));
	    conto.add(new MenuItem(MenuItem.itemType.PRIMI,"Verze",3));

	    double totale = 0;
	    try {
	        totale = cassa.getOrderPrice(conto);
	    } catch (RestaurantBillException e) {
	        e.printStackTrace();
	    }
	    assertEquals(totale, 119.7, 0.001);
	}
	
	
	@Test(expected = RestaurantBillException.class)
	public void getOrderPriceMoreThan20Items() throws RestaurantBillException {
	    List<MenuItem> conto = new ArrayList<MenuItem>();
	    RestaurantBillImpl cassa = new RestaurantBillImpl();
	    for(int i=1;i < 13;i++) {
	        conto.add(new MenuItem(MenuItem.itemType.PIZZE,"Margherita",13));
	        conto.add(new MenuItem(MenuItem.itemType.PRIMI,"Spaghetti",24));
	    }

	    double totale = cassa.getOrderPrice(conto);
	}



}
