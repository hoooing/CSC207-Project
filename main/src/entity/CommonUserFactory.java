package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CommonUserFactory implements UserFactory {

    @Override
    public User createUser(String userName, String password, LocalDateTime creationTime, ArrayList<User> friends,  ArrayList<Chat> chats) {
        return new CommonUser(userName, password, creationTime, friends, chats);
    }
}
