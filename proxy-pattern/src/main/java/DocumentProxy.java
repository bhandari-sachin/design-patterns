class DocumentProxy implements IDocument {
    private Document realDocument;
    private AccessControlService accessService;

    public DocumentProxy(Document realDocument) {
        this.realDocument = realDocument;
        this.accessService = AccessControlService.getInstance();
    }

    public String getId() {
        return realDocument.getId();
    }

    public String getCreationDate() {
        return realDocument.getCreationDate();
    }

    public String getContent(User user) throws AccessDeniedException {
        if (accessService.isAllowed(user.getUsername(), realDocument.getId())) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException(
                    "Access denied for user: " + user.getUsername()
            );
        }
    }
}