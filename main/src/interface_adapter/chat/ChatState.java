package interface_adapter.chat;

import interface_adapter.login.LoginState;

import java.util.ArrayList;

public class ChatState {
    private String chatID = "";
    private String messageError = null;

    ArrayList<String> messages = new ArrayList<>();

    public ChatState(ChatState copy) {
        chatID = copy.chatID;
        messageError = copy.messageError;
        messages = copy.messages;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public ChatState() {}

    public String getChatID() {
        return chatID;
    }

    public void setChatID(String chatID) {
        this.chatID = chatID;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public void addMessage(String message) {
        this.messages.add(message);
    }
}
