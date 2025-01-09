package book;

/**
 * Represents a SpecialBook, a type of {@link Book} with additional unique properties.
 * <p>
 * A {@code SpecialBook} can be signed by the author and/or classified as rare,
 * which affects its calculated value. The {@link Builder} pattern is used for
 * flexible object creation, allowing the customization of these properties.
 * </p>
 */
public class SpecialBook extends Book {

    /**
     * Indicates whether the book is signed by the author.
     */
    private boolean signed = false;

    /**
     * Indicates whether the book is rare.
     */
    private boolean rare = false;

    /**
     * Constructs a {@code SpecialBook} using the provided {@link Builder}.
     * @param builder the builder containing the properties for the special book
     */
    private SpecialBook(Builder builder) {
        super(builder);
        this.signed = builder.signed;
        this.rare = builder.rare;
    }

    /**
     * Checks if the book is signed by the author.
     * @return {@code true} if the book is signed, {@code false} otherwise
     */
    public boolean isSigned() {
        return signed;
    }

    /**
     * Checks if the book is classified as rare.
     * @return {@code true} if the book is rare, {@code false} otherwise
     */
    public boolean isRare() {
        return rare;
    }

    /**
     * Calculates the value of the book based on its special properties.
     * <p>
     * The value is determined as follows:
     * <ul>
     *     <li>If the book is both signed and rare, its value is three times the base value.</li>
     *     <li>If the book is either signed or rare, its value is twice the base value.</li>
     *     <li>If neither condition is met, the value remains the base value.</li>
     * </ul>
     * </p>
     *
     * @return the calculated value of the book
     */
    @Override
    public double getValue() {
        if (isSigned() && isRare()) {
            return super.getValue() * 3;
        } else if (isSigned() || isRare()) {
            return super.getValue() * 2;
        }
        return super.getValue();
    }

    /**
     * Displays the details of the special book.
     * <p>
     * This method prints the inherited basic properties and includes additional
     * information about whether the book is signed and/or rare.
     * </p>
     */
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Signed by Author: " + isSigned());
        System.out.println("It's rare: " + isRare());
    }

    /**
     * Builder pattern for creating a {@link SpecialBook}.
     * <p>
     * This builder extends {@link Book.Builder} and adds support for the
     * {@code signed} and {@code rare} properties, while maintaining compatibility
     * with the base class properties.
     * </p>
     */
    public static class Builder extends Book.Builder {

        /**
         * Indicates whether the book is signed by the author.
         */
        private boolean signed = false;

        /**
         * Indicates whether the book is rare.
         */
        private boolean rare = false;

        /**
         * Creates a new builder for a special book with the specified title and author.
         * @param title  the title of the book; must not be null
         * @param author the author of the book; must not be null
         */
        public Builder(String title, String author) {
            super(title, author);
        }

        /**
         * Sets the genre of the book.
         * @param genre the genre of the book
         * @return this builder instance
         */
        @Override
        public Builder genre(String genre) {
            super.genre(genre);
            return this;
        }

        /**
         * Sets the number of pages in the book.
         * @param pageNumbers the number of pages; must be greater than 0
         * @return this builder instance
         */
        @Override
        public Builder pageNumbers(int pageNumbers) {
            super.pageNumbers(pageNumbers);
            return this;
        }

        /**
         * Sets the language of the book.
         * @param language the language of the book
         * @return this builder instance
         */
        @Override
        public Builder language(String language) {
            super.language(language);
            return this;
        }

        /**
         * Sets the monetary value of the book.
         * @param value the value of the book; must be non-negative
         * @return this builder instance
         */
        @Override
        public Builder value(double value) {
            super.value(value);
            return this;
        }

        /**
         * Sets whether the book is signed by the author.
         * @param signed {@code true} if the book is signed, {@code false} otherwise
         * @return this builder instance
         */
        public Builder signed(boolean signed) {
            this.signed = signed;
            return this;
        }

        /**
         * Sets whether the book is rare.
         * @param rare {@code true} if the book is rare, {@code false} otherwise
         * @return this builder instance
         */
        public Builder rare(boolean rare) {
            this.rare = rare;
            return this;
        }

        /**
         * Builds and returns a new {@link SpecialBook} instance.
         * @return a new {@link SpecialBook} object
         */
        @Override
        public SpecialBook build() {
            return new SpecialBook(this);
        }
    }
}
