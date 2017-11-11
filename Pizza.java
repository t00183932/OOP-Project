package Project;

public class Pizza extends Toppings {
    protected Toppings toppings;
    private String type;
    private String size;
    private double price=0;

    public Pizza()
    {
        this("unknown","unknown",0,null,0);
    }

    public Pizza(String type, String size, int portions, String[] main, double price)
    {
        this.toppings = new Toppings(portions,main);
        setSize(size);
        setPrice(price);
    }

    public void setTopping(int portions, String[] main)
    {
        this.toppings = new Toppings(portions,main);
    }

    public void setSize(String size)
    {
        this.size = size;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

}
