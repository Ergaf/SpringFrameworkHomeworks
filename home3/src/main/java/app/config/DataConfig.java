package app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

//@Configuration
//public class DataConfig {
//    @Bean
//    public DataSource dataSource(){
//        System.out.println("сработал конфиг");
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://remotemysql.com:3306/Y2j8wrDQgU?useSSL=false");
//        dataSource.setUsername("Y2j8wrDQgU");
//        dataSource.setPassword("McPhmiw1kN");
//        return dataSource;
//    }
//}
