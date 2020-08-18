package app.repository;

import app.entities.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class EmployerDaoHibernate implements Dao{
    @Autowired
    EntityManager em;

    @Override
    public Employer save(Object obj) {
//        EmGet.transaction.begin();
        Employer employer = em.merge((Employer)obj);
//        EmGet.transaction.commit();
        return employer;
    }

    @Override
    public boolean delete(Object obj) {
        Employer acc = (Employer)obj;
        Employer employer = em.find(Employer.class, acc.getId());

//        EmGet.transaction.begin();
        em.remove(employer);
//        EmGet.transaction.commit();
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
        return em.createNativeQuery("SELECT * FROM employer", Employer.class).getResultList();
    }

    @Override
    public boolean deleteById(Long id) {
        Employer employer = em.find(Employer.class, id);
//        EmGet.transaction.begin();
        em.remove(employer);
//        EmGet.transaction.commit();
        return true;
    }

    @Override
    public Employer getOne(Long id) {
        return em.find(Employer.class, id);
    }
}
