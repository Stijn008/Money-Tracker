package Visual;

import Facade.Facade;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;

public class ViewGlobalBillPanel extends JPanel {
    private JButton back;
    private JButton getBalance;
    private JLabel bill ;
    private Facade facade ;
    private JTextField enterName;
    private GUI gui;

    public ViewGlobalBillPanel(GUI gui,Facade facade) {
        this.gui = gui;
        this.facade = facade;
        this.setLayout(new BoxLayout(this , BoxLayout.PAGE_AXIS));
        this.setBorder(new EmptyBorder(new Insets(300, 150, 300, 150)));
        JLabel label = new JLabel("Balance");
        ButtonListenerV listen = new ButtonListenerV();
        this.getBalance = new JButton("Get balance");
        getBalance.addActionListener(listen);
        this.back = new JButton("Back");
        this.bill = new JLabel("balance");
        back.addActionListener(listen);
        this.enterName = new JTextField(20);
        this.add(label);
        this.add(this.enterName);
        this.add(this.bill);
        this.add(this.getBalance);
        this.add(this.back);

    }
    private class ButtonListenerV implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == getBalance){
                try {
                    System.out.println(enterName.getText()+"'s balance (positive = you should pay, negative = you should receive)");
                    bill.setText("balance   "+ facade.calculateGlobalBill(enterName.getText()));
                    enterName.setText("");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }else if (event.getSource() == back) {
                gui.changePanel("MenuPanel");
            }
        }
    }


}
