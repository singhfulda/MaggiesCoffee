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
        products.put("small Coffee", new Product("small Coffee", 2.50, Product.ProductType.BEVERAGE));
        products.put("medium Coffee", new Product("small Coffee", 3.50, Product.ProductType.BEVERAGE));
        products.put("large Coffee", new Product("small Coffee", 4.00, Product.ProductType.BEVERAGE));
        products.put("Bacon Roll", new Product("small Coffee", 3.25, Product.ProductType.SNACK));
        products.put("Freshly squeezed orange juice", new Product("small Coffee", 4.35, Product.ProductType.BEVERAGE));
        extras.put("Cold milk", new Extras("small Coffee", 0.30));
        extras.put("Foamed milk",  new Extras("small Coffee", 0.50));
        extras.put("Special roast coffee",  new Extras("small Coffee", 1.20));

    }

    public void processOrder(String orderString) {
        String str[] = orderString.split(",");
        for (String productWithExtras : str) {
            System.out.println(productWithExtras);
            addProductsAndExtrasToOrder(productWithExtras);
        }
        checkOrderForBonus(order);
        printOrder(order);
    }

    private void printOrder(Order order) {
    }


    private void checkOrderForBonus(Order order) {
    }


    private void addProductsAndExtrasToOrder(String product) {
        if(product.contains("with")) {
            String subOrders[] = product.split(" with ");
            order.addProduct(products.get(subOrders[0]));
            order.addExtras(extras.get(subOrders[1]));

        } else {
           order.addProduct(products.get(product));
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
}
