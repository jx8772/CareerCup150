package chapter8.question7;
import java.util.ArrayList;

public abstract class Conversation {
    protected int id;
    protected ArrayList<User> participates = new ArrayList<User>();
    protected ArrayList<Message> messages = new ArrayList<Message>();

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public boolean addMessage(Message message) {
        messages.add(message);
        return true;
    }

    public int getId() {
        return id;
    }
}
