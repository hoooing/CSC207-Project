package use_case.send_message;

import use_case.login.LoginOutputData;

public interface MessageOutputBoundary {
    void prepareSuccessView(String message);

    void prepareFailView(String error);
}
