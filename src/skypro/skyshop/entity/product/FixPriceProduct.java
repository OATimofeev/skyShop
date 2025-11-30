package skypro.skyshop.entity.product;

public class FixPriceProduct extends Product {
    private static final int price = 30;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public Integer getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "%s: Фиксированная цена %d".formatted(name, price);
    }
}
