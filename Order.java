package Project;

public class Order {
    private String type;

    public Order() {
        this("Unknown");
    }

    public Order(String type)
    {
        setType(type);
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return this.type;
    }

    public String toString()
    {
        return "Type: " + getType();
    }
}
