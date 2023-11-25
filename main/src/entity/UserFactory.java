package entity;

import java.time.LocalDateTime;

public interface UserFactory {

    User createUser(String userName, String password, LocalDateTime creationTime);

}
