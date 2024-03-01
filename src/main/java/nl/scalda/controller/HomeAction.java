package nl.scalda.controller;

import nl.scalda.domain.Product;

import java.util.Set;

public class HomeAction {
    private Set<Product> products;

    public String home() {
        Product product = new Product();
        products = product.getAllProducts();
        return "SUCCESS";
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
