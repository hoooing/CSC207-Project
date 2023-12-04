package use_case.delete_friend;

import entity.User;

public interface DeleteFriendUserDataAccessInterface {

    User get(String username);

    boolean existsByName(String identifier);


}
