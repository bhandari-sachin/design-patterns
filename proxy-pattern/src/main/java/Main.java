public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        // Users
        User alice = new User("alice");
        User bob = new User("bob");

        // Documents
        Document doc1 = new Document("doc1", "2026-03-23", "Public Content");
        Document doc2 = new Document("doc2", "2026-03-23", "Secret Content");

        // Add documents
        library.addDocument(doc1); // unprotected
        library.addProtectedDocument(doc2); // protected

        // Setup access control
        AccessControlService acs = AccessControlService.getInstance();
        acs.allowAccess("alice", "doc2"); // only Alice can access doc2

        // Access scenarios
        try {
            System.out.println("Alice reads doc1: " +
                    library.getDocument("doc1").getContent(alice));

            System.out.println("Alice reads doc2: " +
                    library.getDocument("doc2").getContent(alice));

            System.out.println("Bob reads doc2: " +
                    library.getDocument("doc2").getContent(bob));

        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}