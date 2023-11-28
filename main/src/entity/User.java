package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface User {

    String getUserName();

    String getUserPassword();

    LocalDateTime getCreationDate();

    ArrayList<User> getFriends();

    void addFriend(User friend);
}
