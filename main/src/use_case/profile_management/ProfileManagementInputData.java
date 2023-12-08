package use_case.profile_management;

public class ProfileManagementInputData {

    private final String username;
    private final String newPassword;
    private final String newEmail;
    private final String profilePicture;

    public ProfileManagementInputData(String username, String newPassword, String newEmail, String profilePicture) {
        this.username = username;
        this.newPassword = newPassword;
        this.newEmail = newEmail;
        this.profilePicture = profilePicture;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public String getProfilePicture() {
        return profilePicture;
    }
}
