package com.gmail.dimabah.additionally.homeworks.first.main.first;

/**
 * Создайте пользовательский класс для описания товара (предположим, это задел для
 * интернет-магазина). В качестве свойств товара можете использовать значение цены,
 * описание, вес товара. Создайте пару экземпляров вашего класса и протестируйте их
 * работу.
 */
public class Main {
    public static void main(String[] args) {
        Product pen = new Product("Pen","Describe your dream", 2.30, 0.1);
        Product knife = new Product("Knife","From  meteoric iron", 99.99, 0.32);

        System.out.println(pen);
        System.out.println(knife);
    }
}
