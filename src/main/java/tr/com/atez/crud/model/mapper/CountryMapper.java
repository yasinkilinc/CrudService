package tr.com.atez.crud.model.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import tr.com.atez.crud.model.dto.CountryDTO;
import tr.com.atez.crud.model.entity.Country;

@Mapper(componentModel = "spring")
public interface CountryMapper extends EntityMapper<CountryDTO, Country> {

}
