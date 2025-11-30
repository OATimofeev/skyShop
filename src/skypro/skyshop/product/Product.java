package skypro.skyshop.product;

import skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {

    protected final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Integer getPrice();

    public abstract boolean isSpecial();

    public String searchTerm() {
        return name;
    }

    public String getContentType() {
        return "PRODUCT";
    }
}
