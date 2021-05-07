package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toUnmodifiableList;

public class Browser {
    private List<Bookmark> bookmarks;

    public Browser() {
        bookmarks = new ArrayList<>();
    }

    public List<Bookmark> getBookmarks() {
        return unmodifiableList(bookmarks);
    }

    public void add(Bookmark bookmark) {
        Optional<Bookmark> existingBookmark = find(bookmark);

        existingBookmark.ifPresentOrElse(
                Bookmark::increaseRating,
                () -> bookmarks.add(bookmark)
        );
    }

    public Optional<Bookmark> find(Bookmark bookmark) {
        return bookmarks.stream()
                .filter(byUrlOf(bookmark))
                .findAny();
    }

    private Predicate<Bookmark> byUrlOf(Bookmark bookmark) {
        return existingBookmark -> existingBookmark.getUrl().equals(bookmark.getUrl());
    }

    public List<Bookmark> findBookmarksBy(String tag) {
        return bookmarks.stream()
                .filter(by(tag))
                .collect(toUnmodifiableList());
    }

    private Predicate<Bookmark> by(String tag) {
        return bookmark -> bookmark.getTag().equalsIgnoreCase(tag);
    }


}
