package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.net.MalformedURLException;
import java.net.URL;

public class Bookmark {
    private URL url;
    private String tag;

    public Bookmark(String url) throws MalformedURLException {
        this.url = new URL(url);
        this.tag = "";
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
        return 0;
    }
}
