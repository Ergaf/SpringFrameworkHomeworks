package app;

import app.entities.Account;
import app.entities.Customer;
import app.entities.Employer;
import app.repository.EmGet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit01");
//        EntityManager em = factory.createEntityManager();
//        EntityTransaction transaction = em.getTransaction();
//

//        transaction.begin();
//        Employer e = new Employer();
//        e.setAddress("magadan");
//        e.setCompanyName("abdelprom");
//        //запихнуть в бд (метод войд)
////        em.persist(e);
//        //запихнуть в бд (метод возвращает измененный обьект из бд)
//        Employer eReturn = em.merge(e);
//
//        System.out.println("запихнуло в базу: "+eReturn);
//        transaction.commit();
////---------------------------------------------
//        transaction.begin();
//        Employer eFind = em.find(Employer.class, 1L);
//
//        System.out.println("то что нашло в бд: "+eFind);
//        transaction.commit();
//
//        transaction.begin();
//        Customer customer = new Customer();
//        customer.setName("vasia");
//        em.persist(customer);
//        transaction.commit();
//
//        transaction.begin();
//        Employer finded = em.find(Employer.class, 1L);
//        Customer findedC = em.find(Customer.class, 1L);
//        findedC.getEmployers().add(finded);
//        finded.getCustomers().add(findedC);
//        em.merge(finded);
//        transaction.commit();
//
//        transaction.begin();
//        System.out.println(em.find(Employer.class, 1L));
//        transaction.commit();


    }
}
