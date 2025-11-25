package skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int price;
    private int discount;

    public DiscountedProduct(String name, int price, int discount) {
        super(name);
        this.price = price;
        this.discount = discount;
    }

    @Override
    public Integer getPrice() {
        return price * (100 - discount) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "%s: %d (%d%%)".formatted(name, price, discount);
    }
}
