package interface_adapter.chat;

import use_case.chat.ChatInputBoundary;

public class ChatController {
    //todo: in the future can add input data class for this use case containing user to check if chat is valid
    final ChatInputBoundary chatInteractor;
    public ChatController(ChatInputBoundary chatInteractor) {
        this.chatInteractor = chatInteractor;
    }

    public void execute(String chatName, String chatID) {
        chatInteractor.execute(chatName, chatID);
    }
}
