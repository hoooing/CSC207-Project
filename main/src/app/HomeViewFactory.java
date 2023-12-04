package app;

import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.chat.ChatController;
import interface_adapter.chat.ChatPresenter;
import interface_adapter.chat.ChatViewModel;
import interface_adapter.friend_manager.add_friend.AddFriendViewModel;
import interface_adapter.home_screen.HomeViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.switch_view.SwitchController;
import use_case.chat.ChatDataAccessInterface;
import use_case.chat.ChatInputBoundary;
import use_case.chat.ChatInteractor;
import use_case.chat.ChatOutputBoundary;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginUserDataAccessInterface;
import view.HomeView;
import view.LoginView;

import javax.swing.*;
import java.io.IOException;

public class HomeViewFactory {
    private HomeViewFactory() {}

    public static HomeView create(
            HomeViewModel homeViewModel,
            ViewManagerModel viewManagerModel,
            ChatViewModel chatViewModel,
            ChatDataAccessInterface chatDataAccessInterface,
            AddFriendViewModel addFriendViewModel
            ) {

        try {
            ChatController chatController = createChatUseCase(homeViewModel, viewManagerModel, chatViewModel, chatDataAccessInterface);
            return new HomeView(homeViewModel, chatController, addFriendViewModel, viewManagerModel);
        } catch (IOException e) {
            //todo: update
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static ChatController createChatUseCase(HomeViewModel homeViewModel, ViewManagerModel viewManagerModel,
                                                    ChatViewModel chatViewModel, ChatDataAccessInterface chatDataAccessInterface)
            throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        ChatOutputBoundary chatOutputBoundary = new ChatPresenter(chatViewModel, viewManagerModel);


        ChatInputBoundary chatInteractor = new ChatInteractor(
                chatOutputBoundary, chatDataAccessInterface);

        return new ChatController(chatInteractor);
    }
}
