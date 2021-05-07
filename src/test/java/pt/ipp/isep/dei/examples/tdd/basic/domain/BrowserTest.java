package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrowserTest {

    /**
     * User Story: As a user when I add a duplicate bookmark, I want the system to increase the rating of that bookmark, because no exact duplicates should exist
     */
    @Test
    public void ensureBookmarksCanBeAddedToBrowser() {
        assertDoesNotThrow(() -> {
            // Arrange
            Bookmark google = new Bookmark("https://www.google.com");
            Bookmark amazon = new Bookmark("https://www.amazon.com");
            Browser browser = new Browser();
            List<Bookmark> bookmarks = browser.getBookmarks();
            int expectedSize = 2;
            int actualSize;

            // Act
            browser.add(google);
            browser.add(amazon);
            actualSize = bookmarks.size();

            // Assert
            assertEquals(expectedSize, actualSize);
        });
    }

    /**
     * User Story: As a user when I add a duplicate bookmark, I want the system to increase the rating of that bookmark, because no exact duplicates should exist
     */
    @Test
    public void ensureBrowserDoesntAllowDuplicatedBookmarks() {
        assertDoesNotThrow(() -> {
            // Arrange
            Bookmark google = new Bookmark("https://www.google.com");
            Bookmark duplicatedGoogle = new Bookmark("https://www.google.com");
            Browser browser = new Browser();
            List<Bookmark> bookmarks = browser.getBookmarks();
            int expectedSize = 1;
            int actualSize;

            // Act
            browser.add(google);
            browser.add(duplicatedGoogle);
            actualSize = bookmarks.size();

            // Assert
            assertEquals(expectedSize, actualSize);
        });
    }

    /**
     * User Story: As a user when I add a duplicate bookmark, I want the system to increase the rating of that bookmark, because no exact duplicates should exist
     */
    @Test
    public void ensureBrowserRaisesRatingOfBookmarkByInsertingADuplicatedOne() {
        assertDoesNotThrow(() -> {
            // Arrange
            Bookmark google = new Bookmark("https://www.google.com");
            Bookmark duplicatedGoogle = new Bookmark("https://www.google.com");
            Browser browser = new Browser();
            List<Bookmark> bookmarks = browser.getBookmarks();
            int expectedRating = 1;
            int googleRating;

            // Act
            browser.add(google);
            browser.add(duplicatedGoogle);
            googleRating = browser.find(google).get().getRating();

            // Assert
            assertEquals(expectedRating, googleRating);
        });
    }

    /**
     * User Story: As a user when I add a duplicate bookmark, I want the system to increase the rating of that bookmark, because no exact duplicates should exist
     */
    @Test
    public void ensureBrowserDoesntRaiseRatingOfBookmarkByInsertingADifferentOne() {
        assertDoesNotThrow(() -> {
            // Arrange
            Bookmark google = new Bookmark("https://www.google.com");
            Bookmark amazon = new Bookmark("https://www.amazon.com");
            Browser browser = new Browser();
            List<Bookmark> bookmarks = browser.getBookmarks();
            int expectedRating = 0;
            int googleRating;

            // Act
            browser.add(google);
            browser.add(amazon);
            googleRating = browser.find(google).get().getRating();

            // Assert
            assertEquals(expectedRating, googleRating);
        });
    }

}
