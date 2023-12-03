package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;

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

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        InitialViewModel initialViewModel = new InitialViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        ProfileSetUpViewModel profileSetUpViewModel = new ProfileSetUpViewModel();
        MainViewModel mainViewModel = new MainViewModel();

        application.pack();
        application.setVisible(true);

    }
}
