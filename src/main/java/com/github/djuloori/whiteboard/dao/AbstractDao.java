package com.github.djuloori.whiteboard.dao;

import com.github.djuloori.whiteboard.framework.EntityManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public abstract class AbstractDao implements EntityManagerService {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public void save(Object var1) {
        getEntityManager().persist(var1);
    }

    public <T> TypedQuery<T> createQuery(String var1, Class<T> var2) {
        return getEntityManager().createNamedQuery(var1,var2);
    }

    public <T> T update(T var1) {
        return getEntityManager().merge(var1);
    }

    public <T> void delete(Class<T> var1,String var2) {
       EntityManager em = getEntityManager();
       Object object = search(var1,var2,em);
       em.remove(object);
    }

    private <T> T search(Class<T> var1, Object var2, EntityManager em) {
        return em.find(var1,var2);
    }

    private EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

}
