package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;

public class ProductBasket {
    private ArrayList<Product> basket = new ArrayList<>();

    public void addProduct(Product target) {
        if (basket.size() >= 5) {
            System.out.println("Невозможно добавить продукт!");
            return;
        }
        basket.add(target);
    }

    public int getPriceBasket() {
        int summ = 0;
        for (Product product : basket) {
            summ += product.getPrice();
        }
        return summ;
    }

    public void printContentBasket() {
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто!");
        }
        for (Product product : basket) {
            System.out.println(product.getName() + ":" + product.getPrice());
        }
        System.out.println("Итого: " + getPriceBasket());
    }

    public boolean checkContentNameInBasket(String name) {
        for (Product product : basket) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        basket.clear();
    }
}
