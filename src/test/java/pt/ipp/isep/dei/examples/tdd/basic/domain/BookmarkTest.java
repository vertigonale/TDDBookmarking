package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookmarkTest {

    /**
     * User Story: As a user I want to bookmark a URL (URLs must be valid)
     */
    @Test
    public void ensureBookmarkCanBeCreatedWithArguments() {
        assertDoesNotThrow(() -> {
            // Arrange
            Bookmark bookmark;
            String url = "https://www.google.com";
            URL expectedUrl = new URL(url);

            // Act
            bookmark = new Bookmark(url);

            // Assert
            assertEquals(expectedUrl, bookmark.getUrl());
        });
    }

    /**
     * User Story: As a user I want to bookmark a URL (URLs must be valid)
     */
    @Test
    public void ensureBookmarkCanBeAddedToCollection() {
        assertDoesNotThrow(() -> {
            // Arrange
            Bookmark bookmark = new Bookmark("https://www.google.com");
            List<Bookmark> bookmarkCollection = new ArrayList<>();

            // Act
            bookmarkCollection.add(bookmark);

            // Assert
            assertTrue(bookmarkCollection.contains(bookmark));
        });
    }

    /**
     * User Story: As a user I want to bookmark a URL (URLs must be valid)
     */
    @Test
    public void ensureGivenURLisInvalidInConstructor() {
        assertThrows(MalformedURLException.class, () -> {
            // Arrange
            Bookmark bookmark;
            // Act
            bookmark = new Bookmark("");
        });
    }

    /**
     * User Story: As a user I want to bookmark a URL (URLs must be valid)
     */
    @Test
    public void ensureGivenURLisValidInConstructor() {
        assertDoesNotThrow(() -> {
            // Arrange
            Bookmark bookmark;
            // Act
            bookmark = new Bookmark("https://www.google.com");
        });
    }

    /**
     * User Story: As a user I want to be able to Tag a URL with a keyword
     */
    @Test
    public void ensureBookmarkCanBeTagged() {
        assertDoesNotThrow(() -> {
            // Arrange
            Bookmark bookmark = new Bookmark("https://www.google.com");
            String tag = "favorite";

            // Act
            bookmark.setTag(tag);

            // Assert
            assertEquals(tag, bookmark.getTag());
        });
    }

    /**
     * User Story: As a user when I add a duplicate bookmark, I want the system to increase the rating of that bookmark, because no exact duplicates should exist
     */
    @Test
    public void ensureRatingOfBookmarkStartsWithZero() {
        assertDoesNotThrow(() -> {
            // Arrange
            Bookmark google = new Bookmark("https://www.google.com");
            int expectedRating = 0;
            int actualRating;

            // Act
            actualRating = google.getRating();

            // Assert
            assertEquals(expectedRating, actualRating);
        });
    }
}
