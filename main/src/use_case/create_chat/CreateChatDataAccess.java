package use_case.create_chat;

import entity.Chat;

public interface CreateChatDataAccess {
    public String getLast();

    public void saveChat(Chat chat);
}
