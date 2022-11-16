package com.gmail.dimabah.homeworks.third;

import com.gmail.dimabah.homeworks.third.interfaces.CustomerOpportunities;
import com.gmail.dimabah.homeworks.third.interfaces.PaymentSystemForStore;
import com.gmail.dimabah.homeworks.third.interfaces.ProductManagement;

import java.util.*;

public class Store implements ProductManagement, CustomerOpportunities, PaymentSystemForStore {
    private List<Product> products;
    private List<Product> shoppingCart = new ArrayList<>();

    public Store(List<Product> products) {
        this.products = products;
    }

    public Store(Product... products) {
        this.products = new ArrayList<>();
        Collections.addAll(this.products, products);
    }

    public Store() {
    }


    public List<Product> getProducts() {
        return products;
    }


    @Override
    public List<Product> getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(products, store.products) && Objects.equals(shoppingCart, store.shoppingCart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, shoppingCart);
    }

    @Override
    public String toString() {
        return "Store{" +
                "products=" + products +
                ", shoppingCart=" + shoppingCart +
                '}';
    }

    @Override
    public boolean addProduct(Product product) {
        if (product == null) {
            return false;
        }
        if (products.contains(product)) {
            System.out.println("This product already in the store");
            return false;
        } else {
            System.out.println("Product added to the store");
            products.add(product);
            return true;
        }
    }

    @Override
    public boolean removeProduct(Product product) {
        if (product == null) {
            return false;
        }
        if (products.contains(product)) {
            System.out.println("Product removed from the store");
            products.remove(product);
            return true;
        } else {
            System.out.println("This product is not in the store");
            return false;
        }
    }

    @Override
    public boolean changeAmount(Product product, int differenceValue) {
        if (product == null) {
            return false;
        }
        if (products.contains(product)) {
            int index = products.indexOf(product);
            int newAmount = product.getAmount() + differenceValue;
            if (newAmount < 0) {
                System.out.println("Invalid amount (the amount is negative)");
                return false;
            }
            product.setAmount(newAmount);
            products.set(index, product);
            System.out.println("Changes made");
            return true;
        } else {
            System.out.println("This product is not in the store");
            return false;
        }
    }

    @Override
    public boolean changeAmount(String name, int differenceValue) {
        if (name == null) {
            return false;
        }
        for (var i : products) {
            if (i.getName().equals(name)) {
                int newAmount = i.getAmount() + differenceValue;
                i.setAmount(newAmount);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean changePrice(Product product, double price) {
        if (product == null || price < 0) {
            return false;
        }
        if (products.contains(product)) {
            int index = products.indexOf(product);
            product.setPrice(price);
            products.set(index, product);
            System.out.println("Changes made");
            return true;
        } else {
            System.out.println("This product is not in the store");
            return false;
        }
    }

    @Override
    public int showCategories() {
        Categories[] categories = Categories.values();
        int count = 1;
        for (var i : categories) {
            System.out.println(count + ". " + i);
            count++;
        }
        return count-1;


    }

    @Override
    public int showAssortment(int numberCategories) {
        boolean flag = true;
        int count = 1;
        for (var i : products) {
            if (i.getCategory().ordinal() == numberCategories) {
                if (flag) {
                    i.showHeader();
                    flag = false;
                }
                i.showProduct(count);
                count++;
            }
        }
        return count-1;
    }

    @Override
    public boolean buyProduct(String name, int amount) {
        if (name == null || amount <= 0) {
            return false;
        }
        for (var i : products) {
            if (i.getName().equals(name)) {
                int sum = i.getAmount() - amount;
                for (var j : shoppingCart) {
                    if (j.getName().equals(name)) {
                        sum -= j.getAmount();
                    }
                }
                if (sum >= 0) {
                    Product productToCart;
                    try {
                        productToCart = (Product) i.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new RuntimeException(e);
                    }
                    productToCart.setAmount(amount);
                    shoppingCart.add(productToCart);
                    return true;
                } else {
                    System.out.println("There is not enough product in the store");
                    return false;
                }
            }
        }
        System.out.println("There is not such product in the store");
        return false;
    }

    public void showProduct() {
        if (products == null) {
            System.out.println();
            System.out.println("Products: Empty");
            return;
        }
        products.sort(new ProductsComparator());
        Categories categories = null;
        int count = 1;
        for (var i : products) {
            if (i.getCategory() != categories) {
                if (categories == null) {
                    System.out.println();
                    System.out.println("Products:");
                    System.out.println("____________________________________");
                } else {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }
                i.showHeader();
                categories = i.getCategory();
            }
            categories = i.getCategory();
            i.showProduct(count);
            count++;
        }
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
                    System.out.println("____________________________________");
                } else {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }
                i.showHeader();
                categories = i.getCategory();
            }
            i.showProduct(count);
            count++;
        }
    }

    @Override
    public void clearShoppingCart() {
        shoppingCart.clear();
    }
}
