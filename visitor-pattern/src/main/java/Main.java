public class Main {
    public static void main(String[] args) {
        // Create files
        Directory root = getDirectory();

        // Apply SizeCalculatorVisitor
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size of all files: " + sizeVisitor.getTotalSize() + " MB");

        // Apply SearchVisitor
        SearchVisitor searchVisitor = new SearchVisitor(".docx");
        root.accept(searchVisitor);
        System.out.println("Files containing '.docx':");
        for (File file : searchVisitor.getFoundFiles()) {
            System.out.println("- " + file.getName());
        }
    }

    private static Directory getDirectory() {
        File file1 = new File("report.docx", 5);
        File file2 = new File("image.png", 2);
        File file3 = new File("notes.txt", 1);
        File file4 = new File("presentation.pptx", 10);

        // Create directories and add files
        Directory root = new Directory("root");
        Directory docs = new Directory("documents");
        Directory pics = new Directory("pictures");

        docs.addElement(file1);
        docs.addElement(file3);
        pics.addElement(file2);
        root.addElement(docs);
        root.addElement(pics);
        root.addElement(file4); // file directly in root
        return root;
    }
}