package Project;


import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class CustomerGUI extends JFrame implements ActionListener {

    String type,size;
    double toppingPrice=0, pizzaPrice;
    int i = PizzaDeliveryGUI.i; //gets the customer in the array list that is logged in
    ArrayList<String> main = new ArrayList<>();



    JMenu account;

    JRadioButton caddress = new JRadioButton("Current Address"), naddress = new JRadioButton("New Address"),
            small = new JRadioButton("Small - 5.56Eur"), medium = new JRadioButton("Medium - 11.23Eur"),
            large = new JRadioButton("Large - 15.90Eur"), margh = new JRadioButton("Margherita"),
            kebab = new JRadioButton("Kebab"), veggie = new JRadioButton("Veggie"),
            seaFood = new JRadioButton("Sea Food");

    Box topBox,typeBox, sizeBox;

    JCheckBox pepperoni = new JCheckBox("Pepperoni"), mushrooms = new JCheckBox("Mushrooms"),
            sausages = new JCheckBox("Sausages"), chicken = new JCheckBox("Chicken"),
            ham = new JCheckBox("Ham"), salami = new JCheckBox("Salami");

    JButton orderButton = new JButton("Order Now"), signOutButton = new JButton("Sign Out");

    ButtonGroup sizeGroup,typeGroup;


    public static void main(String[] args) {
        new CustomerGUI();
    }

    public CustomerGUI() {
        setTitle("Order Now");
        setSize(470, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        account = new JMenu("Account");
        JMenuItem item;
        item = new JMenuItem("View Account Details");
        item.addActionListener(this);
        account.add(item);
        item = new JMenuItem("View Orders");
        item.addActionListener(this);
        account.add(item);
        item = new JMenuItem("Change Details");
        item.addActionListener(this);
        account.add(item);
        item = new JMenuItem("Sign Out");
        item.addActionListener(this);
        account.add(item);

        //GUI construction code obtained from http://www.java2s.com/Tutorial/Java/0240__Swing/UseGridBagLayouttolayoutRadioButtons.htm

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(account);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        addItem(panel1, new JLabel("Choose Address :"), 1, 0, 1, 1, GridBagConstraints.EAST);

        ButtonGroup addressGroup = new ButtonGroup();
        addressGroup.add(caddress);
        naddress.addActionListener(this);
        addressGroup.add(naddress);

        addItem(panel1, caddress, 1, 1, 2, 1, GridBagConstraints.WEST);
        addItem(panel1, naddress, 1, 2, 1, 1, GridBagConstraints.WEST);

        sizeBox = Box.createVerticalBox();
        sizeGroup = new ButtonGroup();
        sizeGroup.add(small);
        sizeGroup.add(medium);
        sizeGroup.add(large);
        sizeBox.add(small);
        sizeBox.add(medium);
        sizeBox.add(large);
        sizeBox.setBorder(BorderFactory.createTitledBorder("Size"));
        addItem(panel1, sizeBox, 0, 3, 1, 1, GridBagConstraints.NORTH);

        typeBox = Box.createVerticalBox();

        typeGroup = new ButtonGroup();
        typeGroup.add(margh);
        typeGroup.add(kebab);
        typeGroup.add(veggie);
        typeGroup.add(seaFood);
        typeBox.add(margh);
        typeBox.add(kebab);
        typeBox.add(veggie);
        typeBox.add(seaFood);
        typeBox.setBorder(BorderFactory.

                createTitledBorder("Type"));
        addItem(panel1, typeBox, 1, 3, 1, 1, GridBagConstraints.NORTH);

        topBox = Box.createVerticalBox();
        JLabel price = new JLabel("1Eur Each");
        topBox.add(price);
        topBox.add(ham);
        topBox.add(chicken);
        topBox.add(salami);
        topBox.add(pepperoni);
        topBox.add(mushrooms);
        topBox.add(sausages);

        topBox.setBorder(BorderFactory.createTitledBorder("Toppings"));
        addItem(panel1, topBox, 2, 3, 1, 1, GridBagConstraints.NORTH);

        Box buttonBox = Box.createHorizontalBox();
        orderButton.addActionListener(this);
        buttonBox.add(orderButton);
        buttonBox.add(Box.createHorizontalStrut(20));
        signOutButton.addActionListener(this);
        buttonBox.add(signOutButton);
        addItem(panel1, buttonBox, 2, 4, 1, 1, GridBagConstraints.NORTH);

        this.add(panel1);
        this.pack();
        this.setVisible(true);

    }

    private void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = x;
        gc.gridy = y;
        gc.gridwidth = width;
        gc.gridheight = height;
        gc.weightx = 100.0;
        gc.weighty = 100.0;
        gc.insets = new Insets(5, 5, 5, 5);
        gc.anchor = align;
        gc.fill = GridBagConstraints.NONE;
        p.add(c, gc);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Sign Out") || e.getSource() == signOutButton)
        {

            this.dispose();
            PizzaDeliveryGUI p = new PizzaDeliveryGUI();
            p.setVisible(true);
        }

        if(e.getActionCommand().equals("View Account Details")){
            JTextArea txt = new JTextArea();

            txt.append(PizzaDeliveryGUI.customers.get(i).toString());
            JOptionPane.showMessageDialog(null,txt,"Account Details",JOptionPane.INFORMATION_MESSAGE);
        }

        if(e.getActionCommand().equals("Change Details")){
            ChangeDetailsGUI c = new ChangeDetailsGUI();
            c.setVisible(true);
        }


        if(e.getSource() == orderButton) {
            boolean valid = true;
            String error="";

            if (naddress.isSelected()) {
                String address;
                int houseNo;
                address = JOptionPane.showInputDialog("Enter new address");
                houseNo = Integer.parseInt(JOptionPane.showInputDialog("Enter house no."));
                customer().setAddress(address);
                customer().setHouseNo(houseNo);
            } else if (!caddress.isSelected()) {
                error+= "You did not choose an address";
                valid = false;
            }

            if (small.isSelected()) {
                pizzaPrice = 5.56;
                size = "Small";
            } else if (medium.isSelected()) {
                pizzaPrice = 11.23;
                size = "Medium";
            } else if (large.isSelected()) {
                pizzaPrice = 15.90;
                size = "Large";

            }

            if (sizeGroup.getSelection() == null) {
                error+="\nYou must select a size";
                valid = false;
            }

            if (typeGroup.getSelection() == null) {
                error+="\nYou must select a type";
                valid = false;
            }

            else {
                for (int i = 0; i < typeGroup.getButtonCount(); i++) {
                    if (typeGroup.getSelection().isSelected()) {
                        for (Enumeration<AbstractButton> buttons = typeGroup.getElements(); buttons.hasMoreElements(); ) {
                            AbstractButton button = buttons.nextElement();

                            if (button.isSelected()) {
                                type = button.getText();

                            }

                        }

                    }

                }

            }

            if (pepperoni.isSelected()) {
                    toppingPrice++;
                    main.add("Pepperoni");
                }

                if (ham.isSelected()) {
                    toppingPrice++;
                    main.add("Ham");
                }

                if (chicken.isSelected()) {
                    toppingPrice++;
                    main.add("Chicken");
                }

                if (sausages.isSelected()) {
                    toppingPrice++;
                    main.add("Sausages");
                }

                if (mushrooms.isSelected()) {
                    toppingPrice++;
                    main.add("Mushrooms");
                }

                if (salami.isSelected()) {
                    toppingPrice++;
                    main.add("Salami");
                }

                else
                    main.add("None");

                if(!valid) {
                    JOptionPane.showMessageDialog(null,"Order not completed correctly\n\n" + error,"Error",JOptionPane.ERROR_MESSAGE);

                }

                else  {
                    JTextArea txt = new JTextArea();
                    txt.append("Your Order: \n\n");
                    Pizza order = new Pizza(type, size, toppingPrice, main, pizzaPrice);
                    txt.append(order.toString());

                    Object[] buttons = {"Pay","Cancel"};

                   int c = JOptionPane.showOptionDialog(null, txt, "Order",
                           JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, buttons, buttons[0]);

                    if(c == JOptionPane.YES_OPTION) {
                        customer().setOrder(order);
                        JOptionPane.showMessageDialog(null,"Your order is complete","Order sent",JOptionPane.INFORMATION_MESSAGE);
                    }

                    else
                        JOptionPane.showMessageDialog(null,"Order Cancelled","Order",0);

                    toppingPrice = 0;
                    pizzaPrice = 0;
                    main = new ArrayList<>();
                    sizeGroup.clearSelection();
                    typeGroup.clearSelection();
                }


        }

        if(e.getActionCommand().equals("View Orders"))
        {
            if(!customer().getOrders().isEmpty()) {
                JTextArea txtArea = new JTextArea();
                txtArea.append(customer().getOrders());
                txtArea.setEditable(false);
                JOptionPane.showMessageDialog(null, txtArea, "Order Details", JOptionPane.INFORMATION_MESSAGE);
            }

            else
                JOptionPane.showMessageDialog(null,"You made no orders yet","Error",JOptionPane.ERROR_MESSAGE);

        }



    }



    public Customer customer()
    {
        return PizzaDeliveryGUI.customers.get(i);
    }
}
