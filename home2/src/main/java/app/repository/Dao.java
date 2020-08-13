package app.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Dao<T> {
    T save(T obj);
    boolean delete(T obj);
    void deleteAll(List<T> entities);
    void saveAll(List<T> entities);
    List<T> findAll();
    boolean deleteById(Long id);
    T getOne(Long id);
}
