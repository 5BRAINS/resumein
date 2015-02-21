package ua.dou.hack.service.common;


import org.springframework.transaction.annotation.Transactional;
import ua.dou.hack.repository.common.Operations;

import java.io.Serializable;

@Transactional
public abstract class   AbstractService<T, PK extends Serializable>
    implements Operations<T, PK> {

    @Override
    public PK create(T newInstance) {
        return getRepository().create(newInstance);
    }

    @Override
    public T read(PK id) {
        return getRepository().read(id);
    }

    @Override
    public void update(T transientObject) {
        getRepository().update(transientObject);
    }

    @Override
    public void delete(T persistentObject) {
        getRepository().delete(persistentObject);
    }

    @Override
    public void merge(T object) {
        getRepository().merge(object);
    }

    @Override
    public void saveOrUpdate(T object) {
        getRepository().saveOrUpdate(object);
    }

    protected abstract Operations<T, PK> getRepository();
}