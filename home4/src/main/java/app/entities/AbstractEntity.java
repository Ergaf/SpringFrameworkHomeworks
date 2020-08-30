package app.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@MappedSuperclass
//@Setter
//@Getter
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String createdDate;
    String lastModifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @PrePersist
    public void beforeSave(){
        System.out.println("сохранили обьект в бд");
        LocalDateTime logDateTime = new Timestamp(System.currentTimeMillis()).toLocalDateTime();
        String time = logDateTime.getDayOfMonth()+"/"+
                logDateTime.getMonthValue()+"/"+
                logDateTime.getYear()+" "+
                logDateTime.getHour()+":"+
                logDateTime.getMinute()+" "+
                logDateTime.getSecond();
        this.setCreatedDate(time);
    }

    @PreUpdate
    public void PreUpdate(){
        System.out.println("обновили обьект в бд");
        LocalDateTime logDateTime = new Timestamp(System.currentTimeMillis()).toLocalDateTime();
        String time = logDateTime.getDayOfMonth()+"/"+
                logDateTime.getMonthValue()+"/"+
                logDateTime.getYear()+" "+
                logDateTime.getHour()+":"+
                logDateTime.getMinute()+" "+
                logDateTime.getSecond();
        this.setLastModifiedDate(time);
    }
}
