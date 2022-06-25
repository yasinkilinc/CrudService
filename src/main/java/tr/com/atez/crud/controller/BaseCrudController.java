package tr.com.atez.crud.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tr.com.atez.crud.exception.ExceptionDef;
import tr.com.atez.crud.exception.TDSException;
import tr.com.atez.crud.model.dto.BaseDTO;
import tr.com.atez.crud.service.BaseService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
@Slf4j
@Service
public abstract class BaseCrudController<ID extends Serializable, D extends BaseDTO, S extends BaseService> {
    
    private final S service;

    @PostMapping
    public ResponseEntity<D> create(@Valid @RequestBody D dto){
        log.debug("REST request to save Object : {}", dto);
        if (dto.getId() != null) {
            throw new TDSException(ExceptionDef.GLOBAL_ID_EXISTS, "country", dto.getId());
        }
        D result = (D)service.saveDto(dto);
        return ResponseEntity.ok(result);
    }


    @PutMapping("/{id}")
    public ResponseEntity<D> update(@PathVariable(value = "id", required = false) final ID id,
                                                    @Valid @RequestBody D dto) throws Throwable {
        log.debug("REST request to update Object : {}, {}", id, dto);
        if(dto.getId() == null) {
            // throw new TDSException(ExceptionDef.GLOBAL_ID_NOT_NULL, dto);
        }
        if (!Objects.equals(id, dto.getId())) {
            // throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid"); }
        }
        if (!service.existsById(id)){
            // throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"); }
        }
        D result = (D) service.update(dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        log.debug("REST request to delete Object : {}", id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<D> partialUpdate(@PathVariable(value = "id", required = false) final ID id,
    @NotNull @RequestBody D dto) throws Throwable {
        log.debug("REST request to partial update Country partially : {}, {}", id, dto);
        if (dto.getId() == null) {
           // throw new TDSException(ExceptionDef.GLOBAL_ID_NOT_NULL, dto);
        }
        if (!Objects.equals(id, dto.getId())) {
           // throw new TDSException(ExceptionDef.GLOBAL_INVALID_ID, id, dto.getId());
        }

        if (!service.existsById(id)) {
           // throw new TDSException(ExceptionDef.GLOBAL_ID_NOT_EXISTS);
        }
        Optional<D> result = service.partialUpdate(dto);
        return ResponseEntity.ok( result.get() );
    }

    @GetMapping
    public ResponseEntity<List<D>> getAll(Pageable pageable) {
        log.debug("REST request to get a page of Objects");
        List<D> list = service.findAllToDto(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public D get(@PathVariable ID id) throws Throwable {
        log.debug("REST request to get Object : {}", id);
        return (D)service.findByIdToDto(id);
    }

}
