package interface_adapter.friend_manager.delete_friend;

import use_case.friend_manager.delete_friend.DeleteFriendOutputBoundary;
import use_case.friend_manager.delete_friend.DeleteFriendOutputData;

public class DeleteFriendPresenter implements DeleteFriendOutputBoundary {

    private final DeleteFriendViewModel deleteFriendViewModel;

    public DeleteFriendPresenter(DeleteFriendViewModel viewModel) {
        this.deleteFriendViewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(DeleteFriendOutputData outputData) {
        DeleteFriendState state = deleteFriendViewModel.getState();
        String username = outputData.getDeletedUsername();
        String message = "Successfully deleted " + username + " from your friend list.";

        state.setMessage(message);
        deleteFriendViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        DeleteFriendState state = deleteFriendViewModel.getState();
        state.setMessageError(errorMessage);
        deleteFriendViewModel.firePropertyChanged();
    }
}
