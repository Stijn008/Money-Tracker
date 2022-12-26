package Visual;

import Facade.Facade;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTicketPanel extends JPanel {
    private JButton split;
    private JButton nosplit;
    private JButton loadSplit;
    private JButton loadNoSplit;
    private Facade facade ;
    private JTextField enterTicket;
    private JTextField enterName;
    private GUI gui;
    private JButton back;

    public AddTicketPanel(GUI gui,Facade facade) {
        this.facade = facade;
        this.setLayout(new BoxLayout(this , BoxLayout.PAGE_AXIS));
        this.setBorder(new EmptyBorder(new Insets(240, 150, 200, 150)));
        this.gui = gui;
        JLabel label = new JLabel("Enter ticket name");
        ButtonListenerAT listen = new ButtonListenerAT();
        JLabel label1 = new JLabel("Who paid?");
        this.split = new JButton("Create split ");
        split.addActionListener(listen);
        this.nosplit = new JButton("Create no split");
        nosplit.addActionListener(listen);
        this.loadSplit =new JButton("Load saved split ticket");
        loadSplit.addActionListener(listen);
        this.loadNoSplit =new JButton("Load saved no split ticket");
        loadNoSplit.addActionListener(listen);
        this.enterTicket = new JTextField(20);
        this.enterName = new JTextField(20);
        this.back = new JButton("Back");
        back.addActionListener(listen);
        this.add(label);
        this.add(this.enterTicket);
        this.add(label1);
        this.add(this.enterName);
        this.add(this.split);
        this.add(this.nosplit);
        this.add(this.loadSplit);
        this.add(this.loadNoSplit);

        this.add(this.back);
    }
    private class ButtonListenerAT implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == split) {
                try {
                    facade.createTicket(enterTicket.getText(), enterName.getText(), true);
                    gui.changePanel("ExpenseNamePanel");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if (event.getSource() == nosplit){
                try {
                    facade.createTicket(enterTicket.getText(),enterName.getText(), false);
                    gui.changePanel("ExpenseNamePanel");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if (event.getSource() == loadSplit) {
                try {
                    System.out.println(enterTicket.getText()+" loaded and added to ticket list");
                    facade.loadTicket(enterTicket.getText(),enterName.getText(),true);
                    facade.addTicket();
                    gui.changePanel("ExpenseNamePanel");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if (event.getSource() == loadNoSplit) {
                try {
                    System.out.println(enterTicket.getText()+" loaded and added to ticket list");
                    facade.loadTicket(enterTicket.getText(),enterName.getText(),false);
                    facade.addTicket();
                    gui.changePanel("ExpenseNamePanel");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }else if (event.getSource() == back) {
                gui.changePanel("MenuPanel");
            }

        }

    }

}
