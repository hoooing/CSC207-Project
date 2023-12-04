package interface_adapter.chat;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ChatViewModel extends ViewModel {

    public final String MESSAGE_BAR = "message...";

    public final String RETURN = "return";

    public final String SEND = "send";


    public ChatState chatState;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    public ChatViewModel() {
        super("chat");
        this.chatState = new ChatState();
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
