package nl.scalda.domain;

import jakarta.persistence.*;
import nl.scalda.persistence.factories.DAOFactory;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "naam", nullable = false)
    private String naam;

    @Column(name = "prijs", nullable = false)
    private double prijs;

    @Column(name = "beschrijving", nullable = false)
    private String beschrijving;

    @Column(name = "hoeveelheid", nullable = false)
    private int hoeveelheid;

    public Product() {

    }

    public Product(int id, String naam, double prijs, String beschrijving, int hoeveelheid) {
        this.id = id;
        this.naam = naam;
        this.prijs = prijs;
        this.beschrijving = beschrijving;
        this.hoeveelheid = hoeveelheid;
    }

    public Product(String naam, double prijs, String beschrijving, int hoeveelheid) {
        this.naam = naam;
        this.prijs = prijs;
        this.beschrijving = beschrijving;
        this.hoeveelheid = hoeveelheid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Product other = (Product) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + (id == null ? 0 : id.hashCode());

        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                ", prijs=" + prijs +
                ", beschrijving='" + beschrijving + '\'' +
                ", hoeveelheid=" + hoeveelheid +
                '}';
    }

    //Producten kunnen zien op de pagina
    public Set<Product> getAllProducts() {
        return DAOFactory.getFactory().getProductDAO().findAll();
    }

    //Product toevoegen
    public void productAanmaken() {
        Product newProduct = new Product(naam, prijs, beschrijving, hoeveelheid);
        DAOFactory.getFactory().getProductDAO().save(newProduct);
    }

    //Product bewerken
    public void productBewerken(int id, String naam, double prijs, String beschrijving, int hoeveelheid) {
        Product foundProduct = DAOFactory.getFactory().getProductDAO().findById(id).orElse(null);

        foundProduct.setNaam(naam);
        foundProduct.setPrijs(prijs);
        foundProduct.setBeschrijving(beschrijving);
        foundProduct.setHoeveelheid(hoeveelheid);

        DAOFactory.getFactory().getProductDAO().update(foundProduct);
    }

    //Product verwijderen
    public void productVerwijderen(int id) {
       Product foundProduct = DAOFactory.getFactory().getProductDAO().findById(id).orElse(null);

        DAOFactory.getFactory().getProductDAO().delete(foundProduct);
    }
}
