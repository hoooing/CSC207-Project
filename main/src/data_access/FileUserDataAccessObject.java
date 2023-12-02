package data_access;

import entity.User;
import entity.UserFactory;
import use_case.add_friend.AddFriendUserDataAccessInterface;
import use_case.delete_friend.DeleteFriendUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileUserDataAccessObject implements AddFriendUserDataAccessInterface,
        DeleteFriendUserDataAccessInterface, LoginUserDataAccessInterface,
        SignupUserDataAccessInterface {

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

        if (csvUserFile.length() == 0) {
            this.save();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(csvUserFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("Username,Password,Creation_Time");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("Username")]);
                    String password = String.valueOf(col[headers.get("Password")]);
                    String creationTimeText = String.valueOf(col[headers.get("Creation_Time")]);
                    LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
                    User user = userFactory.createUser(username, password, ldt);
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
                String line = String.format("%s,%s,%s",
                        user.getUserName(), user.getUserName(), user.getCreationDate());
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
}
