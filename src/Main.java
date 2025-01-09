import bookLibrary.Librarian;

/**
 * The entry point of the Book Library application.
 * <p>
 * This class initializes the library system by creating an instance of the
 * {@link Librarian} class, which provides an interactive menu for users to
 * manage books in the library.
 * </p>
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting the Book Library System...");
        System.out.println("Loading virtual assistant...");
        try {
            Librarian librarian = new Librarian(); // Start the Librarian UI
        } catch (Exception e) {
            System.err.println("An unexpected error occurred while starting the system.");
        }
    }
}