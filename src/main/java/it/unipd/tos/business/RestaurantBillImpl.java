////////////////////////////////////////////////////////////////////
// [SEBASTIANO] [CACCARO] [1142944]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;
import java.util.stream.Collectors;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

public class RestaurantBillImpl implements RestaurantBill{

    public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException {
        double final_price = itemsOrdered.stream().mapToDouble(MenuItem::getPrice).sum();
        int pizza_count = (int) itemsOrdered.stream().filter(x -> x.getDish().equals(MenuItem.itemType.PIZZE)).count();
        if (pizza_count > 10) {
            final_price -= itemsOrdered.stream()
                                 .filter(x -> x.getDish().equals(MenuItem.itemType.PIZZE))
                                 .mapToDouble(x -> x.getPrice())
                                 .min().getAsDouble();
        }
        return final_price;
    }

}
