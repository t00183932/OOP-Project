package Project;

public class Toppings {
    private String main;
    private String sauce;
    private double price;
    private int noOfToppings;

    public Toppings()
    {
        this("unknown","unknown");

    }

    public Toppings(String main, String sauce)
    {
        setMainToppings(main);
        setSauce(sauce);
    }

    public void setMainToppings(String main)
    {
        this.main = main;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getMain() {
        return main;
    }

    public String getSauce() {
        return sauce;
    }
}
