package book;

/**
 * Represents a concrete implementation of a book, extending the {@link AbstractBook} class.
 * <p>
 * This class uses the Builder pattern for flexible and readable object creation. It provides
 * functionality to display the details of a book and ensures immutability of its properties.
 * </p>
 */
public class Book extends AbstractBook {
    /**
     * Constructs a {@code Book} using the provided {@code Builder}.
     * @param builder the builder containing the properties for the book
     */
    public Book(Builder builder) {
        super(builder.title, builder.author, builder.genre, builder.pageNumbers, builder.language, builder.value);
    }

    /**
     * Displays the details of the book.
     * <p>
     * This method outputs the properties of the book, including title, author,
     * genre, page count, language, and value, to the console in a readable format.
     * </p>
     */
    @Override
    public void displayDetails() {
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Genre: " + getGenre());
        System.out.println("Page numbers: " + getPageNumbers());
        System.out.println("Language: " + getLanguage());
        System.out.println("Value: " + getValue());
    }

    /**
     * Builder pattern for creating a new instance of {@link Book}.
     * <p>
     * This static nested class allows for flexible and fluent construction of {@code Book}
     * objects by chaining method calls to set optional parameters.
     * </p>
     */
    public static class Builder {
        /**
         * The title of the book (required).
         */
        private final String title;

        /**
         * The author of the book (required).
         */
        private final String author;

        /**
         * The genre of the book (optional).
         */
        private String genre;

        /**
         * The number of pages in the book (optional, default is 0).
         */
        private int pageNumbers;

        /**
         * The language of the book (optional, default is null).
         */
        private String language;

        /**
         * The monetary value of the book (optional, default is 0.0).
         */
        private double value;


        /**
         * Creates a new builder with the specified title and author.
         *
         * @param title  the title of the book; must not be null
         * @param author the author of the book; must not be null
         */
        public Builder(String title, String author) {
            this.title = title;
            this.author = author;
        }

        /**
         * Sets the genre of the book.
         * @param genre the genre of the book
         * @return this builder instance
         */
        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        /**
         * Sets the number of pages in the book.
         * @param pageNumbers the number of pages; must be greater than 0
         * @return this builder instance
         */
        public Builder pageNumbers(int pageNumbers) {
            this.pageNumbers = pageNumbers;
            return this;
        }

        /**
         * Sets the language of the book.
         * @param language the language of the book
         * @return this builder instance
         */
        public Builder language(String language) {
            this.language = language;
            return this;
        }

        /**
         * Sets the monetary value of the book.
         * @param value the value of the book; must be non-negative
         * @return this builder instance
         */
        public Builder value(double value) {
            this.value = value;
            return this;
        }

        /**
         * Builds and returns a new {@code Book} instance.
         * @return a new {@code Book} object
         */
        public Book build() {
            return new Book(this);
        }
    }
}
