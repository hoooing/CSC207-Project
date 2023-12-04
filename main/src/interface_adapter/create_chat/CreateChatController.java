package interface_adapter.create_chat;

import use_case.create_chat.CreateChatInputBoundary;

import java.util.ArrayList;

public class CreateChatController {
    final CreateChatInputBoundary createChatInteractor;

    public CreateChatController(CreateChatInputBoundary createChatInteractor) {
        this.createChatInteractor = createChatInteractor;
    }

    public void execute(String chatName, ArrayList<String> members) {
        createChatInteractor.execute(chatName, members);
    }
}
