package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaDeliveryGUI extends JFrame implements ActionListener{

    JMenu userMenu, optionsMenu;

    public static void main(String[] args) {

        PizzaDeliveryGUI gui = new PizzaDeliveryGUI();
        gui.setVisible(true);
    }

    public PizzaDeliveryGUI()
    {
        setTitle("Pizza Haven");
        setSize      ( 400,400 );
        setLocationRelativeTo(null);
        Container pane = getContentPane();
        pane.setBackground(new Color(255, 90, 88));
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        createFileMenu();
        createOptionsMenu();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(userMenu);
        menuBar.add(optionsMenu);
    }

    private void createFileMenu() {
        userMenu = new JMenu("User");
        JMenuItem item;
        item = new JMenuItem("Login");
        item.addActionListener(this);
        userMenu.add(item);
        item = new JMenuItem("Register");
        item.addActionListener(this);
        userMenu.add(item);
        userMenu.addSeparator();
        item = new JMenuItem("Quit");
        item.addActionListener(this);
        userMenu.add(item);
    }

    private void createOptionsMenu()
    {
        optionsMenu = new JMenu("Options");
        JMenuItem item;
        item = new JMenuItem("View Orders");
        item.addActionListener(this);
        optionsMenu.add(item);
        item = new JMenuItem("Log in as Administrator");
        item.addActionListener(this);
        optionsMenu.add(item);

    }

    public void actionPerformed (ActionEvent e) {
        if (e.getActionCommand() .equals ("Quit")){
            JOptionPane.showMessageDialog(null,"Thanks for using Pizza Haven!","Goodbye",
                    JOptionPane.PLAIN_MESSAGE);
            System.exit(0);

    }


}

}
