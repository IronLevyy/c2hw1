package org.skypro.skyshop.product;

public class DiscountProduct extends Product{
    private final int basicPrice;
    private final int discountPercent;
    public DiscountProduct(String name, int basicPrice, int discountPercent) {
        super(name);
        if (basicPrice < 0 || discountPercent < 0) {
            throw new IllegalArgumentException("Цена или скидка не может быть отрицательной.");
        }
        this.basicPrice = basicPrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public int getPrice() {
        return basicPrice / 100 * (100 - discountPercent);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return this.getName() + ":" + this.getPrice() + " (" + discountPercent + "%)";
    }
}
