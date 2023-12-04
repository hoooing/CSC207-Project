package use_case.create_chat;

import entity.User;

public interface UserDataAccess {
    public User get(String username);

    public void save(User user);
}
