package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

public class Bookmark {
    private URL url;
    private String tag;
    private int rating;
    private LocalDateTime timeItWasAdded;

    public Bookmark(String url) throws MalformedURLException {
        this.url = new URL(url);
        this.tag = "";
        this.rating = 0;
    }

    public URL getUrl() {
        return url;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public int getRating() {
        return rating;
    }

    public void increaseRating() {
        rating++;
    }

    public LocalDateTime getTimeItWasAdded() {
        return timeItWasAdded;
    }

    public void setTimeItWasAddedToNow() {
        this.timeItWasAdded = now();
    }

    public boolean isUrlContaining(String keyword) {
        String url = this.url.toString();
        return url.contains(keyword);
    }
}
