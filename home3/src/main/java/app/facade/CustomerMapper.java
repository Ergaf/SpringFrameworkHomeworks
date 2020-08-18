package app.facade;

import app.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomerMapper {

//    @Override
//    public Customer toEntity(UnicornDto dto) {
//        return Objects.isNull(dto) ? null : MPG.mapper.map(dto, Unicorn.class);
//    }
//
//    @Override
//    public UnicornDto toDto(Customer entity) {
//        return Objects.isNull(entity) ? null : MPG.mapper.map(entity, UnicornDto.class);
//    }
}
