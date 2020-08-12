package app.repository;

import java.util.List;

public class CustomerDaoHibernate implements Dao{
    @Override
    public Object save(Object obj) {
        return null;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }

    @Override
    public void deleteAll(List entities) {

    }

    @Override
    public void saveAll(List entities) {

    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public Object getOne(Long id) {
        return null;
    }
}
