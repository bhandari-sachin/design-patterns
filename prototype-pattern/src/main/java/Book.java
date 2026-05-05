/**
 * Book class implementing the Prototype design pattern.
 * Each Book can clone itself to produce an independent deep copy.
 */
public class Book implements Cloneable {

    private String title;
    private String author;
    private String genre;
    private int publicationYear;

    public Book(String title, String author, String genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    /** Prototype clone — returns a deep copy of this Book. */
    @Override
    public Book clone() {
        try {
            // All fields are primitives or immutable Strings, so super.clone() is a true deep copy.
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Book must implement Cloneable", e);
        }
    }

    // ── Getters & Setters ────────────────────────────────────────────────────

    public String getTitle()            { return title; }
    public void   setTitle(String t)    { this.title = t; }

    public String getAuthor()           { return author; }
    public void   setAuthor(String a)   { this.author = a; }

    public String getGenre()            { return genre; }
    public void   setGenre(String g)    { this.genre = g; }

    public int    getPublicationYear()          { return publicationYear; }
    public void   setPublicationYear(int year)  { this.publicationYear = year; }

    @Override
    public String toString() {
        return String.format("\"%s\" by %s (%s, %d)", title, author, genre, publicationYear);
    }
}