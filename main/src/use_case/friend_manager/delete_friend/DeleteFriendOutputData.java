package use_case.friend_manager.delete_friend;

public class DeleteFriendOutputData {

    private final boolean useCaseFailed;
    private final String deletedUsername;

    public DeleteFriendOutputData(boolean useCaseFailed, String deletedUsername) {
        this.useCaseFailed = useCaseFailed;
        this.deletedUsername = deletedUsername;
    }

    public String getDeletedUsername() {return deletedUsername;}
}
