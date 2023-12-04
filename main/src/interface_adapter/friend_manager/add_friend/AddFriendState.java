package interface_adapter.friend_manager.add_friend;

public class AddFriendState {

    private String username = "";
    private String message = "";
    private String messageError = null;

    public AddFriendState(AddFriendState copy) {
        this.message = copy.message;
        this.messageError = copy.messageError;
        this.username = copy.username;
    }

    public AddFriendState() {}

    public String getMessage() {
        return message;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
