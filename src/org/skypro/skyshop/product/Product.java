package org.skypro.skyshop.product;

public class Product {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
