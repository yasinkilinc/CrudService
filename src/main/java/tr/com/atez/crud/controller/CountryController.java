package tr.com.atez.crud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.atez.crud.model.dto.CountryDTO;
import tr.com.atez.crud.service.CountryService;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1/tds/countries")
public class CountryController extends BaseCrudController<UUID, CountryDTO, CountryService> {

    private final CountryService service;

    public CountryController(CountryService service) {
        super(service);
        this.service = service;
    }
}
