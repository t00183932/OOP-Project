package Project;

public class Admin extends User {
    private String type;
    private String username;
    private String password;


    public Admin(String username, String password)
    {
        setUsername(username);
        setPassword(password);
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
