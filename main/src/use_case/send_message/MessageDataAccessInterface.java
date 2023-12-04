package use_case.send_message;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface MessageDataAccessInterface {
    boolean saveMessage(String message, String chatID);
}
