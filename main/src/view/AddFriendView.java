package view;

import entity.ChatFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.chat.ChatViewModel;
import interface_adapter.create_chat.CreateChatController;
import interface_adapter.friend_manager.add_friend.AddFriendController;
import interface_adapter.friend_manager.add_friend.AddFriendState;
import interface_adapter.friend_manager.add_friend.AddFriendViewModel;
import interface_adapter.home_screen.HomeState;
import interface_adapter.home_screen.HomeViewModel;

import javax.swing.*;
import javax.swing.text.View;
import javax.xml.stream.FactoryConfigurationError;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class AddFriendView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Add Friend";

    private JLabel enter_username;

    private JTextField username;
    private JButton add;

    private JPanel top;

    private JPanel bottom;

    private JButton back;

    private JButton create_chat;

    private HomeViewModel homeViewModel;

    private AddFriendController addFriendController;

    private AddFriendViewModel addFriendViewModel;

    private ViewManagerModel viewManagerModel;

    private CreateChatController createChatController;


    public AddFriendView(AddFriendViewModel addFriendViewModel, AddFriendController addFriendController,
                         ViewManagerModel viewManagerModel, HomeViewModel homeViewModel, CreateChatController createChatController) {
        this.addFriendViewModel = addFriendViewModel;
        this.addFriendController = addFriendController;
        this.viewManagerModel = viewManagerModel;
        this.createChatController = createChatController;
        this.homeViewModel = homeViewModel;
        this.addFriendViewModel.addPropertyChangeListener(this);

        enter_username = new JLabel(addFriendViewModel.USERNAME_LABEL);
        add = new JButton(addFriendViewModel.ADD_FRIEND_BUTTON_LABEL);
        back = new JButton(addFriendViewModel.BACK_BUTTON_LABEL);
        username = new JTextField();
        username.setPreferredSize(new Dimension(150, username.getPreferredSize().height));
        create_chat = new JButton("Create Chat");
        create_chat.setVisible(false);

        top = new JPanel();
        top.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));

        top.add(enter_username);
        top.add(username);
        top.add(add);

        bottom = new JPanel();
        bottom.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));

        bottom.add(back);
        bottom.add(create_chat);

        this.setLayout(new GridLayout(4,1));

        this.add(new JPanel());
        this.add(top);
        this.add(bottom);

        back.addActionListener( new ActionListener(){
                                         public void actionPerformed(ActionEvent evt) {
                                             if (evt.getSource().equals(back)) {
                                                 viewManagerModel.setActiveView(homeViewModel.getViewName());
                                                 viewManagerModel.firePropertyChanged();

                                             }
                                         }
                                     }
        );

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(add)) {
                    String friend = username.getText();
                    addFriendViewModel.getState().setFriend(friend);
                    addFriendController.execute(friend, addFriendViewModel.getState().getUsername());
                }
            }
        });

        create_chat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(create_chat)) {
                    String friend = addFriendViewModel.getState().getFriend();
                    String user = addFriendViewModel.getState().getUsername();
                    String chatName = friend + "and" + user + " chat ";
                    createChatController.execute(chatName, new ArrayList<String>(List.of(new String[]{user, friend})));
                }
            }
        });

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        AddFriendState state = (AddFriendState) evt.getNewValue();
        if (state.getMessage() != null) {

            JOptionPane.showMessageDialog(this, state.getMessage());
            create_chat.setVisible(true);
        }


    }
}
