package com.maggies.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
    Double total = 0.0;
    List<Product> products = new ArrayList();
    List<Extras> extras = new ArrayList();
    String customer;


    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void addExtras(Extras extras) {
        this.extras.add(extras);
    }

    public List<Extras> getExtras() {
        return extras;
    }

    public void setExtras(List<Extras> extras) {
        this.extras = extras;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
