package tr.com.atez.crud.service;

import org.springframework.data.domain.Pageable;
import tr.com.atez.crud.model.dto.BaseDTO;
import tr.com.atez.crud.model.mapper.EntityMapper;
import tr.com.atez.crud.repository.BaseJPARepository;
import tr.com.atez.crud.model.entity.AbstractBaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseService<ID,E extends AbstractBaseEntity, D extends BaseDTO, M extends EntityMapper, R extends BaseJPARepository> {

	boolean existsById(ID id)throws Throwable;

	E findById(ID id) throws Throwable;

	D findByIdToDto(ID id) throws Throwable;

	List<E> findAll();

	List<E> findAllToEntity(Pageable pageable);

	List<D> findAllToDto(Pageable pageable);

	D saveDto(D dto);

	E save(E entity);

	E saveAndFlush(E entity);

	void saveAll(Iterable<E> entities);

	D update(D dto);

	void delete(E entity);

	void delete(ID id);

	Optional<D> partialUpdate(D dto);

}
