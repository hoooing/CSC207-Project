package use_case.add_friend;

public interface AddFriendOutputBoundary {

    void prepareSuccessView(AddFriendOutputData user);

    void prepareFailView(String errorMessage);
}
