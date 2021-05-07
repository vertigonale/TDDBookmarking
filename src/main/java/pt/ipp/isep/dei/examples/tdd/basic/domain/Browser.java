package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Collections.unmodifiableList;

public class Browser {
    private List<Bookmark> bookmarks;

    public Browser() {
        bookmarks = new ArrayList<>();
    }

    public List<Bookmark> getBookmarks() {
        return unmodifiableList(bookmarks);
    }

    public void add(Bookmark bookmark) {
        boolean browserDoesntContainBookmark = bookmarks.stream().noneMatch(foundOfUrlOf(bookmark));

        if (browserDoesntContainBookmark) bookmarks.add(bookmark);
    }

    private Predicate<Bookmark> foundOfUrlOf(Bookmark bookmark) {
        return existingBookmark -> existingBookmark.getUrl().equals(bookmark.getUrl());
    }

}
