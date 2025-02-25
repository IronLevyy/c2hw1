package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}
