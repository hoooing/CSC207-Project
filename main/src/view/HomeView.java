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
import interface_adapter.switch_view.SwitchController;

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

    private final JScrollPane chats;

    private final JButton logout;

    private final JButton addFriend;

    private final JButton close;

    private final JButton newMessages;

    private final JPanel chatButtonPanel;

    private final Map<JButton, String> buttonLog = new HashMap<>();

    private final HomeViewModel homeViewModel;


    private final ChatController chatController;

    private final AddFriendViewModel addFriendViewModel;

    private final ViewManagerModel viewManagerModel;

    private final SwitchController switchController;

    public HomeView(HomeViewModel homeViewModel,  ChatController chatController, AddFriendViewModel addFriendViewModel,
                    ViewManagerModel viewManagerModel, SwitchController switchController) {

        this.homeViewModel = homeViewModel;
        this.chatController = chatController;
        this.addFriendViewModel = addFriendViewModel;
        this.viewManagerModel = viewManagerModel;
        this.homeViewModel.addPropertyChangeListener(this);
        this.switchController = switchController;

        JLabel title = new JLabel("Home");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font(null, Font.BOLD, 15));

        chatButtonPanel = new JPanel();
        chatButtonPanel.setLayout(new BoxLayout(chatButtonPanel, BoxLayout.Y_AXIS));

        // Add buttons to the panel (you can replace this loop with your logic to create buttons dynamically)

        //todo: add rest of action listeners
        JPanel upperButtons = new JPanel();
        close = new JButton(HomeViewModel.CLOSE_BUTTON_LABEL);
        logout = new JButton(homeViewModel.LOGOUT_BUTTON_LABEL);
        addFriend = new JButton(homeViewModel.ADD_FRIEND_BUTTON_LABEL);
        newMessages = new JButton(HomeViewModel.NEW_MESSAGE_BUTTON_LABEL);

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

        close.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(close)) {
                            switchController.execute("close");
                        }
                    }
                }
        );



    }
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String chatName = e.getActionCommand();
            String chatId = buttonLog.get(e.getSource());
            System.out.println(chatId);
            chatController.execute(chatName, chatId, homeViewModel.getState().getUsername());
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(close)) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        HomeState state = (HomeState) evt.getNewValue();
        ArrayList<String[]> toAdd = state.getChats();
        for (String[] chatPair: toAdd) {
            JButton button = new JButton(chatPair[1]);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.addActionListener(new ButtonClickListener());
            chatButtonPanel.add(button);
            buttonLog.put(button, chatPair[0]);
        }
        chats.add(chatButtonPanel);
    }

}
