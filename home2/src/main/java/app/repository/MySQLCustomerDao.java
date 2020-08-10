package app.repository;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MySQLCustomerDao implements Dao{

//    static {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
////        DriverManager.registerDriver(new My);
//    }

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

    Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/?allowPublicKeyRetrieval=true&useSSL=false", "root", "12346");
    }
}
