package use_case.delete_friend;

public interface DeleteFriendOutputBoundary {

    void prepareSuccessView(DeleteFriendOutputData outputData);

    void prepareFailView(String errorMessage);
}
