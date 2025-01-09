package book;

/**
 * Abstract base class representing a generic Book.
 * <p>
 * This class provides common properties and methods for all book types
 * and defines an abstract method {@code displayDetails()} to be implemented
 * by subclasses.
 * </p>
 * <p>
 * Example Usage:
 * <pre>
 * public class Book extends AbstractBook {
 *     public Book(String title, String author, String genre, int pageNumbers, String language, double value) {
 *         super(title, author, genre, pageNumbers, language, value);
 *     }
 *
 *     @Override
 *     public void displayDetails() {
 *         System.out.println(getTitle() + " by " + getAuthor());
 *     }
 *  }
 * </pre>
 * </p>
 */
public abstract class AbstractBook {
    /**
     * The title of the book.
     */
    private final String title;

    /**
     * The author of the book.
     */
    private final String author;

    /**
     * The genre of the book (e.g., Fiction, Non-Fiction, Mystery, etc.).
     */
    private final String genre;

    /**
     * The number of pages in the book.
     */
    private final int pageNumbers;

    /**
     * The language in which the book is written.
     */
    private final String language;

    /**
     * The value of the book.
     */
    private final double value;


    /**
     * Constructs an {@code AbstractBook} with the specified properties.
     *
     * @param title       the title of the book
     * @param author      the author of the book
     * @param genre       the genre of the book
     * @param pageNumbers the number of pages in the book; must be greater than 0
     * @param language    the language of the book
     * @param value       the monetary value of the book; must be non-negative
     * @throws IllegalArgumentException if {@code pageNumbers <= 0} or {@code value < 0}
     */
    protected AbstractBook (String title, String author, String genre,
                    int pageNumbers, String language, double value ) {

        if (pageNumbers <= 0) {
            throw new IllegalArgumentException("Page numbers must be greater than 0.");
        }

        if(value < 0) {
            throw new IllegalArgumentException("Value cannot be 0");
        }

        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pageNumbers = pageNumbers;
        this.language = language;

        this.value = value;
    }

    /**
     * Returns the title of the book.
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the author of the book.
     * @return the author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the genre of the book.
     * @return the genre of the book
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Returns the number of pages in the book.
     * @return the number of pages in the book
     */
    public int getPageNumbers() {
        return pageNumbers;
    }

    /**
     * Returns the language of the book.
     * @return the language of the book
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Returns the monetary value of the book.
     * @return the monetary value of the book
     */
    public double getValue() {
        return value;
    }

    /**
     * Displays the details of the book.
     * <p>
     * Implementing classes should override this method to provide a concrete
     * implementation that outputs book details in a specific format.
     * </p>
     */
    public abstract void displayDetails();
}
