package use_case.send_message;

public class MessageOutputData {
    private final String message;

    private boolean useCaseFailed;

    public MessageOutputData(String message, Boolean useCaseFailed) {
        this.message = message;
        this.useCaseFailed = useCaseFailed;
    }

    public String getMessage() {
        return message;
    }
}
