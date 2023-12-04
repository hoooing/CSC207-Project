package use_case.friend_manager.add_friend;

import entity.User;

import java.time.LocalDateTime;

public class AddFriendInteractor implements AddFriendInputBoundary{

    final AddFriendUserDataAccessInterface userDataAccessInterface;
    final AddFriendOutputBoundary userPresenter;
    final User user;

    public AddFriendInteractor(AddFriendUserDataAccessInterface AddFriendDataAccessInterface,
                               AddFriendOutputBoundary AddFriendOutputBoundary,
                               User user) {
        this.userDataAccessInterface = AddFriendDataAccessInterface;
        this.userPresenter = AddFriendOutputBoundary;
        this.user = user;
    }


    @Override
    public void execute(AddFriendInputData addFriendInputData) {
        User userToAdd = userDataAccessInterface.get(addFriendInputData.getFriendUsername());
        if (!userDataAccessInterface.existsByName(addFriendInputData.getFriendUsername())) {
            userPresenter.prepareFailView("User does not exist! Please check the Username!");
        } else if (user.getFriends().contains(userToAdd)){
            userPresenter.prepareFailView("User already exists in your friend list!");
        } else {
            user.addFriend(userToAdd);

            AddFriendOutputData outputData = new AddFriendOutputData(true, LocalDateTime.now().toString(), userToAdd.getUserName());
            userPresenter.prepareSuccessView(outputData);
        }
    }
}
