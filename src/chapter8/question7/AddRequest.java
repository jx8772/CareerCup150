package chapter8.question7;
import java.util.Date;

public class AddRequest {
    private User fromUser;
    private User toUser;
    private Date date;
    public RequestStatus status;

    public AddRequest(User from, User to, Date date) {
        fromUser = from;
        toUser = to;
        date = new Date();
        status = RequestStatus.Unread;
    }

    public User getFromUser() {
        return fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public Date getDate() {
        return date;
    }

    public RequestStatus getStatus() {
        return status;
    }
}
