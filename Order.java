package Project;

import java.util.ArrayList;

public class Order {
    private static int orderNo=0;
    private ArrayList<Pizza> orders;

    public Order() {
        this(0,null);
    }

    public Order(int orderNo, ArrayList<Pizza> orders)
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
        this.orders = order;
    }

    public String getOrders()
    {
        return orders.toString();
    }

    public String toString()
    {
        return "Type: " + getOrders();
    }
}
