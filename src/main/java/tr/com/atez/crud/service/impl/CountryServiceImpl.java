package tr.com.atez.crud.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.atez.crud.model.dto.CountryDTO;
import tr.com.atez.crud.model.entity.Country;
import tr.com.atez.crud.model.mapper.CountryMapper;
import tr.com.atez.crud.repository.CountryJPARepository;
import tr.com.atez.crud.service.CountryService;

import java.util.UUID;

@Transactional
@Service
public class CountryServiceImpl extends BaseServiceImpl<UUID, Country, CountryDTO, CountryMapper, CountryJPARepository> implements CountryService {

        private final CountryMapper countryMapper;
        private final CountryJPARepository countryJPARepository;

        public CountryServiceImpl(CountryMapper mapper, CountryJPARepository jpaRepository) {
                super(jpaRepository, mapper);
                this.countryMapper = mapper;
                this.countryJPARepository = jpaRepository;
        }
}
