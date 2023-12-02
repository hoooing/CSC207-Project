package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CommonUser implements User {

    private final String userName;
    private final String password;
    private final LocalDateTime creationTime;

    private ArrayList<User> friends;

    CommonUser(String userName, String password, LocalDateTime creationTime, ArrayList<User> friends){
        // todo: update userfactory
        this.userName = userName;
        this.password = password;
        this.creationTime = creationTime;
        this.friends = friends;
    }

    @Override
    public String getUserName() {return userName;}

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUserPassword() {return password;}

    @Override
    public LocalDateTime getCreationDate() {return creationTime;}

    public ArrayList<User> getFriends() {return friends;}

    public void addFriend(User friend) {this.friends.add(friend);}
}
