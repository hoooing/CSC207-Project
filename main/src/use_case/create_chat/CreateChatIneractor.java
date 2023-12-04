package use_case.create_chat;

import entity.Chat;
import entity.ChatFactory;
import entity.User;

import java.util.ArrayList;

public class CreateChatIneractor implements CreateChatInputBoundary{
    final CreateChatDataAccess createChatDataAccess;

    final UserDataAccess userDataAccess;

    public CreateChatIneractor(CreateChatDataAccess createChatDataAccess, UserDataAccess userDataAccess) {
        this.createChatDataAccess = createChatDataAccess;
        this.userDataAccess = userDataAccess;

    }
    @Override
    public void execute(String chatName, ArrayList<String> members) {
        ChatFactory chatFactory = new ChatFactory();

        String chatID = createChatDataAccess.getLast();
        Chat chat = chatFactory.createChat(chatID, chatName, members, new ArrayList<String>());
        createChatDataAccess.saveChat(chat);
        User user1 = userDataAccess.get(members.get(0));
        user1.addChat(chat);
        userDataAccess.save(user1);
        User user2 = userDataAccess.get(members.get(1));
        user2.addChat(chat);
        userDataAccess.save(user2);

    }
}
