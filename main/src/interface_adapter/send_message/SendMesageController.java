package interface_adapter.send_message;

import use_case.send_message.MessageInputBoundary;
import use_case.send_message.MessageInputData;

import java.time.LocalDateTime;

public class SendMesageController {
    final MessageInputBoundary messageInteractor;

    public SendMesageController(MessageInputBoundary messageInteractor) {
        this.messageInteractor = messageInteractor;
    }

    public void execute(String message, String chatID, String sender, LocalDateTime timeStamp) {
        MessageInputData inputData = new MessageInputData(message, chatID, sender, timeStamp);
        messageInteractor.execute(inputData);
    }
}
