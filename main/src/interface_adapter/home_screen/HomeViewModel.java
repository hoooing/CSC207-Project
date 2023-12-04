package interface_adapter.home_screen;

import entity.Chat;
import entity.User;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class HomeViewModel extends ViewModel {
    public final String TITLE_LABEL = "Your Chats";

    public static final String CLOSE_BUTTON_LABEL = "Quit";

    public static final String NEW_MESSAGE_BUTTON_LABEL = "New Messages";

    public final String ADD_FRIEND_BUTTON_LABEL = "Add Friend";

    public final String LOGOUT_BUTTON_LABEL = "Logout";

    private HomeState homeState;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    public HomeViewModel() {
        super("home");
        // code to test homeview
        // todo: delete after complete
        Chat chat = new Chat("test1", "test1", new ArrayList<User>(), new ArrayList<String>());
        homeState = new HomeState();
        homeState.addChat(chat);
    }


    public HomeState getState() {
        return homeState;
    }

    public void setState(HomeState homeState) {
        this.homeState = homeState;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.homeState);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        //todo:
    }
}
