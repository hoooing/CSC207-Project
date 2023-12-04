package interface_adapter.chat;

import interface_adapter.login.LoginState;

import java.util.ArrayList;

public class ChatState {
    private String chatID = "";

    private String chatName = "";

    private ArrayList<String> participants = new ArrayList<>();
    private String messageError = null;

    ArrayList<String> messages = new ArrayList<>();

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public ChatState(ChatState copy) {
        this.chatID = copy.chatID;
        this.messageError = copy.messageError;
        this.messages = copy.messages;
        this.participants = copy.participants;
        this.chatName = copy.chatName;
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

    public void addParticipant(String participant) {this.participants.add(participant);}

    public ArrayList<String> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<String> participants) {
        this.participants = participants;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }
}
