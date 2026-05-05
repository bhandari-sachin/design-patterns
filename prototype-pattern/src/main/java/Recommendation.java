

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Recommendation class implementing the Prototype design pattern.
 *
 * A Recommendation bundles a target audience with an ordered list of Books.
 * Calling clone() produces a fully independent deep copy — every Book inside
 * the list is itself cloned, so mutations to the copy never affect the original.
 */
public class Recommendation implements Cloneable {

    private String     targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    // ── Prototype ────────────────────────────────────────────────────────────

    /**
     * Deep-clones this Recommendation.
     *
     * Shallow-cloning the list would share Book references between the original
     * and the copy.  Instead we clone each Book individually so the two lists
     * are entirely independent.
     */
    @Override
    public Recommendation clone() {
        try {
            Recommendation copy = (Recommendation) super.clone();
            // Deep-copy the book list
            copy.books = new ArrayList<>(this.books.size());
            for (Book b : this.books) {
                copy.books.add(b.clone());
            }
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Recommendation must implement Cloneable", e);
        }
    }

    // ── Mutation helpers (used after cloning to customise the copy) ──────────

    /** Appends a book to this recommendation list. */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Removes the first book whose title matches (case-insensitive).
     *
     * @return true if a book was removed, false if no match was found.
     */
    public boolean removeBookByTitle(String title) {
        return books.removeIf(b -> b.getTitle().equalsIgnoreCase(title));
    }

    /** Replaces the target audience label. */
    public void setTargetAudience(String audience) {
        this.targetAudience = audience;
    }

    // ── Getters ──────────────────────────────────────────────────────────────

    public String getTargetAudience()   { return targetAudience; }

    /** Returns an unmodifiable view of the book list. */
    public List<Book> getBooks()        { return Collections.unmodifiableList(books); }

    public int bookCount()              { return books.size(); }

    // ── Display ──────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recommendation for: ").append(targetAudience).append("\n");
        if (books.isEmpty()) {
            sb.append("  (no books yet)\n");
        } else {
            for (int i = 0; i < books.size(); i++) {
                sb.append(String.format("  %d. %s%n", i + 1, books.get(i)));
            }
        }
        return sb.toString();
    }
}