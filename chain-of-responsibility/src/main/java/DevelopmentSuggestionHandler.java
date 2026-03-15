public class DevelopmentSuggestionHandler extends Handler {

    @Override
    public void handle(Message message) {

        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("Development suggestion received:");
            System.out.println(message.getContent());
            System.out.println("Logging suggestion for product team\n");
        } else {
            super.handle(message);
        }
    }
}