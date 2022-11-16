package com.gmail.dimabah.homeworks.third;

import com.gmail.dimabah.homeworks.third.interfaces.PaymentSystemForCustomer;
import com.gmail.dimabah.homeworks.third.interfaces.PaymentSystemForStore;

import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentSystem that = (PaymentSystem) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
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
