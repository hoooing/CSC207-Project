package data_access;

import entity.Chat;
import entity.User;
import entity.UserFactory;
import use_case.friend_manager.add_friend.AddFriendUserDataAccessInterface;
import use_case.chat.ChatDataAccessInterface;
import use_case.friend_manager.delete_friend.DeleteFriendUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FileUserDataAccessObject implements AddFriendUserDataAccessInterface,
        DeleteFriendUserDataAccessInterface, LoginUserDataAccessInterface,
        SignupUserDataAccessInterface, ChatDataAccessInterface {

    private final File csvUserFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, User> accounts = new LinkedHashMap<>();

    private UserFactory userFactory;


    public FileUserDataAccessObject(String csvPath, UserFactory userFactory) throws IOException {
        csvUserFile = new File(csvPath);
        this.userFactory = userFactory;
        headers.put("Username", 0);
        headers.put("Password", 1);
        headers.put("Creation_Time", 2);
        headers.put("Friends", 3);

        if (csvUserFile.length() == 0) {
            this.save();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(csvUserFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("Username,Password,Creation_Time,Friends");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("Username")]);
                    String password = String.valueOf(col[headers.get("Password")]);
                    String creationTimeText = String.valueOf(col[headers.get("Creation_Time")]);
                    //TODO - Figure out friend system.
                    String[] listFriends = col[headers.get("Friends")].split("/");
                    LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
                    User user = userFactory.createUser(username, password, ldt, new ArrayList<>(), new ArrayList<>());
                    accounts.put(username, user);
                }
            }
        }
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvUserFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                String listFriend = user.getFriends().stream().map(Object::toString)
                        .collect(Collectors.joining("/"));
                String line = String.format("%s,%s,%s,%s",
                        user.getUserName(), user.getUserName(), user.getCreationDate(), listFriend);
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    @Override
    public void save(User user) { accounts.put(user.getUserName(), user); }

    @Override
    public User get(String username) {
        return accounts.get(username);
    }

    @Override
    public Chat getChat(String chatID) {
        return null;
    }
}
