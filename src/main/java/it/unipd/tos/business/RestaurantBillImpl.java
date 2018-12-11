////////////////////////////////////////////////////////////////////
// [SEBASTIANO] [CACCARO] [1142944]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

public class RestaurantBillImpl implements RestaurantBill{

    public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException {
        double final_price = 0;
        for(MenuItem item: itemsOrdered) {
            final_price += item.getPrice();
        }
        return final_price;
    }

}
