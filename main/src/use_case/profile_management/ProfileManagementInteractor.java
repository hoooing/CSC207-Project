package use_case.profile_management;

import entity.User;
import data_access.ProfileManagementUserDataAccessInterface;

public class ProfileManagementInteractor implements ProfileManagementInputBoundary {

    private final ProfileManagementUserDataAccessInterface userDataAccessInterface;

    public ProfileManagementInteractor(ProfileManagementUserDataAccessInterface userDataAccessInterface) {
        this.userDataAccessInterface = userDataAccessInterface;
    }

    @Override
    public void updateProfile(ProfileManagementInputData inputData) {
        User user = userDataAccessInterface.getUser(inputData.getUsername());
        if (user != null) {
            // Update user details
            user.setPassword(inputData.getNewPassword());
            user.setEmail(inputData.getNewEmail());
            user.setProfilePicture(inputData.getProfilePicture());
            userDataAccessInterface.updateUser(user);
        }
        // Handle the case when user is not found or other business logic
    }

    @Override
    public void searchUser(String username) {
        User user = userDataAccessInterface.getUser(username);
        if (user != null) {
            // Return or process the found user
        }
        // Handle the case when user is not found
    }
}
