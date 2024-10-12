package org.example.app.service;

import java.util.Map;

public interface BaseService<ID,T> {
    T create(T entity);
    Map<ID,T> getAll();
    T getById(ID id);
    T update(T entity);
    boolean deleteById(ID id);
}
