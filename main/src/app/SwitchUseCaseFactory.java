package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.switch_view.SwitchController;
import interface_adapter.switch_view.SwitchPresenter;
import use_case.switch_view.SwitchInputBoundary;
import use_case.switch_view.SwitchInteractor;
import use_case.switch_view.SwitchOutputBoundary;
import view.LoginView;
import view.SignupView;

import javax.swing.text.View;

public class SwitchUseCaseFactory {
    private SwitchUseCaseFactory() {}

    public static SwitchController create(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel) {
        SwitchOutputBoundary switchOutputBoundary = new SwitchPresenter(viewManagerModel, signupViewModel, loginViewModel);
        SwitchInputBoundary switchInputBoundary = new SwitchInteractor(switchOutputBoundary);
        return new SwitchController(switchInputBoundary);
    }
}
