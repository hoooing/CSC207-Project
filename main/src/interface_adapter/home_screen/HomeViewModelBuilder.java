package interface_adapter.home_screen;

import entity.Chat;
import entity.User;

import java.util.ArrayList;

public class HomeViewModelBuilder {
    private final User user;

    public HomeViewModelBuilder(User user) {
        this.user = user;
    }

    public HomeViewModel build(User user) {
        ArrayList<String> chatLabels = new ArrayList<>();
        ArrayList<Chat> chats = user.getChats();
        for (Chat chat: chats) {
            chatLabels.add(chat.getChatName());
        }
        return new HomeViewModel(chatLabels);
    }
}
