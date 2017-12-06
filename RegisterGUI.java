package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class RegisterGUI extends JFrame implements ActionListener {

    JLabel nameLabel, countyLabel, addressLabel, houseNoLabel, userLabel, passLabel, phoneLabel, emailLabel;
    JTextField nameField, countyField, addressField, houseNoField, userField, phoneField, emailField;
    JPasswordField passField;
    JButton registerButton, cancelButton;

    ArrayList<Pizza> orders = new ArrayList<>();

    public static void main(String[] args) {
        RegisterGUI r = new RegisterGUI();
        r.setVisible(true);


    }

    public RegisterGUI() {

        setTitle("Register Account");
        setSize(300, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Container pane = getContentPane();
        pane.setLayout(null);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(10, 10, 80, 25);
        pane.add(nameLabel);

        nameField = new JTextField(20);
        nameField.setBounds(100, 10, 160, 25);
        pane.add(nameField);

        countyLabel = new JLabel("County");
        countyLabel.setBounds(10, 40, 80, 25);
        pane.add(countyLabel);

        countyField = new JTextField(20);
        countyField.setBounds(100, 40, 160, 25);
        pane.add(countyField);

        addressLabel = new JLabel("Address");
        addressLabel.setBounds(10, 70, 80, 25);
        pane.add(addressLabel);

        addressField = new JTextField(20);
        addressField.setBounds(100, 70, 160, 25);
        pane.add(addressField);

        houseNoLabel = new JLabel("House No.");
        houseNoLabel.setBounds(10, 100, 80, 25);
        pane.add(houseNoLabel);

        houseNoField = new JTextField(5);
        houseNoField.setBounds(100, 100, 40, 25);
        pane.add(houseNoField);

        userLabel = new JLabel("Username");
        userLabel.setBounds(10, 130, 80, 25);
        pane.add(userLabel);

        userField = new JTextField(20);
        userField.setBounds(100, 130, 160, 25);
        pane.add(userField);

        passLabel = new JLabel("Password");
        passLabel.setBounds(10, 160, 80, 25);
        pane.add(passLabel);

        passField = new JPasswordField(20);
        passField.setBounds(100, 160, 160, 25);
        pane.add(passField);

        phoneLabel = new JLabel("Phone No.");
        phoneLabel.setBounds(10, 190, 80, 25);
        pane.add(phoneLabel);

        phoneField = new JTextField(20);
        phoneField.setBounds(100, 190, 160, 25);
        pane.add(phoneField);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(10, 220, 80, 25);
        pane.add(emailLabel);

        emailField = new JTextField(20);
        emailField.setBounds(100, 220, 160, 25);
        pane.add(emailField);

        registerButton = new JButton("Register");
        registerButton.setBounds(40, 250, 95, 40);
        registerButton.addActionListener(this);
        pane.add(registerButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(150,250,95,40);
        cancelButton.addActionListener(this);
        pane.add(cancelButton);
    }

    public void actionPerformed (ActionEvent e) {
        if(e.getSource() == registerButton)
        {
            String password , username;
            int houseNo, i;
            houseNo = Integer.parseInt(houseNoField.getText());
            username = userField.getText();
            password = new String(passField.getPassword());

            if(PizzaDeliveryGUI.customers.isEmpty()) {
                PizzaDeliveryGUI.customer = new Customer(nameField.getText(), countyField.getText(), addressField.getText(), houseNo,
                        username, password, phoneField.getText(), emailField.getText(), orders);

                PizzaDeliveryGUI.customers.add(PizzaDeliveryGUI.customer);
                JOptionPane.showMessageDialog(null, "Your account has been registered", "Registration Complete",
                        JOptionPane.INFORMATION_MESSAGE);
                try {
                    save("customers.dat");
                } catch (IOException var4) {
                    var4.printStackTrace();
                    this.dispose();
                }
                this.dispose();

            }
            else {

                for (i = 0; i < PizzaDeliveryGUI.customers.size(); i++) {
                    if (username.equals(PizzaDeliveryGUI.customers.get(i).getUsername())) {
                        JOptionPane.showMessageDialog(null, "That username is already taken", "Invalid Username",
                                JOptionPane.ERROR_MESSAGE);

                        userField.requestFocus();
                        break;
                    }

                    }

                    if(i == PizzaDeliveryGUI.customers.size()) {
                        PizzaDeliveryGUI.customer = new Customer(nameField.getText(), countyField.getText(), addressField.getText(), houseNo,
                                username, password, phoneField.getText(), emailField.getText(), orders);


                        PizzaDeliveryGUI.customers.add(PizzaDeliveryGUI.customer);
                        JOptionPane.showMessageDialog(null, "You registered an account!", "Registration Complete",
                                JOptionPane.INFORMATION_MESSAGE);
                        try {
                            save("customers.dat");
                        } catch (IOException var4) {
                            var4.printStackTrace();
                        }

                    this.dispose();


                }
            }



            }

            if(e.getSource() == cancelButton)
            {
                this.dispose();
            }


            }




    public void save(String fileName) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
        for (Customer customer : PizzaDeliveryGUI.customers)
            pw.println(customer.toString());
        pw.close();
    }

    private void write(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        // How many custoemrs we're tracking.
        oos.writeInt(PizzaDeliveryGUI.customers.size());
        for (Customer c : PizzaDeliveryGUI.customers) {
            oos.writeObject(c);
        }
        System.out.println("session serialized");
    }



}







