package nl.scalda.persistence.dao;

import jakarta.persistence.PersistenceException;
import nl.scalda.persistence.interfaces.IGenericDAO;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.criteria.JpaCriteriaQuery;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class GenericDAO<T, ID extends Serializable> implements IGenericDAO<T, ID> {

    private Class<T> persistentClass;
    private Session session;

    @SuppressWarnings("unchecked")
    public GenericDAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public void setSession(Session s) {
        this.session = s;
    }

    protected Session getSession() {
        if (session == null)
            throw new IllegalStateException("Session has not been set on DAO before usage");
        return session;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @Override
    public T save(T entity) {
        try {
            getSession().beginTransaction();
            getSession().persist(entity);
            getSession().getTransaction().commit();
        } catch (PersistenceException e) {

            entity = null;

            if (getSession().getTransaction() != null)
                getSession().getTransaction().rollback();

            if(e.getCause() instanceof ConstraintViolationException cve) {
                System.out.println(cve.getSQLException().getSQLState());
                throw (ConstraintViolationException) e.getCause();
            }

        }

        return entity;
    }

    @Override
    public Optional<T> findById(ID id) {
        getSession().beginTransaction();
        T entity = 	getSession().find(getPersistentClass(), id);
        getSession().getTransaction().commit();
        return Optional.of(entity);
    }

    @Override
    public Set<T> findAll() {
        getSession().beginTransaction();

        JpaCriteriaQuery<T> query = getSession().getCriteriaBuilder().createQuery(getPersistentClass());
        query.select(query.from(getPersistentClass()));
        List<T> list = getSession().createQuery(query).getResultList();

        getSession().getTransaction().commit();

        return new HashSet<>(list);
    }

    @Override
    public T update(T entity) {
        getSession().beginTransaction();
        getSession().merge(entity);
        getSession().getTransaction().commit();
        return entity;
    }

    @Override
    public void delete(T entity) {
        getSession().beginTransaction();
        getSession().remove(entity);
        getSession().getTransaction().commit();
    }

    public void flush() {
        getSession().flush();
    }

    public void clear() {
        getSession().clear();
    }

}
