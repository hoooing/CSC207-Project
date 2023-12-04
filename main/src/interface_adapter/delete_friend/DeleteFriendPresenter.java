package interface_adapter.delete_friend;

import interface_adapter.add_friend.AddFriendState;
import interface_adapter.add_friend.AddFriendViewModel;
import use_case.add_friend.AddFriendOutputData;
import use_case.delete_friend.DeleteFriendOutputBoundary;
import use_case.delete_friend.DeleteFriendOutputData;

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
