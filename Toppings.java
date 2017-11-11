package Project;

import java.util.ArrayList;

public class Toppings {
    private int portions;
    private String[] main = new String[4];


    public Toppings()
    {
        this(0,null);
    }

    public Toppings(int portions, String[] main)
    {
        setPortions(portions);
        setToppings(main);
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    public void setToppings(String[] toppings)
    {
        this.main = main;
    }

    public int getPortions() {
        return this.portions;
    }

    public String getToppings() {

        String txt="";

        txt+= this.main[0];

        for(int i=1; i<this.main.length; i++)
        {
            txt+= ", " + this.main[i];
        }

        return txt;
    }
}
