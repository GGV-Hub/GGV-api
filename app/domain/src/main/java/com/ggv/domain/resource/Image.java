package com.ggv.domain.resource;

public class Image {
    private String url;

    private Image(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public static Image from(String url) {
        return new Image(url);
    }
}
