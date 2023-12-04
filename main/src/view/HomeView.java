package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.chat.ChatController;
import interface_adapter.chat.ChatState;
import interface_adapter.chat.ChatViewModel;
import interface_adapter.friend_manager.add_friend.AddFriendController;
import interface_adapter.friend_manager.add_friend.AddFriendState;
import interface_adapter.friend_manager.add_friend.AddFriendViewModel;
import interface_adapter.home_screen.HomeState;
import interface_adapter.home_screen.HomeViewModel;
import interface_adapter.login.LoginState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HomeView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "home";

    private JLabel title;

    private JScrollPane chats;

    private  JButton logout;

    private JButton addFriend;

    private JButton close;

    private JButton newMessages;

    private JPanel chatButtonPanel;

    private Map<JButton, String> buttonLog = new HashMap<>();

    private final HomeViewModel homeViewModel;


    private final ChatController chatController;

    private final AddFriendViewModel addFriendViewModel;

    private final ViewManagerModel viewManagerModel;

    public HomeView(HomeViewModel homeViewModel,  ChatController chatController, AddFriendViewModel addFriendViewModel,
                    ViewManagerModel viewManagerModel) {

        this.homeViewModel = homeViewModel;
        this.chatController = chatController;
        this.addFriendViewModel = addFriendViewModel;
        this.viewManagerModel = viewManagerModel;

        JLabel title = new JLabel("Home");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font(null, Font.BOLD, 15));

        chatButtonPanel = new JPanel();
        chatButtonPanel.setLayout(new BoxLayout(chatButtonPanel, BoxLayout.Y_AXIS));

        // Add buttons to the panel (you can replace this loop with your logic to create buttons dynamically)
        // todo: delete after testing
        ArrayList<String[]> toAdd = homeViewModel.getState().getChats();
        for (String[] chatPair: toAdd) {
            JButton button = new JButton(chatPair[1]);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.addActionListener(new ButtonClickListener());
            chatButtonPanel.add(button);
            buttonLog.put(button, chatPair[0]);
        }

        //todo: add rest of action listeners
        JPanel upperButtons = new JPanel();
        close = new JButton(homeViewModel.CLOSE_BUTTON_LABEL);
        logout = new JButton(homeViewModel.LOGOUT_BUTTON_LABEL);
        addFriend = new JButton(homeViewModel.ADD_FRIEND_BUTTON_LABEL);
        newMessages = new JButton(homeViewModel.NEW_MESSAGE_BUTTON_LABEL);

        upperButtons.add(addFriend);
        upperButtons.add(newMessages);
        upperButtons.add(logout);
        upperButtons.add(close);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        chats = new JScrollPane(chatButtonPanel);

        this.add(title);
        this.add(upperButtons);
        this.add(chats);

        addFriend.addActionListener( new ActionListener(){
                                         public void actionPerformed(ActionEvent evt) {
                                             if (evt.getSource().equals(addFriend)) {
                                                 HomeState currentState = homeViewModel.getState();
                                                 String user = currentState.getUsername();
                                                 AddFriendState state = addFriendViewModel.getState();
                                                 state.setUsername(user);
                                                 viewManagerModel.setActiveView(addFriendViewModel.getViewName());
                                                 viewManagerModel.firePropertyChanged();

                                             }
                                         }
                                     }
        );



    }
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String chatName = e.getActionCommand();
            String chatId = buttonLog.get(e);
            chatController.execute(chatName, chatId, homeViewModel.getState().getUsername());
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        HomeState state = (HomeState) evt.getNewValue();
        ArrayList<String[]> toAdd = homeViewModel.getState().getChats();
        for (String[] chatPair: toAdd) {
            JButton button = new JButton(chatPair[1]);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.addActionListener(new ButtonClickListener());
            chatButtonPanel.add(button);
            buttonLog.put(button, chatPair[0]);
        }
    }

}
