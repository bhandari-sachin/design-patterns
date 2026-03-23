public interface IDocument {
    String getId();
    String getCreationDate();
    String getContent(User user) throws AccessDeniedException;
}
