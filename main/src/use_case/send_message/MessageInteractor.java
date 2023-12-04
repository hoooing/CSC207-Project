package use_case.send_message;

import java.time.LocalDateTime;

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
        LocalDateTime timeStamp = messageInputData.getTimeStamp();
        if (messageDataAccessInterface.saveMessage(message, chatId, sender, timeStamp)) {
            MessageOutputData messageOutputData = new MessageOutputData(message, sender, timeStamp);
            messageOutputBoundary.prepareSuccessView(messageOutputData);
        }
        else {
            messageOutputBoundary.prepareFailView("Message not sent");
        }
    }
}
