/*
 * Copyright (c) 2016. This code is a LogosProg property. All Rights Reserved.
 */

import java.util.List;

/**
 * Created by forando on 13.11.14.
 * This is classic example of "Recursive Type Extension" in Generics
 */
public abstract class Product<T extends Product<T>> implements Comparable<T> {
    public String name;
    public int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public boolean isSameProduct (Product p){
        if (name.contentEquals(p.name)) return true;
        return false;
    }

    /*
    Bounded wildcard example
     */
    public boolean find(List<? extends Product> all, Product p){
        for (Product sp : all){
            if (sp.isSameProduct(p)) return true;
        }
        return false;
    }

    public <T extends Product> boolean findStronglyTyped(List<T> all, T p){
        for (Product sp : all){
            if (sp.isSameProduct(p)) return true;
        }
        return false;
    }

    /*
    Next example of "Bounded wildcard"
    - keyword "extends" defines IN-argument (to read from). It provides upper limit
    in classes hierarchy.
    - keyword "super" defines OUT-argument (to write into). It provides lower limit
    in classes hierarchy.
     */
    public void copy(List<? extends Product> src, List<? super Product> dest){
        for (Product p : src){
            dest.add(p);
        }
    }

    abstract int subCompare(T p);

    @Override
    public int compareTo(T p) {
        if (price>p.price) return 1;
        return 0;
    }
}
