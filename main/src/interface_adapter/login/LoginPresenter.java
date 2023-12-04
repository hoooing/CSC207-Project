package interface_adapter.login;

import interface_adapter.home_screen.HomeState;
import interface_adapter.home_screen.HomeStateBuilder;
import interface_adapter.home_screen.HomeViewModel;
import interface_adapter.ViewManagerModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {
    private final LoginViewModel loginViewModel;

    private final HomeViewModel homeViewModel;
    private ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          HomeViewModel homeViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
        this.homeViewModel = homeViewModel;
    }
    @Override
    public void prepareSuccessView(LoginOutputData user) {
        // On success, switch to the home view.

        HomeState homeState = homeViewModel.getState();
        HomeStateBuilder homeStateBuilder = new HomeStateBuilder(homeState);
        homeState.setUsername(user.getUser().getUserName());
        homeStateBuilder.setChats(user.getUser().getChats());
        homeViewModel.setState(homeState);
        homeViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(homeViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(error);
        loginViewModel.firePropertyChanged();
    }
}
