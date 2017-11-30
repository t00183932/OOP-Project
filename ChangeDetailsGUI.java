package Project;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.swing.text.ChangedCharSetException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class ChangeDetailsGUI extends JFrame implements ActionListener {

    JMenu file;
    JLabel txt;
    String[] comboTxt = {"Name", "Address", "Username", "Password", "Phone", "Email"};
    JComboBox comboBox;
    JButton confirm, cancel;
    String username;
    int choice;
    int i = PizzaDeliveryGUI.i;

    public static void main(String[] args) {
        ChangeDetailsGUI c = new ChangeDetailsGUI();
        c.setVisible(true);

    }

    public ChangeDetailsGUI() {
        setTitle("Change Account Details");
        setSize(300, 115);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        txt = new JLabel("Choose what to update");

        file = new JMenu("File");
        JMenuItem item;
        item = new JMenuItem("Save Changes");
        item.addActionListener(this);
        file.add(item);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(file);

        comboBox = new JComboBox(comboTxt);
        comboBox.setSelectedIndex(0);
        confirm = new JButton("Confirm");
        confirm.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        add(txt);
        add(comboBox);
        add(confirm);
        add(cancel);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == confirm) {
            String item = String.valueOf(comboBox.getSelectedItem());

            if (item.equals("Name")) {
                PizzaDeliveryGUI.customers.get(i).setName(JOptionPane.showInputDialog("Enter name"));
                choice = JOptionPane.showConfirmDialog(null, "Change more details?");
                confirmDialogue();
            }
            if (item.equals("Address")) {
                PizzaDeliveryGUI.customers.get(i).setCity(JOptionPane.showInputDialog("Enter city"));
                PizzaDeliveryGUI.customers.get(i).setAddress(JOptionPane.showInputDialog("Enter address"));
                PizzaDeliveryGUI.customers.get(i).setHouseNo(Integer.parseInt(JOptionPane.showInputDialog("Enter house no.")));
                confirmDialogue();

            }

            if (item.equals("Username")) {
                username = JOptionPane.showInputDialog("Enter a username");
                Authentication();

            }

            if(item.equals("Password")) {
                PizzaDeliveryGUI.customers.get(i).setPassword(JOptionPane.showInputDialog("Enter a password"));
            }

            if(item.equals("Phone")) {
                PizzaDeliveryGUI.customers.get(i).setPhone(JOptionPane.showInputDialog("Enter phone no."));
            }

            if(item.equals("Email")) {
                PizzaDeliveryGUI.customers.get(i).setEmail(JOptionPane.showInputDialog("Enter an email"));
            }
        }

        if (e.getSource() == cancel)
            this.dispose();

        if(e.getActionCommand().equals("Save Changes"))
        {
            try {
                this.save("customers.dat");
                JOptionPane.showMessageDialog(null, "Changes are saved", "Save Successful", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException var4) {
                JOptionPane.showMessageDialog(null, "Changes have not been saved","Error",JOptionPane.ERROR_MESSAGE);
                var4.printStackTrace();
            }

        }
    }


    public void confirmDialogue() {
        if (choice == JOptionPane.NO_OPTION || choice == JOptionPane.CANCEL_OPTION || choice == JOptionPane.CLOSED_OPTION)
            this.dispose();
    }

    public void save(String fileName) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
        for (Customer customer : PizzaDeliveryGUI.customers)
            pw.println(customer.toString());
        pw.close();
    }

    public void Authentication() {
        boolean valid=false;

        while (!valid)
        {
            int j;

            if (username.equals(PizzaDeliveryGUI.customers.get(i).getUsername())) {
                JOptionPane.showMessageDialog(null, "Username unchanged");
                valid = true;
                confirmDialogue();
            }

            else {
                for (j = 0; j < PizzaDeliveryGUI.customers.size(); j++) {

                    if (username.equals(PizzaDeliveryGUI.customers.get(j).getUsername())) {
                        JOptionPane.showMessageDialog(null, "That username is already taken", "Invalid Username",
                                JOptionPane.ERROR_MESSAGE);
                        username = JOptionPane.showInputDialog("Enter Username");
                        break;

                    }
                    }

                if(j==PizzaDeliveryGUI.customers.size()) {
                    valid = true;
                    PizzaDeliveryGUI.customers.get(i).setUsername(username);
                }
            }
        }
    }
}