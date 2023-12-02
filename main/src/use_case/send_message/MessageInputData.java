package use_case.send_message;

import java.time.LocalDateTime;

public class MessageInputData {

    String message;

    String chatID;

    String recipient;

    LocalDateTime timeStamp;

    public MessageInputData(String message, String chatID, String recipient, LocalDateTime timeStamp) {
        this.message = message;
        this.chatID = chatID;
        this.recipient = recipient;
        this.timeStamp = timeStamp;
    }

    String getMessage(){ return message;}

    String getChatID(){return chatID;}

    String getRecipient() {
        return recipient;
    }

    LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
