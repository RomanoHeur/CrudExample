package nl.scalda.controller;

import nl.scalda.domain.Product;

public class BewerkenAction {

    private int id;
    private String naam;
    private double prijs;
    private String beschrijving;
    private int hoeveelheid;

    public String bewerken() {
        Product product = new Product();

        product.productBewerken(id, naam, prijs, beschrijving, hoeveelheid);

        return "SUCCESS";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public int getHoeveelheid() {
        return hoeveelheid;
    }

    public void setHoeveelheid(int hoeveelheid) {
        this.hoeveelheid = hoeveelheid;
    }
}
