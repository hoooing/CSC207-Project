package use_case.chat;

import entity.Chat;
import entity.User;

import java.util.ArrayList;

public class ChatOutputData {
    private String chatID;

    private String chatName;

    private ArrayList<String> members;

    private ArrayList<String> chatHistory;

    private String username;

    public ChatOutputData(String chatID, String chatName, ArrayList<String> members, ArrayList<String> chatHistory, String username) {
        this.chatID = chatID;
        this.chatName = chatName;
        this.members = members;
        this.chatHistory = chatHistory;
        this.username = username;
    }

    public String getChatID() {
        return chatID;
    }

    public String getChatName() {
        return chatName;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public ArrayList<String> getChatHistory() {
        return chatHistory;
    }

    public String getUsername() {
        return username;
    }
}
