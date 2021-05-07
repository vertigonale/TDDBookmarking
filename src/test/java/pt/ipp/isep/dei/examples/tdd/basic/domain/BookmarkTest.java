package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookmarkTest {

    /**
     * User Story: As a user I want to bookmark a URL (URLs must be valid)
     */
    @Test
    public void ensureBookmarkCanBeCreatedWithArguments() {
        // Arrange
        Bookmark bookmark;
        String url = "https://www.google.com";

        // Act
        bookmark = new Bookmark(url);

        // Assert
        assertEquals(url, bookmark.getUrl());
    }


    /**
     * User Story: As a user I want to bookmark a URL (URLs must be valid)
     */
    @Test
    public void ensureBookmarkCanBeAddedToCollection() {
        // Arrange
        Bookmark bookmark = new Bookmark("https://www.google.com");
        List<Bookmark> bookmarkCollection = new ArrayList<>();

        // Act
        bookmarkCollection.add(bookmark);

        // Assert
        assertTrue(bookmarkCollection.contains(bookmark));
    }
}
