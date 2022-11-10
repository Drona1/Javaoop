package com.gmail.dimabah.homeworks.third.interfaces;

import com.gmail.dimabah.homeworks.third.Product;

public interface ProductManagement {
    boolean addProduct(Product product);

    boolean removeProduct(Product product);

    boolean changeAmount(Product product, int amount);

    boolean changePrice(Product product, double price);
}
