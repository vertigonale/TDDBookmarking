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

    public List<Bookmark> findBookmarksTaggedWith(String keyword) {
        return bookmarks.stream()
                .filter(inTagsBy(keyword))
                .collect(toUnmodifiableList());
    }

    private Predicate<Bookmark> inTagsBy(String keyword) {
        return bookmark -> bookmark.getTag().equalsIgnoreCase(keyword);
    }

    public List<Bookmark> findBookmarksWithUrlContaining(String keyword) {
        return bookmarks.stream()
                .filter(inUrlContaining(keyword))
                .collect(toUnmodifiableList());
    }

    private Predicate<Bookmark> inUrlContaining(String keyword) {
        return bookmark -> bookmark.getUrl().toString().contains(keyword);
    }
}
