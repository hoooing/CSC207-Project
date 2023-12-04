package interface_adapter.delete_friend;

import use_case.delete_friend.DeleteFriendInputBoundary;
import use_case.delete_friend.DeleteFriendInputData;

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
