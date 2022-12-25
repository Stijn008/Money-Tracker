package Visual;

import Facade.Facade;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFriendPanel extends JPanel {
    private JButton add;
    private JButton remove;
    private JButton back;
    private Facade facade ;
    private GUI gui;
    private JTextField enterName;
    public AddFriendPanel(GUI gui, Facade facade) {
        this.facade = facade;
        this.setLayout(new BoxLayout(this , BoxLayout.PAGE_AXIS));
        this.setBorder(new EmptyBorder(new Insets(340, 150, 200, 150)));
        this.gui = gui;
        JLabel label = new JLabel("Enter friend name");
        ButtonListenerAF listen = new ButtonListenerAF();
        this.add = new JButton("Add");
        add.addActionListener(listen);
        this.remove = new JButton("Remove");
        remove.addActionListener(listen);
        this.back = new JButton("Back");
        back.addActionListener(listen);
        this.enterName = new JTextField();
        this.add(label);
        this.add(this.enterName);
        this.add(this.add);
        this.add(this.remove);
        this.add(this.back);
    }
    private class ButtonListenerAF implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == add) {
                try {
                    System.out.println("Added "+enterName.getText()+" to friends");
                    facade.addFriend(enterName.getText());
                    enterName.setText("");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            } else if (event.getSource() == remove){
                try {
                    System.out.println("Removed "+enterName.getText()+" from friends");
                    facade.removeFriend(enterName.getText());
                    enterName.setText("");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            } else if (event.getSource() == back) {
                gui.changePanel("MenuPanel");
            }
        }

    }

}
