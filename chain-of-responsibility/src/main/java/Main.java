public class Main {

    public static void main(String[] args) {

        Handler compensation = new CompensationHandler();
        Handler contact = new ContactRequestHandler();
        Handler development = new DevelopmentSuggestionHandler();
        Handler feedback = new GeneralFeedbackHandler();

        // Build chain
        compensation.setNextHandler(contact);
        contact.setNextHandler(development);
        development.setNextHandler(feedback);

        // Create messages
        Message m1 = new Message(
                MessageType.COMPENSATION_CLAIM,
                "My order arrived damaged.",
                "customer1@email.com");

        Message m2 = new Message(
                MessageType.CONTACT_REQUEST,
                "Please call me regarding my account.",
                "customer2@email.com");

        Message m3 = new Message(
                MessageType.DEVELOPMENT_SUGGESTION,
                "Add dark mode to the mobile app.",
                "customer3@email.com");

        Message m4 = new Message(
                MessageType.GENERAL_FEEDBACK,
                "Great service and fast delivery!",
                "customer4@email.com");

        // Send messages through chain
        compensation.handle(m1);
        compensation.handle(m2);
        compensation.handle(m3);
        compensation.handle(m4);
    }
}