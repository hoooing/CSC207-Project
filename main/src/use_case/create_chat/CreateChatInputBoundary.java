package use_case.create_chat;

import java.util.ArrayList;

public interface CreateChatInputBoundary {
    void execute(String chatName, ArrayList<String> members);
}
