package interface_adapter.chat;

import entity.Chat;
import entity.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import use_case.chat.ChatOutputBoundary;
import use_case.chat.ChatOutputData;

import java.util.ArrayList;

public class ChatPresenter implements ChatOutputBoundary {

    private final ChatViewModel chatViewModel;

    private final ViewManagerModel viewManagerModel;

    public ChatPresenter(ChatViewModel chatViewModel, ViewManagerModel viewManagerModel) {
        this.chatViewModel = chatViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareView(ChatOutputData chatOutputData) {



        String chatName = chatOutputData.getChatName();
        String chatID = chatOutputData.getChatID();
        ArrayList<String> participants = chatOutputData.getMembers();
        ArrayList<String> messageHistory = chatOutputData.getChatHistory();
        String username = chatOutputData.getUsername();


        ChatState curentState = chatViewModel.getState();
        curentState.setChatName(chatName);
        curentState.setChatID(chatID);
        curentState.setParticipants(participants);
        curentState.setMessages(messageHistory);
        curentState.setUsername(username);

        chatViewModel.setState(curentState);
        // todo: is this necessary?
        chatViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(chatViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
