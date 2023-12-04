package use_case.friend_manager.add_friend;

public interface AddFriendOutputBoundary {

    void prepareSuccessView(AddFriendOutputData user);

    void prepareFailView(String errorMessage);
}
