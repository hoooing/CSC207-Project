package interface_adapter.home_screen;

import entity.Chat;

import java.util.ArrayList;

public class HomeStateBuilder {
    private HomeState homeState;

    public HomeStateBuilder(HomeState homeState) {
        this.homeState = homeState;
    }


    public void setChats(ArrayList<Chat> chats) {
        ArrayList<String[]> chatPairs =  new ArrayList<>();
        for (Chat chat: chats) {
            String[] chatPair = {chat.getChatID(), chat.getChatName()};
            chatPairs.add(chatPair);
        }
        homeState.setChats(chatPairs);
    }
}
