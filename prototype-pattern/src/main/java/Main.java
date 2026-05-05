import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Command-line interface for the Book Recommendation System.
 *
 * Demonstrates the Prototype pattern:
 *   - Browse existing recommendation lists
 *   - Clone an existing list and modify the copy (audience, add/remove books)
 *   - Create a brand-new list from scratch
 *   - Delete a saved list
 */
public class Main {

    private static final RecommendationStore store = new RecommendationStore();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        seedStore();
        printBanner();

        boolean running = true;
        while (running) {
            printMenu();
            String choice = prompt("Choice").trim();
            System.out.println();
            switch (choice) {
                case "1" -> viewAll();
                case "2" -> viewDetail();
                case "3" -> createNew();
                case "4" -> cloneAndModify();
                case "5" -> deleteRecommendation();
                case "6" -> { running = false; System.out.println("Goodbye!"); }
                default  -> System.out.println("  Invalid option — please enter 1-6.\n");
            }
        }
        sc.close();
    }

    // ── Menu actions ─────────────────────────────────────────────────────────

    private static void viewAll() {
        if (store.isEmpty()) {
            System.out.println("  No recommendations saved yet.\n");
            return;
        }
        System.out.println("=== Saved Recommendations ===");
        List<Recommendation> all = store.all();
        for (int i = 0; i < all.size(); i++) {
            System.out.printf("  [%d] %s (%d book%s)%n",
                    i + 1,
                    all.get(i).getTargetAudience(),
                    all.get(i).bookCount(),
                    all.get(i).bookCount() == 1 ? "" : "s");
        }
        System.out.println();
    }

    private static void viewDetail() {
        if (store.isEmpty()) { System.out.println("  No recommendations saved yet.\n"); return; }
        viewAll();
        int idx = promptInt("Enter number to view");
        Optional<Recommendation> opt = store.findByIndex(idx);
        if (opt.isEmpty()) { System.out.println("  Invalid number.\n"); return; }
        System.out.println();
        System.out.println(opt.get());
    }

    private static void createNew() {
        System.out.println("=== Create New Recommendation ===");
        String audience = prompt("Target audience (e.g. 'Young Adults', 'Tech Professionals')");
        Recommendation rec = new Recommendation(audience);
        addBooksInteractively(rec);
        store.save(rec);
        System.out.printf("%n  Saved \"%s\" with %d book(s).%n%n", audience, rec.bookCount());
    }

    private static void cloneAndModify() {
        if (store.isEmpty()) { System.out.println("  No recommendations to clone yet.\n"); return; }
        System.out.println("=== Clone & Modify ===");
        viewAll();
        int idx = promptInt("Choose a recommendation to clone");
        Optional<Recommendation> opt = store.findByIndex(idx);
        if (opt.isEmpty()) { System.out.println("  Invalid number.\n"); return; }

        // ── Prototype clone ──────────────────────────────────────────────────
        Recommendation original = opt.get();
        Recommendation copy     = original.clone();   // <-- deep copy via Prototype pattern
        // ────────────────────────────────────────────────────────────────────

        System.out.println("\n  Cloned from: " + original.getTargetAudience());
        System.out.println("  (The clone is a fully independent deep copy — changes won't affect the original.)\n");

        // Let the user rename the audience
        String newAudience = prompt("New target audience [leave blank to keep \"" + copy.getTargetAudience() + "\"]");
        if (!newAudience.isBlank()) {
            copy.setTargetAudience(newAudience);
        }

        // Offer add / remove on the clone
        boolean editing = true;
        while (editing) {
            System.out.println("\n  Current clone contents:");
            System.out.println(copy);
            System.out.println("  [A] Add a book");
            System.out.println("  [R] Remove a book");
            System.out.println("  [D] Done — save this clone");
            String sub = prompt("  Action").trim().toUpperCase();
            switch (sub) {
                case "A" -> { Book b = promptBook(); copy.addBook(b); System.out.println("  Added: " + b); }
                case "R" -> {
                    String title = prompt("  Title to remove");
                    boolean removed = copy.removeBookByTitle(title);
                    System.out.println(removed ? "  Removed." : "  No book with that title found.");
                }
                case "D" -> editing = false;
                default  -> System.out.println("  Enter A, R, or D.");
            }
        }

        store.save(copy);
        System.out.printf("%n  Clone saved as \"%s\" (%d book(s)).%n", copy.getTargetAudience(), copy.bookCount());
        System.out.println("  Original \"" + original.getTargetAudience() + "\" is unchanged.\n");
    }

    private static void deleteRecommendation() {
        if (store.isEmpty()) { System.out.println("  No recommendations to delete.\n"); return; }
        System.out.println("=== Delete Recommendation ===");
        viewAll();
        int idx = promptInt("Enter number to delete");
        Optional<Recommendation> opt = store.findByIndex(idx);
        if (opt.isEmpty()) { System.out.println("  Invalid number.\n"); return; }
        String audience = opt.get().getTargetAudience();
        String confirm = prompt("  Delete \"" + audience + "\"? (yes/no)");
        if (confirm.equalsIgnoreCase("yes") || confirm.equalsIgnoreCase("y")) {
            store.deleteByIndex(idx);
            System.out.println("  Deleted.\n");
        } else {
            System.out.println("  Cancelled.\n");
        }
    }

    // ── Helpers ──────────────────────────────────────────────────────────────

    private static void addBooksInteractively(Recommendation rec) {
        System.out.println("  Add books (leave title blank to finish):");
        while (true) {
            String title = prompt("  Book title").trim();
            if (title.isBlank()) break;
            Book b = promptBook(title);
            rec.addBook(b);
            System.out.println("  Added: " + b);
        }
    }

    private static Book promptBook() {
        String title = prompt("  Book title");
        return promptBook(title);
    }

    private static Book promptBook(String title) {
        String author = prompt("  Author");
        String genre  = prompt("  Genre (e.g. Fiction, Science, History)");
        int    year   = promptInt("  Publication year");
        return new Book(title, author, genre, year);
    }

    private static String prompt(String label) {
        System.out.print(label + ": ");
        return sc.nextLine();
    }

    private static int promptInt(String label) {
        while (true) {
            try {
                return Integer.parseInt(prompt(label).trim());
            } catch (NumberFormatException e) {
                System.out.println("  Please enter a whole number.");
            }
        }
    }

    private static void printBanner() {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║     Book Recommendation System               ║");
        System.out.println("║     (Prototype Design Pattern — Java)        ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.println();
    }

    private static void printMenu() {
        System.out.println("─────────────────────────────────────────────");
        System.out.println(" 1. View all recommendations");
        System.out.println(" 2. View recommendation detail");
        System.out.println(" 3. Create new recommendation");
        System.out.println(" 4. Clone & modify a recommendation  ← Prototype");
        System.out.println(" 5. Delete a recommendation");
        System.out.println(" 6. Exit");
        System.out.println("─────────────────────────────────────────────");
    }

    // ── Seed data ────────────────────────────────────────────────────────────

    private static void seedStore() {
        Recommendation forTeens = new Recommendation("Teenagers");
        forTeens.addBook(new Book("The Hunger Games",      "Suzanne Collins",   "Dystopian", 2008));
        forTeens.addBook(new Book("Harry Potter",          "J.K. Rowling",      "Fantasy",   1997));
        forTeens.addBook(new Book("The Maze Runner",       "James Dashner",     "Sci-Fi",    2009));
        store.save(forTeens);

        Recommendation forTech = new Recommendation("Tech Professionals");
        forTech.addBook(new Book("Clean Code",             "Robert C. Martin",  "Technology", 2008));
        forTech.addBook(new Book("The Pragmatic Programmer","David Thomas",     "Technology", 1999));
        forTech.addBook(new Book("Design Patterns",        "Gang of Four",      "Technology", 1994));
        store.save(forTech);

        Recommendation forHistory = new Recommendation("History Enthusiasts");
        forHistory.addBook(new Book("Sapiens",             "Yuval Noah Harari", "History",   2011));
        forHistory.addBook(new Book("The Guns of August",  "Barbara Tuchman",   "History",   1962));
        store.save(forHistory);
    }
}