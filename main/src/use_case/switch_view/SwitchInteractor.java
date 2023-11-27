package use_case.switch_view;

import use_case.switch_view.SwitchOutputBoundary;
public class SwitchInteractor implements SwitchInputBoundary{
    final SwitchOutputBoundary switchPresenter;

    public SwitchInteractor(SwitchOutputBoundary switchPresenter) {
        this.switchPresenter = switchPresenter;
    }

    public void execute(String switchTo) {
        if (switchTo.equals("login")) {
            switchPresenter.prepareLoginView();
        } else if (switchTo.equals("signup")) {
            switchPresenter.prepareSignupView();
        }
    }
}
