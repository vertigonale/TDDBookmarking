package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookmarkCollectionTest {

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
            bookmarks.add(google);
            bookmarks.add(amazon);
            actualSize = bookmarks.size();

            // Assert
            assertEquals(expectedSize, actualSize);
        });
    }
}
