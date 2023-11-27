package interface_adapter.switch_view;

import use_case.switch_view.SwitchInputBoundary;
public class SwitchController {
    final SwitchInputBoundary switchInteractor;

    public SwitchController(SwitchInputBoundary switchInteractor) {
        this.switchInteractor = switchInteractor;
    }

    public void execute(String switchTo) {

        switchInteractor.execute(switchTo);
    }
}
