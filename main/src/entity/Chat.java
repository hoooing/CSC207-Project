package entity;

import java.util.ArrayList;

public class Chat {
    private String chatID;

    private String chatName;

    private ArrayList<String> members;

    private ArrayList<String> chatHistory;

    public ArrayList<String> getChatHistory() {
        return chatHistory;
    }

    public void setChatHistory(ArrayList<String> chatHistory) {
        this.chatHistory = chatHistory;
    }

    public Chat(String chatID, String chatName, ArrayList<String> members, ArrayList<String> chatHistory) {
        this.chatID = chatID;
        this.chatName = chatName;
        this.members = members;
        this.chatHistory = chatHistory;
    }

    public String getChatID() {
        return chatID;
    }

    public void setChatID(String chatID) {
        this.chatID = chatID;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<String> members) {
        this.members = members;
    }

    public void addMessage(String message) {this.chatHistory.add(message);}
}
