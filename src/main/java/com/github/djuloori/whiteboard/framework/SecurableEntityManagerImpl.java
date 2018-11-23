package com.github.djuloori.whiteboard.framework;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Service
public class SecurableEntityManagerImpl implements SecurableEntityManager  {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Object var1) {
        entityManager.persist(var1);
    }

    public <T> TypedQuery<T> createQuery(String var1, Class<T> var2) {
        return entityManager.createNamedQuery(var1,var2);
    }

    public <T> T update(T var1) {
        return entityManager.merge(var1);
    }

    public <T> void delete(Class<T> var1,String var2) {
        Object object = search(var1,var2);
        entityManager.remove(object);
    }

    private <T> T search(Class<T> var1, Object var2) {
        return entityManager.find(var1,var2);
    }

}
