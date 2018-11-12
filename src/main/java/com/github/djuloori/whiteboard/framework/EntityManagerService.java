package com.github.djuloori.whiteboard.framework;

import javax.persistence.TypedQuery;

public interface EntityManagerService {

    void save(Object var1);

    <T> TypedQuery<T> createQuery(String var1, Class<T> var2);

    <T> T update(T var1);

    <T> void delete(Class<T> var1, String var2);

}
