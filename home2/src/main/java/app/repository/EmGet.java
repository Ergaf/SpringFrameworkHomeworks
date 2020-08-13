package app.repository;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Service
public class EmGet {
    public static EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit01");
    public static EntityManager em = factory.createEntityManager();
    public static EntityTransaction transaction = em.getTransaction();

}
