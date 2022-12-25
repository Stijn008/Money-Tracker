package Visual;

import Facade.Facade;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Observable;

public class GUI extends JFrame {
    private JPanel currentPanel = new MenuPanel(this);
    private Facade facade ;
    public GUI(Facade facade) {
        super("Money Tracker");
        initialise();
        this.facade = facade;

    }
    public void initialise() {
        this.setSize(700,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(currentPanel);
        this.setVisible(true);
    }

    public void changePanel(String panel) {
         if (Objects.equals(panel, "MenuPanel")) {
             this.remove(currentPanel);
             currentPanel = new MenuPanel(this);
             this.add(currentPanel);
             this.setVisible(true);
         } else if (Objects.equals(panel, "AddFriendPanel")) {
             this.remove(currentPanel);
             currentPanel = new AddFriendPanel(this, facade) ;
             this.add(currentPanel);
             this.setVisible(true);
         } else if (Objects.equals(panel, "AddTicketPanel")) {
             this.remove(currentPanel);
             currentPanel = new AddTicketPanel(this,facade);
             this.add(currentPanel);
             this.setVisible(true);
         } else if (Objects.equals(panel, "ExpenseNamePanel")) {
             this.remove(currentPanel);
             currentPanel = new ExpenseNamePanel(this,facade);
             this.add(currentPanel);
             this.setVisible(true);
         } else if (Objects.equals(panel, "ViewGlobalBillPanel")) {
             this.remove(currentPanel);
             currentPanel = new ViewGlobalBillPanel(this,facade);
             this.add(currentPanel);
             this.setVisible(true);
         }
     }
}
