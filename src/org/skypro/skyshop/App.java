package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        SimpleProduct milk = new SimpleProduct("Молоко", 70);
        SimpleProduct eggs = new SimpleProduct("Яйца", 120);
        FixPriceProduct bread = new FixPriceProduct("Хлеб");
        DiscountProduct butter = new DiscountProduct("Масло", 200, 50);
        SimpleProduct banana = new SimpleProduct("Бананы", 90);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(milk);
        basket.addProduct(eggs);
        basket.addProduct(bread);
        basket.addProduct(butter);
        basket.addProduct(banana);
        System.out.println("Добавление продукта в заполненную корзину, в которой нет свободного места.");
        basket.addProduct(banana);
        System.out.println("Печать содержимого корзины с несколькими товарами.");
        basket.printContentBasket();
        System.out.println("Получение стоимости корзины с несколькими товарами.");
        System.out.println("Стоимость товаров равна: " + basket.getPriceBasket());
        System.out.println("Поиск товара, который есть в корзине. \"Молоко\"");
        System.out.println(basket.checkContentNameInBasket("Молоко"));
        System.out.println("Поиск товара, которого нет в корзине. \"Машина\"");
        System.out.println(basket.checkContentNameInBasket("Машина"));
        System.out.println("Очистка корзины и печать содержимого пустой корзины.");
        basket.clearBasket();
        basket.printContentBasket();
        System.out.println("Получение стоимости пустой корзины.");
        System.out.println("Стоимость товаров равна: " + basket.getPriceBasket());
        System.out.println("Поиск товара по имени в пустой корзине. \"Молоко\"");
        System.out.println(basket.checkContentNameInBasket("Молоко"));
    }
}
