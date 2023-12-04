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

    public void execute(String chatName, String chatID) {

        //Chat chat = chatDataAccessInterface.getChat(chatID);
        // code to test chatview
        // todo: delete after complete
        Chat chat = new Chat("test1", "test1", new ArrayList<User>(), new ArrayList<String>());

        String name = chat.getChatName();
        String id = chat.getChatID();
        ArrayList<String> members  = new ArrayList<>();
        for (User user: chat.getMembers()) {
            members.add(user.getUserName());
        }
        ArrayList<String> messages = chat.getChatHistory();

        ChatOutputData chatOutputData = new ChatOutputData(name, id, members, messages);
        chatPresenter.prepareView(chatOutputData);
    }
}
