package Project;

import java.util.ArrayList;

public class Order {
    private static int orderNo=0;
    private ArrayList<Pizza> order;

    public Order() {
        this(null);
    }

    public Order(ArrayList<Pizza> orders)
    {
        setOrder(orders);
        orderNo();
    }

    public void orderNo()
    {
        orderNo++;
    }

    public static int getOrderNo()
    {
        return orderNo;
    }

    public void setOrder(ArrayList<Pizza> order)
    {
        this.order = order;
    }

    public String getOrder()
    {
        return order.toString();
    }

    public String toString()
    {
        return String.format("%s%d%s$s","Order Num: ", getOrderNo(),"Order: " + getOrder());
    }
}
