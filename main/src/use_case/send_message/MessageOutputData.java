package use_case.send_message;

import java.time.LocalDateTime;

public class MessageOutputData {
    private final String message;

    private final String sender;

    private final LocalDateTime timeStamp;


    public MessageOutputData(String message, String sender, LocalDateTime timeStamp) {
        this.message = message;
        this.sender = sender;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getSender() {
        return sender;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
