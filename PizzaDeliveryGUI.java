package Project;

import sun.security.util.Password;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PizzaDeliveryGUI extends JFrame implements ActionListener {

    JMenu userMenu, optionsMenu;
    JLabel usernameLabel, passwordLabel;
    JPanel loginPanel;
    JTextField usernameField;
    JButton loginButton;
    JButton signupButton;
    GridBagConstraints gc = new GridBagConstraints();
    public static Customer customer = new Customer();
    public static ArrayList<Customer> customers = new ArrayList<>();


    JPasswordField passwordField;

    public static void main(String[] args) {

        PizzaDeliveryGUI gui = new PizzaDeliveryGUI();
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

        createFileMenu();
        createAdminMenu();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(userMenu);
        menuBar.add(optionsMenu);

        createHeaderLabel();

        createLoginPanel();

    }

    private void createFileMenu() {
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

    private void createAdminMenu() {
        optionsMenu = new JMenu("Admin");
        JMenuItem item;
        item = new JMenuItem("Log in as Administrator");
        item.addActionListener(this);
        optionsMenu.add(item);

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
        usernameLabel = new JLabel("User");
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(0, 0, 20, 5);
        loginPanel.add(usernameLabel, gc);
        usernameField = new JTextField(12);
        usernameField.addActionListener(this);
        gc.gridx = 1;
        gc.gridy = 0;
        loginPanel.add(usernameField, gc);
        passwordLabel = new JLabel("Password");
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
            registerCustomer();
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
            String name, password, aname, apassword;
            name = usernameField.getText();
            password = new String(passwordField.getPassword());
            int i;

            if(!customers.isEmpty())
            {
                for(i=0; i<customers.size(); i++) {

                    aname = customers.get(i).getName();
                    apassword = customers.get(i).getPassword();

                    if (name.equals(aname) && password.equals(apassword)) {
                        JOptionPane.showMessageDialog(null, "Welcome " + name,"Login Successful",
                                JOptionPane.INFORMATION_MESSAGE);
                        break;

                    }


                }

                if(i == customers.size())
                {
                    JOptionPane.showMessageDialog(null, "Invalid user/password", "Login Failed",
                            JOptionPane.ERROR_MESSAGE);
                }

            }

            else
                JOptionPane.showMessageDialog(null, "Invalid user/password", "Login Failed",
                        JOptionPane.ERROR_MESSAGE);




        }


    }
}


