package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private final String title;
    private final String body;

    public Article(String title, String body) {
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return title + "\n" + body;
    }

    @Override
    public String searchTerm() {
        return title + " " + body;
    }

    @Override
    public String getSearchName() {
        return title;
    }

    @Override
    public String getSearchType() {
        return "Article";
    }
}
