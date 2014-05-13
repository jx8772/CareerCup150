package chapter8.question7;

public class GroupChat extends Conversation {
    public void removeParticipate(User user) {
        participates.remove(user);
    }

    public void addParticipate(User user) {
        participates.add(user);
    }
}
