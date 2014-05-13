package chapter8.question7;

public class UserStatus {
    private String message;
    private UserStatusType type;

    public UserStatus(String message, UserStatusType type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public UserStatusType getUserStatusType() {
        return type;
    }
}
