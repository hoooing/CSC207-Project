package interface_adapter.friend_manager.delete_friend;

import use_case.friend_manager.delete_friend.DeleteFriendInputBoundary;
import use_case.friend_manager.delete_friend.DeleteFriendInputData;

public class DeleteFriendController {

    final DeleteFriendInputBoundary userUseCaseInteractor;

    public DeleteFriendController(DeleteFriendInputBoundary userUseCaseInteractor) {
        this.userUseCaseInteractor = userUseCaseInteractor;
    }

    public void execute(String friendName) {
        DeleteFriendInputData data = new DeleteFriendInputData(friendName);
        userUseCaseInteractor.execute(data);
    }
}
