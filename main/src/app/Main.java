package app;

import data_access.FileUserDataAccessObject;
import entity.CommonUserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.chat.ChatViewModel;
import interface_adapter.home_screen.HomeViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.switch_view.SwitchController;
import view.HomeView;
import view.LoginView;
import view.SignupView;
import view.ViewManager;

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
        try {
            userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        SignupViewModel signupViewModel = new SignupViewModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        HomeViewModel homeViewModel = new HomeViewModel();
        ChatViewModel chatViewModel = new ChatViewModel();
//        ProfileSetUpViewModel profileSetUpViewModel = new ProfileSetUpViewModel();
//        MainViewModel mainViewModel = new MainViewModel();

        SwitchController switchController = SwitchUseCaseFactory.create(viewManagerModel, signupViewModel, loginViewModel);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, homeViewModel, switchController, userDataAccessObject);
        views.add(loginView, loginView.viewName);

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, switchController, userDataAccessObject );
        views.add(signupView, signupView.viewName);

        HomeView homeView = HomeViewFactory.create(homeViewModel, viewManagerModel, chatViewModel, userDataAccessObject);
        views.add(homeView, homeView.viewName);

        viewManagerModel.setActiveView(homeView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);

    }
}