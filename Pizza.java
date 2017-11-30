package Project;

import java.io.Serializable;
import java.util.ArrayList;

public class Pizza extends Toppings implements Serializable {
    private String type;
    private String size;
    private Toppings toppings;
    private double pizzaPrice;
    private double totalPrice=0;

    public Pizza()
    {
        this("unknown","unknown",0,null,0);
    }

    public Pizza(String type, String size, double toppingPrice, ArrayList<String> main, double pizzaPrice)
    {
        setType(type);
        setSize(size);
        this.toppings = new Toppings(toppingPrice,main);
        setPizzaPrice(pizzaPrice);
        setTotalPrice(totalPrice);
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(String size)
    {
        this.size = size;
    }

    public void setPizzaPrice(double pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }

    public void setTotalPrice(double totalprice) {
        this.totalPrice = totalprice;
    }

    public void setToppings(double price, ArrayList<String> main)
    {
        this.toppings.setToppingPrice(price);
        this.toppings.setToppings(main);
    }

    public String getToppings()
    {
        return this.toppings.toString();

    }

    public double getToppingPrice()
    {
        return this.toppings.getToppingPrice();

    }



    public String getType() {
        return this.type;
    }

    public String getSize() {
        return this.size;
    }

    public double getPizzaPrice()
    {
        return this.pizzaPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String toString()
    {
        totalPrice = this.getToppingPrice()+pizzaPrice;

        return String.format("%s%s\n%s%s\n%s%.2f\n%s%s\n%s%.2f","Pizza Type: ", getType(),"Size: ", getSize(),"Topping Price: ", getToppingPrice(),"Toppings: ",
        getToppings(),"Pizza Price: ", getPizzaPrice()) + "\n\nTotal Price: " + String.format("%.2f",totalPrice) + "\n";
    }

}
