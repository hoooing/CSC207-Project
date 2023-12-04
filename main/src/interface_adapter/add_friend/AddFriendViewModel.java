package interface_adapter.add_friend;

import interface_adapter.ViewModel;
import interface_adapter.signup.SignupState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddFriendViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Add Friend View";
    public static final String USERNAME_LABEL = "Type Username you want to add to your friend.";
    public static final String ADD_FRIEND_BUTTON_LABEL = "Add Friend";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

//    private SignupState state = new SignupState();
    private AddFriendState state = new AddFriendState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public AddFriendViewModel() {super("Add Friend");}

    public void setState(AddFriendState state) {
        this.state = state;
    }

    public AddFriendState getState() {return state;}

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
