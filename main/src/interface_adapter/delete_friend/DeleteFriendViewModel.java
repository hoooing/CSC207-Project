package interface_adapter.delete_friend;

import interface_adapter.ViewModel;
import interface_adapter.add_friend.AddFriendState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeleteFriendViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Delete Friend View";
    public static final String USERNAME_LABEL = "Type Friend's username you want to delete.";
    public static final String CONFIRM_BUTTON_LABEL = "Confirm";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    private DeleteFriendState state = new DeleteFriendState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public DeleteFriendViewModel() {super("Delete Friend");}

    public void setState(DeleteFriendState state) {
        this.state = state;
    }

    public DeleteFriendState getState() {return state;}

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
