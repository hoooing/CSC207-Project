package interface_adapter.login;

import interface_adapter.home_screen.HomeState;
import interface_adapter.home_screen.HomeViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.home_screen.HomeViewModelBuilder;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {
    private final LoginViewModel loginViewModel;

    private final HomeViewModelBuilder homeViewModelBuilder;
    private final HomeViewModel homeViewModel;
    private ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          HomeViewModel homeViewModel,
                          LoginViewModel loginViewModel, HomeViewModelBuilder homeViewModelBuilder) {
        this.viewManagerModel = viewManagerModel;
        this.homeViewModel = homeViewModel;
        this.loginViewModel = loginViewModel;
        this.homeViewModelBuilder = homeViewModelBuilder;
    }

    @Override
    public void prepareSuccessView(LoginOutputData user) {
        // On success, switch to the home view.
        homeViewModelBuilder.build(user.getUser());

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
