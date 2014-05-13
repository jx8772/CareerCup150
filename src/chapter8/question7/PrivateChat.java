package chapter8.question7;

public class PrivateChat extends Conversation {
    public PrivateChat(User u1, User u2) {
        participates.add(u1);
        participates.add(u2);
    }

    public User getOtherParticipate(User primary) {
        if(participates.get(0).getId() == primary.getId()) {
            return participates.get(1);
        } else if(participates.get(1).getId() == primary.getId()) {
            return participates.get(0);
        }
        return null;
    }
}
