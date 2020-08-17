package app.repository;

import app.entities.Employer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployerDaoHibernate implements Dao{
    @Override
    public Employer save(Object obj) {
        EmGet.transaction.begin();
        Employer employer = EmGet.em.merge((Employer)obj);
        EmGet.transaction.commit();
        return employer;
    }

    @Override
    public boolean delete(Object obj) {
        Employer acc = (Employer)obj;
        Employer employer = EmGet.em.find(Employer.class, acc.getId());

        EmGet.transaction.begin();
        EmGet.em.remove(employer);
        EmGet.transaction.commit();
        return true;
    }

    @Override
    public void deleteAll(List entities) {

    }

    @Override
    public void saveAll(List entities) {

    }

    @Override
    public List<Employer> findAll() {
        return EmGet.em.createNativeQuery("SELECT * FROM EMPLOYER", Employer.class).getResultList();
    }

    @Override
    public boolean deleteById(Long id) {
        Employer employer = EmGet.em.find(Employer.class, id);
        EmGet.transaction.begin();
        EmGet.em.remove(employer);
        EmGet.transaction.commit();
        return true;
    }

    @Override
    public Employer getOne(Long id) {
        return EmGet.em.find(Employer.class, id);
    }
}
