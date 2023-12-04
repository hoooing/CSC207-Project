package interface_adapter.chat;

import interface_adapter.login.LoginState;

import java.util.ArrayList;

public class ChatState {
    private String chatID = "";

    private ArrayList<String> participants = new ArrayList<>();
    private String messageError = null;

    ArrayList<String> messages = new ArrayList<>();

    public ArrayList<String> getParticipants() {
        return participants;
    }


    public void setParticipants(ArrayList<String> participants) {
        this.participants = participants;
    }

    public ChatState(ChatState copy) {
        chatID = copy.chatID;
        messageError = copy.messageError;
        messages = copy.messages;
        participants = copy.participants;
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
}
