package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterGUI extends JFrame implements ActionListener {

    JLabel nameLabel, cityLabel, addressLabel, houseNoLabel, passLabel, phoneLabel, emailLabel;
    JTextField nameField, cityField, addressField, houseNoField, phoneField, emailField;
    JPasswordField passField;
    JButton registerButton;

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

        cityLabel = new JLabel("City");
        cityLabel.setBounds(10, 40, 80, 25);
        pane.add(cityLabel);

        cityField = new JTextField(20);
        cityField.setBounds(100, 40, 160, 25);
        pane.add(cityField);

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

        passLabel = new JLabel("Password");
        passLabel.setBounds(10, 130, 80, 25);
        pane.add(passLabel);

        passField = new JPasswordField(20);
        passField.setBounds(100, 130, 160, 25);
        pane.add(passField);

        phoneLabel = new JLabel("Phone No.");
        phoneLabel.setBounds(10, 160, 80, 25);
        pane.add(phoneLabel);

        phoneField = new JTextField(20);
        phoneField.setBounds(100, 160, 160, 25);
        pane.add(phoneField);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(10, 190, 80, 25);
        pane.add(emailLabel);

        emailField = new JTextField(20);
        emailField.setBounds(100, 190, 160, 25);
        pane.add(emailField);

        registerButton = new JButton("Register");
        registerButton.setBounds(100, 240, 95, 40);
        registerButton.addActionListener(this);
        pane.add(registerButton);
    }

    public void actionPerformed (ActionEvent e) {
        if(e.getActionCommand().equals("Register"));
        {
            String password;
            int houseNo;
            houseNo = Integer.parseInt(houseNoField.getText());
            password = new String(passField.getPassword());
            PizzaDeliveryGUI.customer = new Customer(nameField.getText(),cityField.getText(),addressField.getText(),houseNo,
                    password,phoneField.getText(),emailField.getText());

            PizzaDeliveryGUI.customers.add(PizzaDeliveryGUI.customer);
            JOptionPane.showMessageDialog(null,"You registered an account!","Registration Complete",
                    JOptionPane.INFORMATION_MESSAGE);

            this.dispose();
        }





    }

}