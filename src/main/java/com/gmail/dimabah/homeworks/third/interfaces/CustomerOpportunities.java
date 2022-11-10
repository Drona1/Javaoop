package com.gmail.dimabah.homeworks.third.interfaces;

import com.gmail.dimabah.homeworks.third.Product;

import java.util.List;

public interface CustomerOpportunities {
    void showCategories();

    void showAssortment(int numberCategories);

    boolean buyProduct(String name, int amount);

    List<Product> getShoppingCart();
}
