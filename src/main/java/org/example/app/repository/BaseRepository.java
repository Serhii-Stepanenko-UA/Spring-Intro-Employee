package org.example.app.repository;

import java.util.Map;
import java.util.Optional;

public interface BaseRepository<ID,T> {
    T create(T entity);
    Optional<Map<ID,T>> getAll();
    Optional<T> getById(ID id);
    T update(T entity);
    boolean deleteById(ID id);
}
