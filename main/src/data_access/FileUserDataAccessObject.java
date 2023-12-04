package data_access;

import entity.Chat;
import entity.ChatFactory;
import entity.User;
import entity.UserFactory;
import use_case.create_chat.UserDataAccess;
import use_case.friend_manager.add_friend.AddFriendUserDataAccessInterface;
import use_case.chat.ChatDataAccessInterface;
import use_case.friend_manager.delete_friend.DeleteFriendUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.send_message.MessageDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FileUserDataAccessObject implements AddFriendUserDataAccessInterface,
        DeleteFriendUserDataAccessInterface, LoginUserDataAccessInterface,
        SignupUserDataAccessInterface, UserDataAccess {

    private final File csvUserFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, User> accounts = new LinkedHashMap<>();

    private UserFactory userFactory;

    private ChatFactory chatFactory;

    private FileChatsDataAccessObjects chatsDataAccessObjects;


    public FileUserDataAccessObject(String csvPath, UserFactory userFactory,
                                    ChatFactory chatFactory,
                                    FileChatsDataAccessObjects chatsDataAccessObjects) throws IOException {
        csvUserFile = new File(csvPath);
        this.userFactory = userFactory;
        this.chatFactory = chatFactory;
        this.chatsDataAccessObjects = chatsDataAccessObjects;
        headers.put("Username", 0);
        headers.put("Password", 1);
        headers.put("Creation_Time", 2);
        headers.put("Friends", 3);
        headers.put("Chats", 4);

        if (csvUserFile.length() == 0) {
            this.save();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(csvUserFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("Username,Password,Creation_Time,Friends, Chats");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("Username")]);
                    String password = String.valueOf(col[headers.get("Password")]);
                    String creationTimeText = String.valueOf(col[headers.get("Creation_Time")]);
                    //TODO - Figure out friend system.
                    String[] listFriends = col[headers.get("Friends")].split("/");
                    String[] chatIDs = col[headers.get("Chats")].split("/");
                    LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
                    ArrayList<User> friends = new ArrayList<>();
                    for (String friendName: listFriends) {
                        User friend = this.get(friendName);
                        friends.add(friend);
                    }

                    ArrayList<Chat> chats = new ArrayList<>();

                    for (String chatID: chatIDs) {
                        Chat chat = chatsDataAccessObjects.getChat(chatID);
                        chats.add(chat);
                    }

                    User user = userFactory.createUser(username, password, ldt, friends, chats);
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
                ArrayList<String> friends = new ArrayList<>();
                for (User friend: user.getFriends()) {
                    friends.add(friend.getUserName());
                }

                String listFriend = String.join("/", friends);
                /*
                String listFriend = user.getFriends().stream().map(Object::toString)
                        .collect(Collectors.joining("/"));


                 */

                ArrayList<String> chats = new ArrayList<>();
                for (Chat chat: user.getChats()) {
                    chats.add(chat.getChatID());
                }

                String listChat = String.join("/", chats);

                String line = String.format("%s,%s,%s,%s,%s",
                        user.getUserName(), user.getUserName(), user.getCreationDate().toString(), listFriend, listChat);
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
    public void save(User user) {
        accounts.put(user.getUserName(), user);
        this.save();
    }

    @Override
    public User get(String username) {
        return accounts.get(username);
    }


}
