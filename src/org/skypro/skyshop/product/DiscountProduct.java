package org.skypro.skyshop.product;

public class DiscountProduct extends Product{
    private final int basicPrice;
    private final int discountPercent;
    public DiscountProduct(String name, int basicPrice, int discountPercent) {
        super(name);
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
