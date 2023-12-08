package use_case.profile_management;

import entity.User;
import java.util.List;

public interface ProfileManagementUserDataAccessInterface {

    User getUser(String username);

    void updateUser(User user);

    // Method to search for users by username
    List<User> searchByUsername(String username);
}
