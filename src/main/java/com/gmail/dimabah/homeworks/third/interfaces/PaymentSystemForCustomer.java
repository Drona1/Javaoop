package com.gmail.dimabah.homeworks.third.interfaces;

import com.gmail.dimabah.homeworks.third.Product;

import java.util.List;

public interface PaymentSystemForCustomer {
    List<Product> payProduct();

    void clearShoppingCart();
}
