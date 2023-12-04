package use_case.friend_manager.delete_friend;

import entity.User;

public class DeleteFriendInteractor implements DeleteFriendInputBoundary {

    final DeleteFriendUserDataAccessInterface userDataAccessInterface;
    final DeleteFriendOutputBoundary userPresenter;
    final User user;

    public DeleteFriendInteractor(DeleteFriendUserDataAccessInterface userDataAccessInterface,
                                  DeleteFriendOutputBoundary userPresenter, User user) {
        this.userDataAccessInterface = userDataAccessInterface;
        this.userPresenter = userPresenter;
        this.user = user;
    }

    @Override
    public void execute(DeleteFriendInputData deleteFriendInputData) {
        User userToAdd = userDataAccessInterface.get(deleteFriendInputData.getFriendUsername());
        if (!userDataAccessInterface.existsByName(deleteFriendInputData.getFriendUsername())) {
            userPresenter.prepareFailView("User does not exist! Please check the username that you want to delete!");
        } else if (!user.getFriends().contains(userToAdd)) {
            userPresenter.prepareFailView("User does not exist in your friend list.");
        } else {
            user.addFriend(userToAdd);
            DeleteFriendOutputData outputData = new DeleteFriendOutputData(true, userToAdd.getUserName());
            userPresenter.prepareSuccessView(outputData);
        }
    }
}
