package app.repository;

import java.util.List;

public interface Dao<T> {
    T save(T obj);
    boolean delete(T obj);
    void deleteAll(List<T> entities);
    void saveAll(List<T> entities);
    List<T> findAll();
    boolean deleteById(Long id);
    T getOne(Long id);
}
