package nl.scalda;

import nl.scalda.domain.Product;
import nl.scalda.persistence.factories.DAOFactories;
import nl.scalda.persistence.factories.DAOFactory;
import nl.scalda.persistence.util.HibernateSessionManager;

public class Database {

    public static void main(String[] args) {

        DAOFactory.setFactory(DAOFactories.HIBERNATE.getFactory());
        HibernateSessionManager.init();

        Product p1 = new Product("Airpods", 180, "Mooi geluid en handig om mee te nemen", 100);
        DAOFactory.getFactory().getProductDAO().save(p1);

        Product p2 = new Product("Macbook", 2000, "Snelle computer met hoge kwaliteit", 68);
        DAOFactory.getFactory().getProductDAO().save(p2);


        HibernateSessionManager.destroy();
    }
}
