//package app.repository;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Service;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//@Service
//public class EmGet {
//    public EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit01");
//    public EntityManager em = factory.createEntityManager();
//    public EntityTransaction transaction = em.getTransaction();
//    @Bean
//    public EntityManager entityManagerGen(){
//        return em;
//    }
//
//    @Bean
//    public EntityTransaction EntityTransactionGen(){
//        return transaction;
//    }
//}
