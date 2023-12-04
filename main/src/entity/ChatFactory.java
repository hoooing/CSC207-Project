package entity;

import java.util.ArrayList;

public class ChatFactory{

    public Chat createChat(String chatID, String chatName, ArrayList<User> members) {
        return new Chat(chatID, chatName, members);
    }

    public GroupChat createChat(String chatID, String chatName, ArrayList<User> members, ArrayList<User> admins) {
        return new GroupChat(chatID, chatName, members, admins);
    }
}
