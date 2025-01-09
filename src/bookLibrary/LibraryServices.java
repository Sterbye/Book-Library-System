package bookLibrary;

/**
 * Represents a contract for a book library system.
 * <p>
 * Implementing classes are responsible for handling core library services,
 * including borrowing and returning books
 * </p>
 */
public interface LibraryServices {

    /**
     * Borrows a book from the library.
     * <p>
     * This method marks the specified book as borrowed in the library system.
     * If the book is unavailable (e.g., already borrowed), an appropriate
     * exception or error handling mechanism should be provided by the implementation.
     * </p>
     *
     * @param title the title of the book to borrow; must not be null or empty
     */
    void borrowBook(String title);

    /**
     * Returns a borrowed book to the library.
     * <p>
     * This method updates the library system to mark the specified book as returned.
     * If the book is not recognized (e.g., not borrowed from this library),
     * the implementation should handle the error appropriately.
     * </p>
     *
     * @param title the title of the book to return; must not be null or empty
     */
    void returnBook(String title);
}
