package Project;

import java.util.ArrayList;

public class Customer extends User {
    private String name;
    private String address;
    private String password;
    private String DOB;
    private String phone;
    private String email;
    private ArrayList<String> orders;

    public Customer()
    {
        this("unknown","unknown","unknown","unknown","unknown","unknown");
    }

    public Customer(String name, String address, String password, String DOB, String phone, String email)
    {
        setName(name);
        setAddress(address);
        setPassword(password);
        setDOB(DOB);
        setPhone(phone);
        setEmail(email);
    }

    public void type(String type) {
        setType(type);
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public String getDOB() {
        return DOB;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return String.format("%s%s\n%s%s\n%s%s\n%s%s\n%s%s","Name: ", getName(),"Address", getAddress(),"DOB: ", getDOB(),
                "Phone: ", getPhone(),"Email: ", getEmail());
    }
}
