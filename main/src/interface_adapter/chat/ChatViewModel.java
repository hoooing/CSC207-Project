package interface_adapter.chat;

import entity.Chat;
import interface_adapter.ViewModel;
import interface_adapter.home_screen.HomeState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ChatViewModel extends ViewModel {

    public final String MESSAGE_BAR = "message...";


    public ChatState chatState = new ChatState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    public ChatViewModel() {
        super("chat");
    }

    public ChatState getState() {
        return chatState;
    }

    public void setState(ChatState chatState) {
        this.chatState = chatState;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.chatState);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
