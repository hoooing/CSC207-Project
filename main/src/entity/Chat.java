package entity;

import java.util.ArrayList;

public class Chat {
    private String chatID;

    private String chatName;

    private ArrayList<User> members;

    public Chat(String chatID, String chatName, ArrayList<User> members) {
        this.chatID = chatID;
        this.chatName = chatName;
        this.members = members;
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

    public ArrayList<User> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<User> members) {
        this.members = members;
    }
}
