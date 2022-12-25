package Visual;

import Facade.Facade;
import Visual.GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    private JButton addFriend;
    private JButton newTicket;
    private GUI gui;
    private JButton viewBill;


    public MenuPanel(GUI gui ) {
        this.gui = gui;
        this.setLayout(new BoxLayout(this , BoxLayout.PAGE_AXIS));
        this.setBorder(new EmptyBorder(new Insets(250, 250, 250, 250)));
        JLabel label = new JLabel("Menu");
        ButtonListenerM listen = new ButtonListenerM();
        this.addFriend = new JButton("Add Friend");
        addFriend.addActionListener(listen);
        this.newTicket = new JButton("Create new ticket");
        newTicket.addActionListener(listen);
        this.viewBill = new JButton("View global bill");
        viewBill.addActionListener(listen);
        this.add(label);
        this.add(this.addFriend);
        this.add(this.newTicket);
        this.add(this.viewBill);
    }

    private class ButtonListenerM implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == addFriend) {
                gui.changePanel("AddFriendPanel");

            } else if (event.getSource() == newTicket){
                gui.changePanel("AddTicketPanel");

            } else if (event.getSource() == viewBill) {
                 gui.changePanel("ViewGlobalBillPanel");
            }

        }

    }


}
