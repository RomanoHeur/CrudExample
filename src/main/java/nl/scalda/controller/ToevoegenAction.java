package nl.scalda.controller;

import nl.scalda.domain.Product;

public class ToevoegenAction {
    private String naam;
    private double prijs;
    private String beschrijving;
    private int hoeveelheid;

    public String toevoegen() {
        Product product = new Product(naam, prijs, beschrijving, hoeveelheid);
        product.productAanmaken();

        return "SUCCESS";
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
