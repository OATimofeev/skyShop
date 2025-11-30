package skypro.skyshop.entity.product;

import skypro.skyshop.util.search.Searchable;

public abstract class Product implements Searchable {

    protected final String name;

    public Product(String name) {
        checkName(name);
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

    private void checkName(String name) throws IllegalArgumentException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не должно быть пустым или null");
        }
    }
}
