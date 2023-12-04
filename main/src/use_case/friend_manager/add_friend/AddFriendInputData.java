package use_case.friend_manager.add_friend;

public class AddFriendInputData {

    final String friendUsername;

    public AddFriendInputData (String username) {
        this.friendUsername = username;
    }

    String getFriendUsername() { return this.friendUsername;}

}
