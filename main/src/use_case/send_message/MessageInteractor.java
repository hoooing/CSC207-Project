package use_case.send_message;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class MessageInteractor implements MessageInputBoundary{
    final MessageDataAccessInterface messageDataAccessInterface;

    final MessageOutputBoundary messageOutputBoundary;

    public MessageInteractor(MessageDataAccessInterface messageDataAccessInterface, MessageOutputBoundary messageOutputBoundary) {
        this.messageDataAccessInterface = messageDataAccessInterface;
        this.messageOutputBoundary = messageOutputBoundary;
    }

    @Override
    public void execute(MessageInputData messageInputData) {
        String message = messageInputData.getMessage();
        String sender = messageInputData.getSender();
        String chatId = messageInputData.getChatID();
        LocalDateTime timeStamp = messageInputData.getTimeStamp().truncatedTo(ChronoUnit.MINUTES);
        String newMessage = message + "\n" + "Sent by " + sender + " at " +
                timeStamp;
        if (messageDataAccessInterface.saveMessage(message, chatId)) {
            messageOutputBoundary.prepareSuccessView(newMessage);
        }
        else {
            messageOutputBoundary.prepareFailView("Message not sent");
        }
    }
}
