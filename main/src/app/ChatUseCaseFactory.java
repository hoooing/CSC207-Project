package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.chat.ChatController;
import interface_adapter.chat.ChatPresenter;
import interface_adapter.chat.ChatViewModel;
import interface_adapter.friend_manager.add_friend.AddFriendViewModel;
import interface_adapter.home_screen.HomeViewModel;
import interface_adapter.send_message.SendMessageController;
import interface_adapter.send_message.SendMessagePresenter;
import use_case.chat.ChatDataAccessInterface;
import use_case.chat.ChatInputBoundary;
import use_case.chat.ChatInteractor;
import use_case.chat.ChatOutputBoundary;
import use_case.send_message.MessageDataAccessInterface;
import use_case.send_message.MessageInputBoundary;
import use_case.send_message.MessageInteractor;
import use_case.send_message.MessageOutputBoundary;
import view.ChatView;
import view.HomeView;

import javax.swing.*;
import java.io.IOException;

public class ChatUseCaseFactory {

    private ChatUseCaseFactory() {}

    public static ChatView create(ChatViewModel chatViewModel, MessageDataAccessInterface messageDataAccessInterface) {
        try {
            SendMessageController sendMessageController = createMessageController(chatViewModel, messageDataAccessInterface );
            return new ChatView(chatViewModel, sendMessageController);
        } catch (IOException e) {
            //todo: update
            JOptionPane.showMessageDialog(null, "Could not open chat data file.");
        }

        return null;
    }

    private static SendMessageController createMessageController(ChatViewModel chatViewModel, MessageDataAccessInterface messageDataAccessInterface)
            throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        MessageOutputBoundary messagePresenter = new SendMessagePresenter(chatViewModel);


        MessageInputBoundary messageInteractor = new MessageInteractor(messageDataAccessInterface, messagePresenter);

        return new SendMessageController(messageInteractor);
    }
}
