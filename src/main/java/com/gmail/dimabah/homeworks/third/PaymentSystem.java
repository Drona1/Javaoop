package com.gmail.dimabah.homeworks.third;

import com.gmail.dimabah.homeworks.third.interfaces.PaymentSystemForCustomer;
import com.gmail.dimabah.homeworks.third.interfaces.PaymentSystemForStore;

import java.util.List;

public class PaymentSystem {
    private String name;

    public PaymentSystem(String name) {
        this.name = name;
    }

    public PaymentSystem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "PaymentSystem{" +
                "name='" + name + '\'' +
                '}';
    }

    public boolean payProduct(PaymentSystemForCustomer psfc,
                              PaymentSystemForStore psfs) {
        List<Product> products = psfc.payProduct();
        if (products == null) {
            return false;
        }
        for (var i : products) {
            psfs.changeAmount(i.getName(), -i.getAmount());
        }
        psfc.clearShoppingCart();
        psfs.clearShoppingCart();
        return true;
    }
}
