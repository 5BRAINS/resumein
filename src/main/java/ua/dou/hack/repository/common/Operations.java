package ua.dou.hack.repository.common;

import java.io.Serializable;

public interface Operations<T, PK extends Serializable> {
    /**
     * Persist the newInstance object into database
     */
    PK create(T newInstance);

    /**
     * Retrieve an object that was previously persisted to the database using
     * the indicated id as primary key
     */
    T read(PK id);

    /**
     * Save changes made to a persistent object.
     */
    void update(T transientObject);

    /**
     * Remove an object from persistent storage in the database
     */
    void delete(T persistentObject);

    void merge(T object);

    void saveOrUpdate(T object);
}