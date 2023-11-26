package entity;

import java.time.LocalDateTime;

public class CommonUserFactory implements UserFactory {

    @Override
    public User createUser(String userName, String password, LocalDateTime creationTime) {
        return new CommonUser(userName, password, creationTime);
    }
}