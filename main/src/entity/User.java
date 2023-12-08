package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface User {

    String getUserName();

    String getPassword();

    LocalDateTime getCreationDate();

    ArrayList<String> getFriends();

    void addChat(Chat chat);

    ArrayList<Chat> getChats();

    void addFriend(String friend);

    void setPassword(String newPassword);

    void setEmail(String newEmail);

    void setProfilePicture(String profilePicture);
}
