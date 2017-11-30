package Project;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * author: Miomir Miletic
 */

public class PizzaDeliveryGUI extends JFrame implements ActionListener{

    JMenu userMenu;
    JLabel usernameLabel, passwordLabel;
    JPanel loginPanel;  
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;
    JButton signupButton;
    GridBagConstraints gc = new GridBagConstraints();
    public static Customer customer = new Customer();
    public static ArrayList<Customer> customers = new ArrayList<>(); //variables declared as public static so other classes have access to the list.
    public static int i;

    public static void main(String[] args) {

        PizzaDeliveryGUI gui = new PizzaDeliveryGUI(); //driver running the gui application
        gui.setVisible(true);

    }

    public PizzaDeliveryGUI() {
        setTitle("Pizza Parlor");
        setSize(400, 280);
        setLocationRelativeTo(null);
        Container pane = getContentPane();
        pane.setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createUserMenu();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(userMenu);



        createHeaderLabel();

        createLoginPanel();



    }

    private void createUserMenu() {
        userMenu = new JMenu("User");
        JMenuItem item;
        item = new JMenuItem("Register Account");
        item.addActionListener(this);
        userMenu.add(item);
        userMenu.addSeparator();
        item = new JMenuItem("Quit");
        item.addActionListener(this);
        userMenu.add(item);
    }

    private void createHeaderLabel() {
        JPanel hpanel = new JPanel();
        JLabel headerLabel;
        Font font = new Font("forte", Font.PLAIN, 24);
        headerLabel = new JLabel("Welcome to Pizza Parlor", JLabel.CENTER);
        headerLabel.setFont(font);
        headerLabel.setForeground(Color.RED);
        hpanel.add(headerLabel);
        hpanel.setBounds(70, 20, 250, 40);
        PizzaDeliveryGUI.super.add(hpanel);
    }

    private void createLoginPanel() {
        loginPanel = new JPanel(new GridBagLayout());
        usernameLabel = new JLabel("Username :");
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(0, 0, 20, 5);
        loginPanel.add(usernameLabel, gc);
        usernameField = new JTextField(12);
        usernameField.addActionListener(this);
        gc.gridx = 1;
        gc.gridy = 0;
        loginPanel.add(usernameField, gc);
        passwordLabel = new JLabel("Password :");
        gc.gridx = 0;
        gc.gridy = 1;
        loginPanel.add(passwordLabel, gc);
        passwordField = new JPasswordField(12);
        passwordField.addActionListener(this);
        gc.gridx = 1;
        gc.gridy = 1;
        loginPanel.add(passwordField, gc);
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        gc.gridx = 0;
        gc.gridy = 2;
        gc.insets = new Insets(0, 30, 10, 5);
        loginPanel.add(loginButton, gc);
        signupButton = new JButton("Sign Up");
        signupButton.addActionListener(this);
        gc.gridx = 1;
        gc.gridy = 2;
        loginPanel.add(signupButton, gc);
        loginPanel.setBounds(60, 40, 250, 200);
        PizzaDeliveryGUI.super.add(loginPanel);
    }

    private void registerCustomer() {
        RegisterGUI r = new RegisterGUI();
        r.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Register Account") || e.getSource() == signupButton) {
            registerCustomer(); //opens up another gui application from a different class when event happens
        }

        if (e.getActionCommand().equals("Quit")) {
            JOptionPane.showMessageDialog(null, "Thanks for using Pizza Parlor!", "Goodbye",
                    JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }

        if (e.getSource() == usernameField) {
            passwordField.requestFocus();
        }

        if (e.getActionCommand().equals("Login")) {
            String name, password, ausername, apassword;
            name = usernameField.getText();
            password = new String(passwordField.getPassword());

            if(!customers.isEmpty())
            {
                for(i=0; i<customers.size(); i++) {

                    ausername = customers.get(i).getUsername();
                    apassword = customers.get(i).getPassword();

                    //checks to see if a customer is registered by going through the array list of customers.

                    if (name.equals(ausername) && password.equals(apassword)) {
                        JOptionPane.showMessageDialog(null, "Welcome " + name,"Login Successful",
                                JOptionPane.INFORMATION_MESSAGE);

                        CustomerGUI c = new CustomerGUI();
                        c.setVisible(true);
                        this.dispose();
                        break;
                    }


                }

                if(i == customers.size())
                    JOptionPane.showMessageDialog(null, "Invalid user/password", "Login Failed",
                            JOptionPane.ERROR_MESSAGE);


            }

            else
                JOptionPane.showMessageDialog(null, "Invalid user/password", "Login Failed",
                        JOptionPane.ERROR_MESSAGE);

        }


    }
}


