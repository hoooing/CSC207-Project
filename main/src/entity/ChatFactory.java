package entity;

import java.util.ArrayList;

public class ChatFactory{

    public Chat createChat(String chatID, String chatName, ArrayList<String> members, ArrayList<String> chatHistory) {
        return new Chat(chatID, chatName, members, chatHistory);
    }
}
