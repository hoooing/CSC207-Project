package use_case.signup;

import entity.User;
import entity.UserFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SignupInteractor implements SignupInputBoundary{
    final SignupUserDataAccessInterface userDataAccessObject;
    final SignupOutputBoundary userPresenter;
    final UserFactory userFactory;

    public SignupInteractor(SignupUserDataAccessInterface signupDataAccessInterface,
                            SignupOutputBoundary signupOutputBoundary,
                            UserFactory userFactory) {
        this.userDataAccessObject = signupDataAccessInterface;
        this.userPresenter = signupOutputBoundary;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(SignupInputData signupInputData) {
        if (userDataAccessObject.existsByName(signupInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Passwords don't match.");
        } else {

            LocalDateTime now = LocalDateTime.now();
            User user = userFactory.createUser(signupInputData.getUsername(), signupInputData.getPassword(), now, new ArrayList<User>());
            userDataAccessObject.save(user);

            SignupOutputData signupOutputData = new SignupOutputData(user.getUserName(), now.toString(), false);
            userPresenter.prepareSuccessView(signupOutputData);
        }
    }
}
