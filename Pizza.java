package Project;

public class Pizza extends Order {
    protected Toppings toppings;
    private String size;
    private double price;

    public Pizza()
    {
        super();
        toppings = new Toppings("Unknown","Unknown");
    }

    public Pizza(String type, String topping, String sauce, String size, double price)
    {
        this.toppings = new Toppings(topping,sauce);
        setSize(size);
        setPrice(price);
    }

    public void setTopping(String topping, String sauce)
    {
        this.toppings = new Toppings(topping,sauce);
    }

    public void setSize(String size)
    {
        this.size = size;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public Toppings getTopping() {
        return toppings;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }
}
