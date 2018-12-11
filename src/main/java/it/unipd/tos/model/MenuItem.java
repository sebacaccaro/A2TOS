////////////////////////////////////////////////////////////////////
// [SEBASTIANO] [CACCARO] [1142944]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

public class MenuItem {
    enum itemType{Pizze,Primi}
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = new String(name);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }


}