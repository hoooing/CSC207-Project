package use_case.friend_manager.add_friend;

public class AddFriendOutputData {

    private boolean useCaseFailed;
    private final String addedTime;
    private final String friendName;

    public AddFriendOutputData(boolean useCaseFailed, String addedTime, String friendName) {
        this.useCaseFailed = useCaseFailed;
        this.addedTime = addedTime;
        this.friendName = friendName;
    }

    public String getAddedTime() {return addedTime;}

    public String getFriendName() {return friendName;}

}
