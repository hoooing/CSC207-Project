package use_case.chat;

import entity.Chat;
import entity.User;

import java.util.ArrayList;

public class ChatInteractor implements ChatInputBoundary {

    private final ChatDataAccessInterface chatDataAccessInterface;

    private final ChatOutputBoundary chatPresenter;

    public ChatInteractor(ChatOutputBoundary chatPresenter, ChatDataAccessInterface chatDataAccessInterface) {
        this.chatPresenter = chatPresenter;
        this.chatDataAccessInterface = chatDataAccessInterface;
    }

    public void execute(String chatName, String chatID, String username) {

        Chat chat = chatDataAccessInterface.getChat(chatID);

        String name = chat.getChatName();
        String id = chat.getChatID();
        ArrayList<String> members  = chat.getMembers();
        ArrayList<String> messages = chat.getChatHistory();


        ChatOutputData chatOutputData = new ChatOutputData(id, name, members, messages, username);
        chatPresenter.prepareView(chatOutputData);
    }
}
