package interface_adapter.send_message;

import interface_adapter.ViewManagerModel;
import interface_adapter.chat.ChatState;
import interface_adapter.chat.ChatViewModel;
import use_case.send_message.MessageOutputBoundary;
import use_case.send_message.MessageOutputData;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SendMessagePresenter implements MessageOutputBoundary {
    private final ChatViewModel chatViewModel;


    public SendMessagePresenter(ChatViewModel chatViewModel) {
        this.chatViewModel = chatViewModel;
    }

    @Override
    public void prepareSuccessView(String message) {
        ChatState chatState = chatViewModel.getState();
        chatState.addMessage(message);
        chatViewModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error) {
        ChatState chatState = chatViewModel.getState();
        chatState.setMessageError(error);
        chatViewModel.firePropertyChanged();

    }
}
