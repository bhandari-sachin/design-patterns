class Document implements IDocument {
    private String id;
    private String creationDate;
    private String content;

    public Document(String id, String creationDate, String content) {
        this.id = id;
        this.creationDate = creationDate;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getContent(User user) {
        return content;
    }
}