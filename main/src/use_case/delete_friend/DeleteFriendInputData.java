package use_case.delete_friend;

public class DeleteFriendInputData {

    final String friendUsername;

    public DeleteFriendInputData(String friendUsername) {
        this.friendUsername = friendUsername;
    }

    String getFriendUsername() {return friendUsername;}
}
