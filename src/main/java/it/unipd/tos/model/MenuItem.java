////////////////////////////////////////////////////////////////////
// [SEBASTIANO] [CACCARO] [1142944]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

public class MenuItem {
    public enum itemType{PIZZE,PRIMI}
    
    private itemType dish;
    private String name;
    private double price;

    public MenuItem(itemType dish,String name, double price) {
        this.setName(new String(name));
        this.setPrice(price);
        this.setDish(dish);
    }


    public itemType getDish() {
        return dish;
    }

    public void setDish(itemType dish) {
        this.dish = dish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


}