package data_access;

import entity.Chat;
import entity.ChatFactory;
import entity.User;
import entity.UserFactory;
import use_case.chat.ChatDataAccessInterface;
import use_case.create_chat.CreateChatDataAccess;
import use_case.send_message.MessageDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class FileChatsDataAccessObjects implements ChatDataAccessInterface, MessageDataAccessInterface, CreateChatDataAccess {
    private final File csvChatFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, Chat> chats = new LinkedHashMap<>();

    private ChatFactory chatFactory;

    public FileChatsDataAccessObjects(String csvPath, ChatFactory chatFactory) throws IOException {
        csvChatFile = new File(csvPath);
        this.chatFactory = chatFactory;

        headers.put("Chat_ID", 0);
        headers.put("Chat_Name", 1);
        headers.put("Members", 2);
        headers.put("Chat_History", 3);

        if (csvChatFile.length() == 0) {
            this.save();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(csvChatFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("Chat_ID,Chat_Name,Members,Chat_History");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String chatId = String.valueOf(col[headers.get("Chat_ID")]);
                    String chatName = String.valueOf(col[headers.get("Chat_Name")]);

                    String[] listMembers = col[headers.get("Members")].split("/");
                    String[] listMessages = col[headers.get("Chat_History")].split("/");

                    ArrayList<String> members = new ArrayList<String>(Arrays.asList(listMembers));

                    ArrayList<String> messages = new ArrayList<String>(Arrays.asList(listMessages));

                    Chat chat = chatFactory.createChat(chatId, chatName, members, messages);
                    chats.put(chatId, chat);
                }
            }
        }
    }

    public void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvChatFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (Chat chat : chats.values()) {
                String listMember = String.join("/", chat.getMembers());

                String listMessages = String.join("/", chat.getChatHistory());

                String line = String.format("%s,%s,%s,%s",
                        chat.getChatID(), chat.getChatName(), listMember, listMessages);
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Chat getChat(String chatID) {
        // code to test chatview
        // todo: delete after complete
        return chats.get(chatID);
    }

    public void saveChat(Chat chat) {
        chats.put(chat.getChatID(), chat);
        this.save();
    }

    @Override
    public boolean saveMessage(String message, String chatID) {
        if (chats.containsKey(chatID)){
            Chat chat = chats.get(chatID);
            chat.addMessage(message);
            this.save();
            return true;
        } else {
            return false;
        }
    }

    public String getLast() {
        Set<String> keys = chats.keySet();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        for (String key: keys) {
            Integer id = Integer.parseInt(key);
            ids.add(id);
        }
        return Collections.max(ids).toString();
    }
}
