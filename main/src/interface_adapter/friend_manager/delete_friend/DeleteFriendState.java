package interface_adapter.friend_manager.delete_friend;

public class DeleteFriendState {

    private String message = "";
    private String messageError = null;

    public DeleteFriendState(DeleteFriendState copy) {
        this.message = copy.message;
        this.messageError = copy.messageError;
    }

    public DeleteFriendState() {}

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
