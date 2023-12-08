package use_case.profile_management;

public interface ProfileManagementOutputBoundary {

    void presentUpdateResult(ProfileManagementOutputData outputData);

    void presentSearchResults(ProfileManagementOutputData outputData);
}
