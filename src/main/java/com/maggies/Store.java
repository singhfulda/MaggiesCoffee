package com.maggies;

import com.maggies.domain.Extras;
import com.maggies.domain.Order;
import com.maggies.domain.Product;

import java.util.*;

public class Store {

    Map<String, Product> products = new HashMap<String, Product>();
    Map<String, Extras> extras = new HashMap<String, Extras>();
    Map<String, Integer> customersCoffeeCount = new HashMap<String, Integer>();
    Order order = new Order();

    public Store() {
        initiliazeMenu();
    }

    private void initiliazeMenu() {
        products.put("small coffee", new Product("small coffee", 2.50, Product.ProductType.BEVERAGE));
        products.put("medium coffee", new Product("medium coffee", 3.50, Product.ProductType.BEVERAGE));
        products.put("large coffee", new Product("large coffee", 4.00, Product.ProductType.BEVERAGE));
        products.put("bacon roll", new Product("bacon roll", 3.25, Product.ProductType.SNACK));
        products.put("freshly squeezed orange juice", new Product("freshly squeezed orange juice", 4.35, Product.ProductType.BEVERAGE));
        extras.put("cold milk", new Extras("cold milk", 0.30));
        extras.put("foamed milk",  new Extras("foamed milk", 0.50));
        extras.put("special roast",  new Extras("special roast coffee", 1.20));

    }

    public void processOrder(String orderString) {
        String str[] = orderString.split(",");
        for (String productWithExtras : str) {
            System.out.println(productWithExtras);
            addProductsAndExtrasToOrder(productWithExtras.trim());
        }
        checkOrderForBonus(order);
        printOrder(order);
    }

    public void printOrder(Order order) {
        StringBuilder sb = new StringBuilder()
                .append("Maggie´s Coffee Corner,\n")
                .append("Order \n")
                .append("########################\n");
        order.getProducts().forEach(product -> sb.append(product.getName() + "- " + product.getPrice() + " CHF\n"));
        order.getExtras().forEach(extras -> sb.append(extras.getName() + "- " + extras.getPrice() + " CHF\n"));
        sb.append("Total: " + order.getTotal() + " CHF\n");
        sb.append("########################\n");
        sb.append("Thanks for your visit\n");

        String str = sb.toString();
        System.out.print(str);

    }


    private void checkOrderForBonus(Order order) {
        boolean snackIsPresent = order.getProducts().stream().anyMatch(product -> product.getType() == Product.ProductType.SNACK);
        if(snackIsPresent) {
            List<Extras> extrasList  = order.getExtras();
            if(extrasList.size()>0) {
                order.setTotal(order.getTotal()- extrasList.get(0).getPrice());
            }

        }
    }


    private void addProductsAndExtrasToOrder(String product) {
        if(product.contains("with")) {
            String subOrders[] = product.split(" with ");
            if(products.containsKey(subOrders[0])) {
                order.addProduct(products.get(subOrders[0]));
            }
            if(extras.containsKey(subOrders[1].trim())) {
                order.addExtras(extras.get(subOrders[1].trim()));
            }

        } else {
            if(products.containsKey(product)) {
                order.addProduct(products.get(product));
            }
        }

    }



    public Integer getCustomersCoffeeCount(String name) {
        return customersCoffeeCount.get(name);
    }

    public void addCustomersCoffeeCount(String name) {
        customersCoffeeCount.get(name);
    }

    public void setCustomersCoffeeCount(Map<String, Integer> customersCoffeeCount) {
        this.customersCoffeeCount = customersCoffeeCount;
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<String, Product> products) {
        this.products = products;
    }

    public Map<String, Extras> getExtras() {
        return extras;
    }

    public void setExtras(Map<String, Extras> extras) {
        this.extras = extras;
    }

    public Map<String, Integer> getCustomersCoffeeCount() {
        return customersCoffeeCount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
