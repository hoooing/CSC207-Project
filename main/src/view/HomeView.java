package view;

import interface_adapter.home_screen.HomeViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class HomeView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "home view";

    private JLabel title;

    private JScrollPane chats;


    private final HomeViewModel homeViewModel;

    public HomeView(HomeViewModel homeViewModel) {
        this.homeViewModel = homeViewModel;
        JLabel title = new JLabel("Home");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel chatButtonPanel = new JPanel();
        chatButtonPanel.setLayout(new BoxLayout(chatButtonPanel, BoxLayout.Y_AXIS));

        // Add buttons to the panel (you can replace this loop with your logic to create buttons dynamically)
        ArrayList<String> toAdd = homeViewModel.getState().getChatNames();
        for (String chatName: toAdd) {
            JButton button = new JButton(chatName);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.addActionListener(new ButtonClickListener());
            chatButtonPanel.add(button);
        }

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        chats = new JScrollPane(chatButtonPanel);

        this.add(title);
        this.add(chats);



    }
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Button Clicked: " + e.getActionCommand());
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

}
