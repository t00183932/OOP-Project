package Project;

import java.io.Serializable;
import java.util.ArrayList;

public class Order extends Pizza  {
    private ArrayList<Pizza> orders = new ArrayList<>();

    public Order() {
        this(null);
    }

    public Order(ArrayList<Pizza> orders)
    {
    }


    public void setOrder(Pizza order)
    {
        this.orders.add(order);
    }

    public String getOrders()
    {
        String txt="";

        for(int i=0; i<orders.size(); i++)
        {
            txt+= orders.get(i) + "\n";
        }

        return txt;
    }

}
