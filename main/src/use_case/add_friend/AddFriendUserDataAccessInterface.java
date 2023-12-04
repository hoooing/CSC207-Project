package use_case.add_friend;

import entity.User;

public interface AddFriendUserDataAccessInterface {

    User get(String username);

    boolean existsByName(String identifier);

}
