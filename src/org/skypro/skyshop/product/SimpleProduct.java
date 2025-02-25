package org.skypro.skyshop.product;

import java.util.Objects;

public class SimpleProduct extends Product{
    private final int price;

    public SimpleProduct(String name, int price) {
        super(name);
        if (price < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной.");
        }
        this.price = price;

    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return this.getName() + ":" + this.getPrice();
    }
}
