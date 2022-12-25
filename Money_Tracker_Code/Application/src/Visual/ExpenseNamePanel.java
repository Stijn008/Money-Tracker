package Visual;

import Facade.Facade;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ExpenseNamePanel extends JPanel {
    private JButton back;
    private JTextField enterName;
    private JButton add;
    private JButton menu;
    private JTextField enterConsumer;
    private JTextField enterPrice;
    private JTextField enterType;
    private JTextField discount;
    private JTextField valet;
    private GUI gui;
    private Facade facade ;
    private JButton rememberTicket;
    private JButton createTicket;

    public ExpenseNamePanel(GUI gui,Facade facade) {
        this.facade = facade;
        this.setLayout(new BoxLayout(this , BoxLayout.PAGE_AXIS));
        this.setBorder(new EmptyBorder(new Insets(200, 150, 200, 150)));
        ButtonListenerEN listen = new ButtonListenerEN();
        JLabel label = new JLabel("Enter expense name");
        this.back = new JButton("Back");
        back.addActionListener(listen);
        this.enterName = new JTextField(20);
        this.add = new JButton("Add");
        this.menu = new JButton("Menu");
        this.gui = gui;
        menu.addActionListener(listen);
        add.addActionListener(listen);
        JLabel label3 = new JLabel("Enter Consumer");
        JLabel label1 = new JLabel("Enter type : (entrance,parking,transport,toilet,food,snack,drink)");
        JLabel label2 = new JLabel("Enter Price");
        JLabel label4 = new JLabel("Enter discount");
        JLabel label5 = new JLabel("Enter valet");
        this.enterConsumer = new JTextField(20);
        this.enterPrice = new JTextField(20);
        this.enterType =  new JTextField(20);
        this.discount = new JTextField(20);
        this.valet =  new JTextField(20);
        this.rememberTicket = new JButton("Remember ticket");
        rememberTicket.addActionListener(listen);
        this.createTicket = new JButton("Create ticket");
        createTicket.addActionListener(listen);
        this.enterConsumer =  new JTextField(20);
        this.enterPrice = new JTextField(20);
        this.enterType =  new JTextField(20);
        this.discount =  new JTextField(20);
        this.valet =  new JTextField(20);
        this.add(label);
        this.add(this.enterName);
        this.add(label3);
        this.add(this.enterConsumer);
        this.add(label2);
        this.add(this.enterPrice);
        this.add(label1);
        this.add(this.enterType);
        this.add(label4);
        this.add(this.discount);
        this.add(label5);
        this.add(this.valet);
        this.add(this.add);
        this.add(this.rememberTicket);
        this.add(this.createTicket);
        this.add(this.menu);

    }


    private class ButtonListenerEN implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == add) {
                System.out.println(enterName.getText()+" expense added to the ticket");
                float extra = 0F;

                if (Objects.equals(enterType.getText(), "entrance")) {
                    if (discount.getText().length() == 0) {
                        extra = 0F;
                    } else {
                        try {
                            extra = Float.parseFloat(discount.getText());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                } else if (Objects.equals(enterType.getText(), "parking")) {
                    if (valet.getText().length() == 0) {
                        extra = 0F;
                    } else {
                        try {
                            extra = Float.parseFloat(valet.getText());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                try {
                    facade.addExpense(enterName.getText(), Float.parseFloat(enterPrice.getText()), enterConsumer.getText(), enterType.getText(), extra);
                    enterName.setText("");
                    enterPrice.setText("");
                    enterType.setText("");
                    enterConsumer.setText("");
                    discount.setText("");
                    valet.setText("");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if (event.getSource() == createTicket) {
                System.out.println("Ticket added to ticket list");
                facade.addTicket();
            } else if (event.getSource() == rememberTicket) {
                System.out.println("Ticket added to ticket list and saved");
                facade.rememberTicket();
            } else if (event.getSource() == back) {
                gui.changePanel("AddTicketPanel");
            } else if (event.getSource() == menu) {
                gui.changePanel("MenuPanel");
            }
        }
    }
}
