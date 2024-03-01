package nl.scalda.persistence.interfaces;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

public interface IGenericDAO <T, ID extends Serializable> {

    T save(T entity);

    Optional<T> findById(ID id);

    Set<T> findAll();

    T update(T entity);

    void delete(T entity);

}
