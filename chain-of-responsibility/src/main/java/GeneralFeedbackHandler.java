public class GeneralFeedbackHandler extends Handler {

    @Override
    public void handle(Message message) {

        if (message.getType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("General feedback from: " + message.getSenderEmail());
            System.out.println("Feedback: " + message.getContent());
            System.out.println("Thank you for your feedback!\n");
        } else {
            super.handle(message);
        }
    }
}