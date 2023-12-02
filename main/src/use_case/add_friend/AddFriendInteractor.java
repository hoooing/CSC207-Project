package use_case.add_friend;

import entity.CommonUser;
import entity.User;

public class AddFriendInteractor implements AddFriendInputBoundary{

    final AddFriendUserDataAccessInterface userDataAccessInterface;
    final AddFriendOutputBoundary userPresenter;
    final User user;
    final User userToAdd;

    public AddFriendInteractor(AddFriendUserDataAccessInterface AddFriendDataAccessInterface,
                               AddFriendOutputBoundary AddFriendOutputBoundary,
                               User user, User userToAdd) {
        this.userDataAccessInterface = AddFriendDataAccessInterface;
        this.userPresenter = AddFriendOutputBoundary;
        this.user = user;
        this.userToAdd = userToAdd;
    }


    @Override
    public void execute(AddFriendInputData addFriendInputData) {

        if (!userDataAccessInterface.existsByName(addFriendInputData.getFriendUsername())) {
            userPresenter.prepareFailView("User does not exist! Please check the Username!");
        } else if (user.getFriends().contains(userToAdd)){
            userPresenter.prepareFailView("User already exists in your friend list!");
        } else {
            user.addFriend(userToAdd);

            AddFriendOutputData outputData = new AddFriendOutputData();
            //TODO - Make an output for friend add success view.
            userPresenter.prepareSuccessView(outputData);
        }

    }
}
