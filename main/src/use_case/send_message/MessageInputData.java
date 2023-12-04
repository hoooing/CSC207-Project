package use_case.send_message;

import java.time.LocalDateTime;

public class MessageInputData {

    String message;

    String chatID;

    String sender;

    LocalDateTime timeStamp;

    public MessageInputData(String message, String chatID, String sender, LocalDateTime timeStamp) {
        this.message = message;
        this.chatID = chatID;
        this.sender = sender;
        this.timeStamp = timeStamp;
    }

    String getMessage(){ return message;}

    String getChatID(){return chatID;}

    String getSender() {
        return sender;
    }

    LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
