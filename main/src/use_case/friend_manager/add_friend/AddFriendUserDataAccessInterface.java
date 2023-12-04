package use_case.friend_manager.add_friend;

import entity.User;

public interface AddFriendUserDataAccessInterface {

    User get(String username);

    boolean existsByName(String identifier);

    boolean saveFriend(User user, User friend);

}
