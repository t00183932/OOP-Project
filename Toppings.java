package Project;

import javax.swing.*;
import java.util.ArrayList;

public class Toppings {
    private double toppingPrice;
    private ArrayList<String> main = new ArrayList<>();


    public Toppings()
    {
        this(0,null);
    }

    public Toppings(double toppingPrice, ArrayList<String> main)
    {
        setToppingPrice(toppingPrice);
        setToppings(main);
    }

    public void setToppingPrice(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    public void setToppings(ArrayList<String> main)
    {
        this.main = main;
    }

    public double getToppingPrice() {
        return this.toppingPrice;
    }

    public String getToppings() {

        JTextArea txtArea = new JTextArea();

        String txt="";

        txt+= this.main.get(0);

        for(int i=1; i<this.main.size(); i++)
        {
            txt+= ", " + this.main.get(i);
        }

        txtArea.append(txt);

        return txt;
    }

    public String toString()
    {
        return getToppings();
    }
}
