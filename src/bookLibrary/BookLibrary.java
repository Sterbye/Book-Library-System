package bookLibrary;

import book.Book;
import book.Encyclopedia;
import book.SpecialBook;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a library system for managing books.
 * <p>
 * The {@code BookLibrary} class provides functionality for:
 * <ul>
 *     <li>Registering new books and their quantities in the library</li>
 *     <li>Borrowing and returning books based on their title</li>
 *     <li>Displaying all available books in the library</li>
 * </ul>
 * This class uses the Singleton pattern to ensure only one instance of the library exists.
 * Note: This implementation is not thread-safe.
 * </p>
 */
public class BookLibrary implements LibraryServices {
    /** The single instance of the library. */
    private static BookLibrary single_instance = null;

    /** Map to store books and their quantities in the library. */
    private Map<Book, Integer> books;

    /** Private constructor to enforce the Singleton pattern. */
    private BookLibrary() {
        books = new HashMap<>();
        initializeBooks();
    }

    /**
     * Provides access to the single instance of the {@code BookLibrary}.
     * <p>
     * If the instance does not already exist, it will be created. Otherwise, the existing
     * instance is returned.
     * </p>
     *
     * @return the single instance of the {@code BookLibrary}
     */
    public static BookLibrary BookLibrary()
    {
        if (single_instance == null) {
            single_instance = new BookLibrary();
        }
        return single_instance;
    }

    /**
     * Initializes the library with a predefined set of books.
     * <p>
     * This method adds hardcoded books and their quantities to the library. It is primarily
     * intended for demonstration purposes and should be replaced with dynamic data loading
     * in a production environment.
     * </p>
     */
    private void initializeBooks() {
       Book strach = new Book.Builder("Strach", "Jozef Karika")
                .pageNumbers(328)
                .genre("mysteriozny")
                .language("SK")
                .value(13.90)
                .build();

       Book hlbina = new Book.Builder("Hlbina", "Jozef karika")
                .genre("mysteriozny")
                .pageNumbers(464)
                .language("SK")
                .value(20.67)
                .build();

        Book holly = new Book.Builder("Holly", "Stephen King")
                .genre("napinavy")
                .pageNumbers(504)
                .language("SK")
                .value(21.76)
                .build();

        SpecialBook okozaoko = new SpecialBook.Builder("Oko za oko", "M.J. Arlidge")
                .genre("napinavy")
                .language("SK")
                .pageNumbers(560)
                .signed(true)
                .rare(false)
                .value(18.91)
                .build();

        SpecialBook programjoshua = new SpecialBook.Builder("Program Joshua", "M.J. Arlidge")
                .genre("napinavy")
                .language("SK")
                .pageNumbers(336)
                .signed(true)
                .rare(true)
                .value(21.17)
                .build();

        SpecialBook vykupne = new SpecialBook.Builder("Výkupné", "John Grisham")
                .genre("napinavy")
                .language("SK")
                .pageNumbers(288)
                .signed(false)
                .rare(true)
                .value(14.37)
                .build();

        Encyclopedia encyclopediazvierat = new Encyclopedia.Builder("Encyklopédia zvierat", "Genevieve Warnau")
                .genre("zvierata")
                .language("SK")
                .pageNumbers(304)
                .illustration(true)
                .value(21.90)
                .build();

        Encyclopedia encyclopediabylin = new Encyclopedia.Builder("Encyklopédia bylín", "Foni Book")
                .genre("priroda")
                .language("SK")
                .pageNumbers(255)
                .illustration(false)
                .value(8.90)
                .build();

        registerNewBook(strach, 5);
        registerNewBook(hlbina, 3);
        registerNewBook(holly, 3);
        registerNewBook(okozaoko, 5);
        registerNewBook(programjoshua, 1);
        registerNewBook(vykupne, 1);
        registerNewBook(encyclopediazvierat, 3);
        registerNewBook(encyclopediabylin, 4);
    }

    /**
     * Displays all books available in the library, along with their quantities and special properties.
     * <p>
     * This method uses pattern matching to identify and display specific characteristics
     * of {@link SpecialBook} and {@link Encyclopedia} objects.
     * </p>
     */
    public void displayListOfBooks() {
        System.out.println("Books in Library:");
        for (Map.Entry<Book, Integer> entry : books.entrySet()) {
            Book book = entry.getKey();
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " - Quantity: " + entry.getValue());
            if (book instanceof SpecialBook specialBook) {
                System.out.println(" (Signed: " + specialBook.isSigned() + ", Rare: " + specialBook.isRare() + ")");
            } else if (book instanceof Encyclopedia encyclopedia) {
                System.out.println(" (Illustrated: " + encyclopedia.isIllustration() + ")");
            } else {
                System.out.println();
            }
        }
    }

    /**
     * Registers a new book or updates the quantity of an existing book in the library.
     *
     * @param book     the book to be registered
     * @param quantity the number of copies to add; must be greater than 0
     * @throws IllegalArgumentException if {@code quantity} is less than or equal to 0
     */
    public void registerNewBook(Book book, int quantity) {
        books.put(book, books.getOrDefault(book, 0) + quantity);
    }

    /**
     * Borrows a book from the library.
     * <p>
     * If the book is available, its quantity is decreased by 1. If the book is out of stock
     * or does not exist in the library, an appropriate message is displayed.
     * </p>
     *
     * @param title the title of the book to borrow (case-insensitive)
     */
    @Override
    public void borrowBook(String title) {
        for (Map.Entry<Book, Integer> entry : books.entrySet()) {
            Book book = entry.getKey();
            int quantity = entry.getValue();

            if (book.getTitle().equalsIgnoreCase(title)) {
                if (quantity > 0) {
                    books.put(book, quantity - 1);
                    System.out.println("You borrowed \"" + book.getTitle() + "\".");
                } else {
                    System.out.println("Sorry, \"" + book.getTitle() + "\" is currently out of stock.");
                }
                return;
            }
        }
        System.out.println("The requested book is not available in the library.");
    }

    /**
     * Returns a borrowed book to the library.
     * <p>
     * If the book exists in the library, its quantity is increased by 1. If the book is not
     * recognized as part of the library collection, a warning message is displayed.
     * </p>
     *
     * @param title the title of the book to return (case-insensitive)
     */
    @Override
    public void returnBook(String title) {
        for (Map.Entry<Book, Integer> entry : books.entrySet()) {
            Book book = entry.getKey();
            int quantity = entry.getValue();

            if (book.getTitle().equalsIgnoreCase(title)) {
                books.put(book, quantity + 1);
                System.out.println("Thank you for returning \"" + book.getTitle() + "\".");
                return;
            }
        }
        System.out.println("This book does not belong to the library.");
    }
}
