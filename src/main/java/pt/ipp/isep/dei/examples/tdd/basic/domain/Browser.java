package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.util.ArrayList;
import java.util.List;

public class Browser {
    private List<Bookmark> bookmarks;

    public Browser() {
        bookmarks = new ArrayList<>();
    }

    public List<Bookmark> getBookmarks() {
        return this.bookmarks;
    }
}
