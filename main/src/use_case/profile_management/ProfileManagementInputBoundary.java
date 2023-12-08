package use_case.profile_management;

public interface ProfileManagementInputBoundary {

    void updateProfile(ProfileManagementInputData inputData);

    void searchUser(String username);
}
