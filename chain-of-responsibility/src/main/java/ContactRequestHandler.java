public class ContactRequestHandler extends Handler {

    @Override
    public void handle(Message message) {

        if (message.getType() == MessageType.CONTACT_REQUEST) {
            System.out.println("Contact request from: " + message.getSenderEmail());
            System.out.println("Message: " + message.getContent());
            System.out.println("Forwarding to customer support\n");
        } else {
            super.handle(message);
        }
    }
}