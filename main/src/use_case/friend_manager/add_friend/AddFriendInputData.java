package use_case.friend_manager.add_friend;

public class AddFriendInputData {

    final String friendUsername;

    final String username;

    public AddFriendInputData (String friendUsername, String username) {
        this.friendUsername = username;
        this.username = username;
    }

    String getFriendUsername() { return this.friendUsername;}

}
