package interface_adapter.add_friend;

import use_case.add_friend.AddFriendOutputBoundary;
import use_case.add_friend.AddFriendOutputData;

public class AddFriendPresenter implements AddFriendOutputBoundary {

//    private final AddFriendViewModel addFriendViewModel;
//    private

    @Override
    public void prepareSuccessView(AddFriendOutputData user) {

    }

    @Override
    public void prepareFailView(String errorMessage) {

    }
}
