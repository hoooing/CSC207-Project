package app;

import data_access.FileChatsDataAccessObjects;
import data_access.FileUserDataAccessObject;
import entity.ChatFactory;
import entity.CommonUserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.chat.ChatViewModel;
import interface_adapter.create_chat.CreateChatController;
import interface_adapter.friend_manager.add_friend.AddFriendViewModel;
import interface_adapter.home_screen.HomeViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.switch_view.SwitchController;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        // The main application window.
        JFrame application = new JFrame("N2NChat");
        application.setBounds(100, 100, 400, 500);
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        application.add(views);
// temporary
        FileUserDataAccessObject userDataAccessObject;
        FileChatsDataAccessObjects chatDataAccessObject;
        try {
            chatDataAccessObject = new FileChatsDataAccessObjects("./chats.csv", new ChatFactory());
            userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory(), new ChatFactory(), chatDataAccessObject);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        SignupViewModel signupViewModel = new SignupViewModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        HomeViewModel homeViewModel = new HomeViewModel();
        ChatViewModel chatViewModel = new ChatViewModel();
        AddFriendViewModel addFriendViewModel = new AddFriendViewModel();
//        ProfileSetUpViewModel profileSetUpViewModel = new ProfileSetUpViewModel();
//        MainViewModel mainViewModel = new MainViewModel();

        SwitchController switchController = SwitchUseCaseFactory.create(viewManagerModel, signupViewModel, loginViewModel);

        CreateChatController createChatController = CreateChatControllerFactory.create(userDataAccessObject, chatDataAccessObject);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, homeViewModel, switchController, userDataAccessObject);
        views.add(loginView, loginView.viewName);

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, switchController, userDataAccessObject );
        views.add(signupView, signupView.viewName);

        HomeView homeView = HomeViewFactory.create(homeViewModel, viewManagerModel, chatViewModel, chatDataAccessObject
        , addFriendViewModel);
        views.add(homeView, homeView.viewName);

        ChatView chatView = ChatUseCaseFactory.create(chatViewModel, chatDataAccessObject);
        views.add(chatView, chatView.viewName);

        AddFriendView addFriendView = AddFriendUseCaseFactory.create(addFriendViewModel,
                homeViewModel, viewManagerModel, userDataAccessObject, createChatController);
        views.add(addFriendView, addFriendView.viewName);



// for testing views
        viewManagerModel.setActiveView(homeView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);

    }
}