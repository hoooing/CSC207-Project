package view;

import entity.Chat;
import interface_adapter.ViewManagerModel;
import interface_adapter.chat.ChatState;
import interface_adapter.chat.ChatViewModel;
import interface_adapter.friend_manager.add_friend.AddFriendViewModel;
import interface_adapter.login.LoginState;
import interface_adapter.send_message.SendMesageController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;

public class ChatView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "chat";

    private JPanel top;

    private JLabel title;

    private JButton goBack;

    private JTextArea textArea;

    private JScrollPane texts;

    private JPanel bottom;
    private JLabel messageField;

    private JTextField message;

    private JButton send;

    private final ChatViewModel chatViewModel;

    private final SendMesageController sendMesageController;


    public ChatView(ChatViewModel chatViewModel, SendMesageController sendMesageController) {
        this.chatViewModel =chatViewModel;
        this.sendMesageController = sendMesageController;
        this.chatViewModel.addPropertyChangeListener(this);


        top = new JPanel();

        title = new JLabel("title");
        title.setFont(new Font(null, Font.BOLD, 15));

        goBack = new JButton(chatViewModel.RETURN);

        top.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));

        top.add(title);
        top.add(goBack);


        bottom = new JPanel();
        messageField = new JLabel(chatViewModel.MESSAGE_BAR);
        message = new JTextField();
        message.setPreferredSize(new Dimension(200, message.getPreferredSize().height));
        send = new JButton(chatViewModel.SEND);

        send.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(send)) {
                            ChatState currentState = chatViewModel.getState();
                            String chatID = currentState.getChatID();
                            String sender = currentState.getUsername();
                            LocalDateTime timeStamp = LocalDateTime.now();

                            sendMesageController.execute(message.getText(), chatID, sender, timeStamp);
                        }
                    }
                }
        );

        bottom.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));

        bottom.add(messageField);
        bottom.add(message);
        bottom.add(send);

        this.setLayout(new GridLayout(3,1));

        textArea = new JTextArea();
        textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        textArea.setLineWrap(true); // Enable line wrapping
        textArea.setWrapStyleWord(true); // Wrap at word boundaries
        textArea.setEditable(false);

        // Create a JScrollPane and add the textArea to it
        texts = new JScrollPane(textArea);

        this.add(top);
        this.add(texts);
        this.add(bottom);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ChatState state = (ChatState) evt.getNewValue();
        title.setText(state.getChatName());
        this.addMessages(state);
    }

    public void addMessages(ChatState state) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String message: state.getMessages()) {
            stringBuilder.append(message).append("\n");
        }

        textArea.setText(stringBuilder.toString());
    }
}
