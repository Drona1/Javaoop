package com.gmail.dimabah.homeworks.third;

import java.util.Comparator;

public class ProductsComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Product product1 = (Product)o1;
        Product product2 = (Product)o2;

        if (product1.getCategory().ordinal()>product2.getCategory().ordinal()){
            return 1;
        }else if(product1.getCategory().ordinal()<product2.getCategory().ordinal()){
            return -1;
        }
        return 0;
    }
}
