import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String keyword;
    private List<File> foundFiles = new ArrayList<>();

    public SearchVisitor(String keyword) {
        this.keyword = keyword;
    }

    public List<File> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(keyword)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getChildren()) {
            element.accept(this);
        }
    }
}