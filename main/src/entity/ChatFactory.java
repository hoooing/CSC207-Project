package entity;

import java.util.ArrayList;

public class ChatFactory{

    public Chat createChat(String chatID, String chatName, ArrayList<User> members, ArrayList<String> chatHistory) {
        return new Chat(chatID, chatName, members, chatHistory);
    }

    public GroupChat createChat(String chatID, String chatName, ArrayList<User> members, ArrayList<String> chatHistory, ArrayList<User> admins) {
        return new GroupChat(chatID, chatName, members, chatHistory, admins);
    }
}
