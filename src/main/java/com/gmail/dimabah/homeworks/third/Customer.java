package com.gmail.dimabah.homeworks.third;

import com.gmail.dimabah.homeworks.third.interfaces.CustomerOpportunities;
import com.gmail.dimabah.homeworks.third.interfaces.PaymentSystemForCustomer;

import java.math.BigDecimal;
import java.util.*;

public class Customer implements PaymentSystemForCustomer {
    private double money;
    private List<Product> shoppingCart;
    private List<Product> boughtProducts = new ArrayList<>();

    public Customer(double money) {
        this.money = money;
    }

    public Customer() {
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setShoppingCart(List<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public List<Product> getShoppingCart() {
        return shoppingCart;
    }


    public List<Product> getBoughtProducts() {
        return boughtProducts;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "money=" + money +
                ", shoppingCart=" + shoppingCart +
                ", boughtProducts=" + boughtProducts +
                '}';
    }

    public int showCategories(CustomerOpportunities co) {
        int result = co.showCategories();
        System.out.println("Enter category number, or '0' to exit ('cart' to go to Shopping Cart)");
        return result;
    }

    public int showAssortment(CustomerOpportunities co, int numberCategories) {
        int result = co.showAssortment(numberCategories);
        System.out.println("Enter product number, or '0' to return ('cart' to go to Shopping Cart)");
        return result;
    }

    public boolean buyProduct(CustomerOpportunities co, String name, int amount) {
        if (co.buyProduct(name, amount)) {
            shoppingCart = co.getShoppingCart();
        }
        return false;
    }


    public void showBoughtProducts() {
        if (boughtProducts == null) {
            System.out.println();
            System.out.println("Bought Products: Empty");
            return;
        }
        boughtProducts.sort(new ProductsComparator());
        Categories categories = null;
        int count = 1;
        for (var i : boughtProducts) {
            if (i.getCategory() != categories) {
                if (categories == null) {
                    System.out.println();
                    System.out.println("Bought Products:");
                    System.out.println("-".repeat(100));
                } else {
                    System.out.println("~".repeat(100));
                }
                i.showHeader();
                categories = i.getCategory();
            }
            i.showProduct(count);
            count++;
        }
        System.out.println("-".repeat(100));
        System.out.println("Total: " + getTotal(boughtProducts));
        System.out.println("Money left: " + money);
        System.out.println();

    }

    public void showShoppingCart() {
        if (shoppingCart == null) {
            System.out.println();
            System.out.println("Shopping Cart: Empty");
            return;
        }
        shoppingCart.sort(new ProductsComparator());
        Categories categories = null;
        int count = 1;
        for (var i : shoppingCart) {
            if (i.getCategory() != categories) {
                if (categories == null) {
                    System.out.println();
                    System.out.println("Shopping Cart:");
                    System.out.println("_".repeat(100));
                } else {
                    System.out.println("~".repeat(100));
                }
                i.showHeader();
                categories = i.getCategory();
            }
            i.showProduct(count);
            count++;
        }
        System.out.println("_".repeat(100));
        System.out.println("Total: " + getTotal(shoppingCart));
        System.out.println("Your money: " + money);
        System.out.println();
    }

    @Override
    public List<Product> payProduct() {
        List<Product> products = shoppingCart;
        if (products == null || products.size() == 0) {
            return null;
        }
        double total = getTotal(products);
        if (total <= money) {
            money = new BigDecimal("" + money).
                    subtract(new BigDecimal("" + total)).doubleValue();
            boughtProducts.addAll((ArrayList<Product>) ((ArrayList<Product>) products).clone());


            return products;
        }
        System.out.println("Not enough money");
        return null;
    }

    private double getTotal(List<Product> products) {
        if (products == null || products.size() == 0) {
            return .0;
        }
        BigDecimal sum = new BigDecimal("" + products.get(0).getPrice());
        sum = sum.multiply(new BigDecimal("" + products.get(0).getAmount()));
        for (int i = 1; i < products.size(); i++) {
            sum = sum.add(new BigDecimal("" + products.get(i).getPrice()).multiply(
                    new BigDecimal("" + products.get(i).getAmount())));
        }
        return sum.doubleValue();
    }

    @Override
    public void clearShoppingCart() {
        shoppingCart.clear();
    }
}
