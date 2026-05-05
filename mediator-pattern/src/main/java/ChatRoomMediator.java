import java.util.*;

public class ChatRoomMediator implements ChatMediator {

    private final Map<String, ChatClientController> clients = new HashMap<>();

    @Override
    public void registerClient(ChatClientController client) {
        clients.put(client.getUsername(), client);
    }

    @Override
    public void sendMessage(String message, String from, String to) {
        ChatClientController recipient = clients.get(to);

        if (recipient != null) {
            recipient.receiveMessage(from + ": " + message);
        }

        // also show in sender window
        ChatClientController sender = clients.get(from);
        if (sender != null) {
            sender.receiveMessage("To " + to + ": " + message);
        }
    }
}