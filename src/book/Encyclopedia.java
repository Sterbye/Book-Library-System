package book;

/**
 * Represents an Encyclopedia, a specialized type of {@link Book}.
 * <p>
 * This class extends the {@code Book} class by adding a boolean property
 * {@code illustration}, which indicates whether the encyclopedia contains illustrations.
 * </p>
 * <p>
 * The value of the encyclopedia is adjusted based on whether it includes illustrations.
 * </p>
 */
public class Encyclopedia extends Book {

    /**
     * Indicates whether the encyclopedia contains illustrations.
     */
    private boolean illustration = false;

    /**
     * Constructs an {@code Encyclopedia} using the provided {@code Builder}.
     * @param builder the builder containing the properties for the encyclopedia
     */
    public Encyclopedia(Builder builder) {
        super(builder);
        this.illustration = builder.illustration;
    }

    /**
     * Calculates the value of the encyclopedia.
     * <p>
     * If the encyclopedia contains illustrations, its value is 2.5 times the base value;
     * otherwise, it retains the base value.
     * </p>
     *
     * @return the adjusted value of the encyclopedia
     */
    @Override
    public double getValue() {
        return isIllustration() ? super.getValue() * 2.5 : super.getValue();
    }

    /**
     * Returns whether the encyclopedia contains illustrations.
     * @return {@code true} if the encyclopedia contains illustrations, {@code false} otherwise
     */
    public boolean isIllustration() {
        return illustration;
    }

    /**
     * Displays the details of the encyclopedia, including whether it contains illustrations.
     */
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Illustration: " + isIllustration());
    }

    /**
     * Builder pattern for creating an {@link Encyclopedia}.
     * <p>
     * This builder extends {@link Book.Builder} and adds support for the {@code illustration} property.
     * </p>
     */
    public static class Builder extends Book.Builder {

        /**
         * Indicates whether the encyclopedia will include illustrations.
         */
        private boolean illustration = false;

        /**
         * Creates a new builder for an encyclopedia with the specified title and author.
         * @param title  the title of the encyclopedia; must not be null
         * @param author the author of the encyclopedia; must not be null
         */
        public Builder(String title, String author) {
            super(title, author);
        }

        /**
         * Sets the genre of the encyclopedia.
         * @param genre the genre of the encyclopedia
         * @return this builder instance
         */
        @Override
        public Builder genre(String genre) {
            super.genre(genre);
            return this;
        }

        /**
         * Sets the number of pages in the encyclopedia.
         * @param pageNumbers the number of pages; must be greater than 0
         * @return this builder instance
         */
        @Override
        public Builder pageNumbers(int pageNumbers) {
            super.pageNumbers(pageNumbers);
            return this;
        }

        /**
         * Sets the language of the encyclopedia.
         * @param language the language of the encyclopedia
         * @return this builder instance
         */
        @Override
        public Builder language(String language) {
            super.language(language);
            return this;
        }

        /**
         * Sets the monetary value of the encyclopedia.
         * @param value the value of the encyclopedia; must be non-negative
         * @return this builder instance
         */
        @Override
        public Builder value(double value) {
            super.value(value);
            return this;
        }

        /**
         * Sets whether the encyclopedia includes illustrations.
         * @param illustration {@code true} if the encyclopedia includes illustrations, {@code false} otherwise
         * @return this builder instance
         */
        public Builder illustration(boolean illustration) {
            this.illustration = illustration;
            return this;
        }

        /**
         * Builds and returns a new {@code Encyclopedia} instance.
         * @return a new {@code Encyclopedia} object
         */
        @Override
        public Encyclopedia build() {
            return new Encyclopedia(this);
        }
    }
}
