package interface_adapter.login;

import interface_adapter.home.HomeState;
import interface_adapter.home.HomeViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupState;
import use_case.login.LoginOutputData;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;
public class LoginPresenter {
    private final LoginViewModel loginViewModel;
    private final HomeViewModel homeViewModel;
    private ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          HomeViewModel homeViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.homeViewModel = homeViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        //  todo: Complete logged in Home page

        HomeState homeState = homeViewModel.getState();
        this.homeViewModel.setState(homeState);
        this.homeViewModel.firePropertyChanged();

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
