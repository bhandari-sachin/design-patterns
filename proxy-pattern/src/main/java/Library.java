import java.util.*;

class Library {
    private Map<String, IDocument> documents;

    public Library() {
        documents = new HashMap<>();
    }

    // Add unprotected document
    public void addDocument(Document doc) {
        documents.put(doc.getId(), doc);
    }

    // Factory method for protected document
    public void addProtectedDocument(Document doc) {
        DocumentProxy proxy = new DocumentProxy(doc);
        documents.put(doc.getId(), proxy);
    }

    public IDocument getDocument(String id) {
        return documents.get(id);
    }
}