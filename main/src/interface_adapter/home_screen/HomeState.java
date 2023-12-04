package interface_adapter.home_screen;

import entity.Chat;

import java.util.ArrayList;
import java.util.HashMap;


public class HomeState {
    private String username = "";

    private ArrayList<String[]> chats = new ArrayList<>();


    public HomeState(HomeState copy) {
        this.username = copy.username;
        this.chats = copy.chats;
    }

    public HomeState(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void addChat(Chat chat) {
        String[] chatPair = {chat.getChatID(), chat.getChatName()};
        chats.add(chatPair);
    }


    public ArrayList<String[]> getChats() {
        return chats;
    }

    public void setChats(ArrayList<String[]> chats) {
        this.chats = chats;
    }
}
