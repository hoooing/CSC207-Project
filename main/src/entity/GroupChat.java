package entity;

import java.util.ArrayList;

public class GroupChat extends Chat{
    private ArrayList<User> admins;

    public GroupChat(String chatID, String chatName, ArrayList<String> members, ArrayList<String> chatHistory, ArrayList<User> admins) {
        super(chatID, chatName, members, chatHistory);
        this.admins = admins;
    }

    public ArrayList<User> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<User> admins) {
        this.admins = admins;
    }
}
