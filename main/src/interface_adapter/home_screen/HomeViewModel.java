package interface_adapter.home_screen;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class HomeViewModel extends ViewModel {
    public final String TITLE_LABEL = "Your Chats";
    public ArrayList<String> CHAT_BUTTON_LABELS;

    public static final String CLOSE_BUTTON_LABEL = "Quit";

    public final String LOGOUT_BUTTON_LABEL = "Logout";

    private HomeState homeState = new HomeState();

    public HomeViewModel(ArrayList<String> CHAT_LABELS) {
        super("home");
        this.CHAT_BUTTON_LABELS = CHAT_LABELS;
    }

    public void addChat(String chat) {
        CHAT_BUTTON_LABELS.add(chat);
    }

    public HomeState getState() {
        return homeState;
    }

    public void setState(HomeState homeState) {
        this.homeState = homeState;
    }

    @Override
    public void firePropertyChanged() {
        //todo:

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        //todo:
    }
}
