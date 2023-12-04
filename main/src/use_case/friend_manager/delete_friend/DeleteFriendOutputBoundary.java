package use_case.friend_manager.delete_friend;

public interface DeleteFriendOutputBoundary {

    void prepareSuccessView(DeleteFriendOutputData outputData);

    void prepareFailView(String errorMessage);
}
