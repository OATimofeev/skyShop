package skypro.skyshop.article;

import skypro.skyshop.search.Searchable;

public final class Article implements Searchable {
    private final String name;
    private final String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    @Override
    public String toString() {
        return name +" - " + text;
    }

    public String searchTerm() {
        return toString();
    }

    public String getContentType() {
        return "ARTICLE";
    }
}
