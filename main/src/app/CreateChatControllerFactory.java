package app;

import interface_adapter.create_chat.CreateChatController;
import use_case.create_chat.CreateChatDataAccess;
import use_case.create_chat.CreateChatIneractor;
import use_case.create_chat.CreateChatInputBoundary;
import use_case.create_chat.UserDataAccess;

public class CreateChatControllerFactory {
    private CreateChatControllerFactory() {}

    public static CreateChatController create(UserDataAccess userDataAccess, CreateChatDataAccess createChatDataAccess) {

        CreateChatInputBoundary createChatInteractor = new CreateChatIneractor(createChatDataAccess, userDataAccess);

        return new CreateChatController(createChatInteractor);
    }
}
