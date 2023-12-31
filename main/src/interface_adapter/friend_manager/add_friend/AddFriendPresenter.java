package interface_adapter.friend_manager.add_friend;

import use_case.friend_manager.add_friend.AddFriendOutputBoundary;
import use_case.friend_manager.add_friend.AddFriendOutputData;

public class AddFriendPresenter implements AddFriendOutputBoundary {

    private final AddFriendViewModel addFriendViewModel;

    public AddFriendPresenter(AddFriendViewModel viewModel) {
        this.addFriendViewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(AddFriendOutputData user) {
        AddFriendState state = addFriendViewModel.getState();
        String time = user.getAddedTime();
        String usernameAdded = user.getFriendName();
        String message = "User " + usernameAdded + " successfully deleted at " + time;

        state.setMessage(message);
        addFriendViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        AddFriendState state = addFriendViewModel.getState();
        state.setMessageError(errorMessage);
        addFriendViewModel.firePropertyChanged();

    }
}
