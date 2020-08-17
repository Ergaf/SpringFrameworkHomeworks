package app.repository;

import app.entities.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDaoInMemory implements Dao{
    private final List<Customer> customer = new ArrayList<>();

    @Override
    public Customer save(Object obj) {
//        for(int i = 0; i < customer.size(); i++){
//            if(customer.get(i).equals(obj)){
//                customer.remove((Customer) obj);
//            }
//        }
        customer.add((Customer) obj);
        return (Customer) obj;
    }

    @Override
    public boolean delete(Object obj) {
        return customer.remove((Customer) obj);
    }

    @Override
    public void deleteAll(List entities) {
        customer.clear();
    }

    @Override
    public void saveAll(List entities) {
        customer.containsAll(entities);
    }

    @Override
    public List<Customer> findAll() {
        return customer;
    }

    @Override
    public boolean deleteById(Long id) {
        for(int i = 0; i < customer.size(); i++){
            if(customer.get(i).getId() == id){
                customer.remove(customer.get(i));
                return true;
            }
        }
        return false;
    }

    @Override
    public Customer getOne(Long id) {
        for(int i = 0; i < customer.size(); i++){
            if(customer.get(i).getId() == id){
                return customer.get(i);
            }
        }
        return null;
    }
}
