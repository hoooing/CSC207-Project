package interface_adapter.add_friend;

import use_case.add_friend.AddFriendInputBoundary;
import use_case.add_friend.AddFriendInputData;

public class AddFriendController {
    final AddFriendInputBoundary userAddFriendUseCaseInteractor;

    public AddFriendController(AddFriendInputBoundary userAddFriendUseCaseInteractor) {
        this.userAddFriendUseCaseInteractor = userAddFriendUseCaseInteractor;
    }

    public void execute(String friendName) {
        AddFriendInputData data = new AddFriendInputData(friendName);

        userAddFriendUseCaseInteractor.execute(data);
    }

}
