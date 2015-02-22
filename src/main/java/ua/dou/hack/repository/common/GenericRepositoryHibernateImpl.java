package ua.dou.hack.repository.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.nio.file.Files;

public class GenericRepositoryHibernateImpl<T, PK extends Serializable>
        implements GenericRepository<T, PK> {
    private Class<T> type;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public PK create(T newInstance) {
        return (PK) getCurrentSession().save(newInstance);
    }

    @Override
    public T read(PK id) {
        return (T) getCurrentSession().get(type, id);
    }

    @Override
    public void update(T transientObject) {
        getCurrentSession().update(transientObject);
    }

    @Override
    public void delete(T persistentObject) {
        getCurrentSession().delete(persistentObject);
    }

    @Override
    public void merge(T object) {
        getCurrentSession().merge(object);
    }

    @Override
    public void saveOrUpdate(T object) {
        getCurrentSession().saveOrUpdate(object);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    protected void setType(Class type) {
        this.type = type;
    }

    protected Class<T> getType() {
        return type;
    }
}