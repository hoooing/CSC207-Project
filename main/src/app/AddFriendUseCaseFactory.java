package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.chat.ChatViewModel;
import interface_adapter.create_chat.CreateChatController;
import interface_adapter.friend_manager.add_friend.AddFriendController;
import interface_adapter.friend_manager.add_friend.AddFriendPresenter;
import interface_adapter.friend_manager.add_friend.AddFriendViewModel;
import interface_adapter.home_screen.HomeViewModel;
import use_case.friend_manager.add_friend.AddFriendInputBoundary;
import use_case.friend_manager.add_friend.AddFriendInteractor;
import use_case.friend_manager.add_friend.AddFriendOutputBoundary;
import use_case.friend_manager.add_friend.AddFriendUserDataAccessInterface;
import view.AddFriendView;

public class AddFriendUseCaseFactory {

    private AddFriendUseCaseFactory() {}

    public static AddFriendView create(AddFriendViewModel addFriendViewModel, HomeViewModel homeViewModel,
                                       ViewManagerModel viewManagerModel, AddFriendUserDataAccessInterface addFriendUserDataAccessInterface,
                                       CreateChatController createChatController) {
        AddFriendController addFriendController = createController(addFriendViewModel, addFriendUserDataAccessInterface);
        return new AddFriendView(addFriendViewModel, addFriendController, viewManagerModel, homeViewModel, createChatController);
    }

    private static AddFriendController createController(AddFriendViewModel addFriendViewModel,
                                                        AddFriendUserDataAccessInterface addFriendUserDataAccessInterface) {

        AddFriendOutputBoundary addFriendPresenter = new AddFriendPresenter(addFriendViewModel);
        AddFriendInputBoundary addFriendInteractor = new AddFriendInteractor(addFriendUserDataAccessInterface, addFriendPresenter);
        return new AddFriendController(addFriendInteractor);
    }
}
