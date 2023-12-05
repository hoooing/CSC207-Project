package use_case.friend_manager.add_friend;

import entity.User;

import java.time.LocalDateTime;

public class AddFriendInteractor implements AddFriendInputBoundary{

    final AddFriendUserDataAccessInterface userDataAccessInterface;
    final AddFriendOutputBoundary userPresenter;


    public AddFriendInteractor(AddFriendUserDataAccessInterface AddFriendDataAccessInterface,
                               AddFriendOutputBoundary AddFriendOutputBoundary) {
        this.userDataAccessInterface = AddFriendDataAccessInterface;
        this.userPresenter = AddFriendOutputBoundary;
    }


    @Override
    public void execute(AddFriendInputData addFriendInputData) {
        User user = userDataAccessInterface.get(addFriendInputData.getFriendUsername());
        if (!userDataAccessInterface.existsByName(addFriendInputData.getFriendUsername())) {
            userPresenter.prepareFailView("User does not exist! Please check the Username!");
        } else {
            User userToAdd = userDataAccessInterface.get(addFriendInputData.getFriendUsername());
            if (user.getFriends().contains(userToAdd)){
                userPresenter.prepareFailView("User already exists in your friend list!");
            } else {
                user.addFriend(userToAdd.getUserName());
                userToAdd.addFriend(user.getUserName());

                userDataAccessInterface.save(user);
                userDataAccessInterface.save(userToAdd);

                AddFriendOutputData outputData = new AddFriendOutputData(true, LocalDateTime.now().toString(), userToAdd.getUserName());

                userPresenter.prepareSuccessView(outputData);
            }
        }
    }
}
