package app.facade;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MPG {
    static public ModelMapper mapper = new ModelMapper();
}
