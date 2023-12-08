package use_case.profile_management;

import entity.User;

import java.util.List;

public class ProfileManagementOutputData {

    private final boolean updateStatus;
    private final String errorMessage;
    private final List<User> searchResults;

    public ProfileManagementOutputData(boolean updateStatus, String errorMessage, List<User> searchResults) {
        this.updateStatus = updateStatus;
        this.errorMessage = errorMessage;
        this.searchResults = searchResults;
    }

    // Getters
    public boolean isUpdateStatus() {
        return updateStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public List<User> getSearchResults() {
        return searchResults;
    }
}
