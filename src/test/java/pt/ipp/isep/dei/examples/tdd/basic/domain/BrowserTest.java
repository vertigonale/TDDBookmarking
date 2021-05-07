package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
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
     * User Story: As a user I want to be able to filter bookmarks by one keyword
     */
    @Test
    public void ensureBrowserFindsBookmarksByOneKeywordInsideTags() {
        assertDoesNotThrow(() -> {
            // Arrange
            Bookmark google = new Bookmark("https://www.google.com");
            Bookmark baeldung = new Bookmark("https://www.baeldung.com");
            Bookmark facebook = new Bookmark("https://www.facebook.com");
            Browser browser = new Browser();
            List<Bookmark> expectedBookmarks = asList(google, baeldung);
            List<Bookmark> foundBookmarks;
            String keyword = "Programming";

            google.setTag("Programming");
            baeldung.setTag("Programming");
            facebook.setTag("StalkingPeople");
            browser.add(google);
            browser.add(baeldung);
            browser.add(facebook);

            //Act
            foundBookmarks = browser.findBookmarksTaggedWith(keyword);

            // Assert
            assertEquals(expectedBookmarks, foundBookmarks);
        });
    }

    /**
     * User Story: As a user I want to be able to filter bookmarks by one keyword
     */
    @Test
    public void ensureBrowserFindsBookmarksByOneKeywordInsideURLs() {
        assertDoesNotThrow(() -> {
            // Arrange
            Bookmark google = new Bookmark("https://www.google.com");
            Bookmark baeldung = new Bookmark("https://www.baeldung.com");
            Bookmark facebook = new Bookmark("https://www.facebook.com");
            Browser browser = new Browser();
            List<Bookmark> expectedBookmarks = asList(google, baeldung, facebook);
            List<Bookmark> foundBookmarks;
            String keyword = "www";

            browser.add(google);
            browser.add(baeldung);
            browser.add(facebook);

            //Act
            foundBookmarks = browser.findBookmarksWithUrlContaining(keyword);

            // Assert
            assertEquals(expectedBookmarks, foundBookmarks);
        });
    }

}
