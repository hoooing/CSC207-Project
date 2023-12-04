package interface_adapter.add_friend;

public class AddFriendState {

    private String message = "";
    private String messageError = null;

    public AddFriendState(AddFriendState copy) {
        this.message = copy.message;
        this.messageError = copy.messageError;
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
}
