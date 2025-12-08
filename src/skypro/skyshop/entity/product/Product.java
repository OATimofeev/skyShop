package skypro.skyshop.entity.product;

import skypro.skyshop.util.search.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
