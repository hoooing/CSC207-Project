package use_case.friend_manager.delete_friend;

public class DeleteFriendInputData {

    final String friendUsername;

    public DeleteFriendInputData(String friendUsername) {
        this.friendUsername = friendUsername;
    }

    String getFriendUsername() {return friendUsername;}
}
