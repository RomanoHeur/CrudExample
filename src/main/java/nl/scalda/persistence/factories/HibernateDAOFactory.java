package nl.scalda.persistence.factories;

import nl.scalda.domain.Product;
import nl.scalda.persistence.dao.GenericDAO;
import nl.scalda.persistence.dao.ProductDAO;
import nl.scalda.persistence.interfaces.IProductDAO;
import nl.scalda.persistence.util.HibernateSessionManager;
import org.hibernate.Session;

public class HibernateDAOFactory extends DAOFactory{

    protected Session getCurrentSession() {
        return HibernateSessionManager.getSessionFactory().getCurrentSession();
    }

    @Override
    public IProductDAO getProductDAO() {
        GenericDAO<Product, Integer> dao = null;
        try {
            dao = ProductDAO.class.getDeclaredConstructor().newInstance();
            dao.setSession(getCurrentSession());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (IProductDAO) dao;
    }

}
