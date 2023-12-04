package use_case.chat;

import entity.Chat;

public interface ChatDataAccessInterface {
    Chat getChat(String chatID);
}
