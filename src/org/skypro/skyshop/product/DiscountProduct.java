package org.skypro.skyshop.product;

import java.util.Objects;

public class DiscountProduct extends Product{
    private final int basicPrice;
    private final int discountPercent;
    public DiscountProduct(String name, int basicPrice, int discountPercent) {
        super(name);
        if (basicPrice < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной.");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Скидка должна быть в диапазоне от 0 до 100");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountProduct that = (DiscountProduct) o;
        return basicPrice == that.basicPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), basicPrice);
    }
}
