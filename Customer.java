package Project;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer extends Order {
    private String type;
    private String name;
    private String city;
    private String address;
    private int houseNo;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Order orders;

    public Customer()
    {
        this("unknown","unknown","unknown",0,"Unknown","unknown","unknown","unknown",null);
    }

    public Customer(String name, String city, String address,int houseNo,String username, String password, String phone, String email, ArrayList<Pizza> orders)
    {
        setName(name);
        setCity(city);
        setAddress(address);
        setHouseNo(houseNo);
        setUsername(username);
        setPassword(password);
        setPhone(phone);
        setEmail(email);
        this.orders = new Order(orders);

    }

    public void setType(String type) {
        this.type = type;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHouseNo(int houseNo)
    {
        this.houseNo = houseNo;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType()
    {
        return this.type;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return String.format("%s%s\n%s%s\n%s%s\n%s%s\n%s%d\n%s%s\n%s%s","Name: ", getName(),"Username: ", getUsername(),"City:", getCity(),"Address: ", getAddress(),
                "HouseNo: ", getHouseNo(),"Phone: ", getPhone(),"Email: ", getEmail());
    }
}
