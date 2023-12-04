package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface UserFactory {

    User createUser(String userName, String password, LocalDateTime creationTime, ArrayList<User> friends, ArrayList<Chat> chats);

}
