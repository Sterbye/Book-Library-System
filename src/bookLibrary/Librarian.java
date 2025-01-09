package bookLibrary;

import java.util.Scanner;

/**
 * Represents a virtual assistant for interacting with the Book Library system.
 * <p>
 * The {@code Librarian} class provides a command-line interface for users to:
 * <ul>
 *     <li>View all available books in the library</li>
 *     <li>Borrow books by title</li>
 *     <li>Return books by title</li>
 *     <li>Exit the system</li>
 * </ul>
 * This class acts as a bridge between the user and the {@link BookLibrary}.
 * </p>
 */
public class Librarian {

    /**
     * Constructs a new {@code Librarian} instance and initializes the user interface.
     * <p>
     * The constructor presents a menu to the user in a loop, allowing them to interact
     * with the library system until they choose to exit.
     * </p>
     */
    public Librarian() {
        Scanner input = new Scanner(System.in);
        boolean menuOpen = true;

        while(menuOpen) {
            displayMenu(); // Display the menu options
            try {
                int choice = input.nextInt();
                input.nextLine(); // Consume the newline character

                //handle user choice of option
                switch (choice) {
                    case 1:
                        displayListOfBooks();
                        break;
                    case 2:
                        borrowBook(input);
                        break;
                    case 3:
                        returnBook(input);
                        break;
                    case 4:
                        System.out.println("Good bye and have a nice day.");
                        menuOpen = false; // Exit the menu loop
                        break;
                    default:
                        System.out.println("Bad choice try again");
                }
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid number.");
                input.nextLine(); // Clear invalid input
            }

        }
            input.close();
    }


    /**
     * Displays the menu options for interacting with the library system.
     * <p>
     * This method outputs a numbered list of actions the user can take, such as
     * viewing available books, borrowing a book, returning a book, or exiting.
     * </p>
     */
    public void displayMenu() {
        System.out.println("\nWelcome in our Book Library called ~The Wall~");
        System.out.println("I'm Alica your virtual assistant, how can I help you with ?");
        System.out.println("1. Show all available books in library");
        System.out.println("2. I would like to borrow the book");
        System.out.println("3. I would like to return the book");
        System.out.println("4. Farewell Alice");
        System.out.print("Choose an option: ");
    }

    /**
     * Displays the list of all books currently available in the library.
     * <p>
     * This method delegates the task to the {@link BookLibrary#displayListOfBooks()} method.
     * </p>
     */
    public void displayListOfBooks() {
        BookLibrary library = BookLibrary.BookLibrary();
        System.out.println("\nHere is list of all available books in our library");
        library.displayListOfBooks();
    }

    /**
     * Allows the user to borrow a book by entering its title.
     * <p>
     * If the book is available, it is borrowed, and the library inventory is updated.
     * Otherwise, an appropriate message is displayed.
     * </p>
     *
     * @param input a {@link Scanner} object for reading user input
     */
    public void borrowBook(Scanner input) {
        System.out.println("\nType a book title, which you would've to borrow");
        BookLibrary library = BookLibrary.BookLibrary();
        String scanner = input.nextLine();
        library.borrowBook(scanner);
    }

    /**
     * Allows the user to return a borrowed book by entering its title.
     * <p>
     * If the book belongs to the library, it is returned, and the library inventory is updated.
     * Otherwise, an appropriate message is displayed.
     * </p>
     *
     * @param input a {@link Scanner} object for reading user input
     */
    public void returnBook(Scanner input) {
        System.out.println("\nType a book title, which you would've to borrow");
        BookLibrary library = BookLibrary.BookLibrary();
        String scanner = input.nextLine();
        library.returnBook(scanner);
    }
}
