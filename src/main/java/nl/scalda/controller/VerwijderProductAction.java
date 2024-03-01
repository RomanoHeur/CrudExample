package nl.scalda.controller;

import nl.scalda.domain.Product;
import nl.scalda.persistence.factories.DAOFactory;

public class VerwijderProductAction {
    private int id;

    public String verwijderen() {
        Product product = new Product();
        product.productVerwijderen(id);

        return "SUCCESS";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
