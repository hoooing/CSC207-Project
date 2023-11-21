package entity;

import java.time.LocalDateTime;

public class CommonUser implements User {

    private final String userName;
    private final String password;
    private final LocalDateTime creationTime;

    CommonUser(String userName, String password, LocalDateTime creationTime){
        this.userName = userName;
        this.password = password;
        this.creationTime = creationTime;
    }

    @Override
    public String getUserName() {return userName;}

    @Override
    public String getUserPassword() {return password;}

    @Override
    public LocalDateTime getCreationDate() {return creationTime;}
}
