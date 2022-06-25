package tr.com.atez.crud.service;

import tr.com.atez.crud.model.dto.CountryDTO;
import tr.com.atez.crud.model.entity.Country;
import tr.com.atez.crud.model.mapper.CountryMapper;
import tr.com.atez.crud.repository.CountryJPARepository;

import java.util.UUID;

public interface CountryService extends BaseService<UUID, Country, CountryDTO, CountryMapper, CountryJPARepository> {

}
