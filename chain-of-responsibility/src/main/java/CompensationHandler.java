public class CompensationHandler extends Handler {

    @Override
    public void handle(Message message) {

        if (message.getType() == MessageType.COMPENSATION_CLAIM) {
            System.out.println("Compensation claim received from: " + message.getSenderEmail());
            System.out.println("Reviewing claim: " + message.getContent());
            System.out.println("Result: Claim approved\n");
        } else {
            super.handle(message);
        }
    }
}