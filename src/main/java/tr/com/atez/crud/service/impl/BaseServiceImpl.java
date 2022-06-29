package tr.com.atez.crud.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.atez.crud.exception.ExceptionDef;
import tr.com.atez.crud.exception.TDSException;
import tr.com.atez.crud.model.mapper.EntityMapper;
import tr.com.atez.crud.model.dto.BaseDTO;
import tr.com.atez.crud.model.entity.AbstractBaseEntity;
import tr.com.atez.crud.repository.BaseJPARepository;

import java.util.List;
import java.util.Optional;

@Transactional
@Slf4j
public abstract class BaseServiceImpl<ID, E extends AbstractBaseEntity, D extends BaseDTO, M extends EntityMapper, R extends BaseJPARepository> {
	
	private final R jpaRepository;
	private final M mapper;

	protected BaseServiceImpl(R jpaRepository, M mapper) {
		this.jpaRepository = jpaRepository;
		this.mapper = mapper;
	}

	@Transactional(readOnly = true)
	public List<E> findAll() {
		return jpaRepository.findAll();
	}

	@Transactional(readOnly = true)
	public List<E> findAllToEntity(Pageable pageable) {
		Page page = jpaRepository.findAll(pageable);
		return (List<E>) page.getContent();
	}

	@Transactional(readOnly = true)
	public List<D> findAllToDto(Pageable pageable) {
		Page page = jpaRepository.findAll(pageable);
		List<D> content = (List<D>) page.getContent();
		return mapper.toDto(content);
	}

	@Transactional(readOnly = true)
	public boolean existsById(ID id) throws Throwable{
		E entity = findById(id);
		return entity.getId() != null;
	}

	@Transactional(readOnly = true)
	public E findById(ID id) throws Throwable {
		return (E) jpaRepository.findById(id)
				.orElseThrow(() -> new TDSException(ExceptionDef.GLOBAL_ID_NOT_EXISTS, id));
	}

	@Transactional(readOnly = true)
	public D findByIdToDto(ID id) throws Throwable {
		return (D) mapper.toDto(jpaRepository.findById(id)
				.orElseThrow(() -> new TDSException(ExceptionDef.GLOBAL_ID_NOT_EXISTS, id)));
	}

	public D saveDto(D dto) {
		log.debug("Request to save : {}", dto);
		E entity = (E) mapper.toEntity(dto);
		entity = (E) save(entity);
		return (D) mapper.toDto(entity);
	}

	public E save(E entity) {
		log.debug("Request to save : {}", entity);
		return (E) jpaRepository.save(entity);
	}

	public E saveAndFlush(E entity) {
		return (E) jpaRepository.saveAndFlush(entity);
	}

	public D update(D dto) {
		log.debug("Request to save Object : {}", dto);
		return saveDto(dto);
	}

	public void saveAll(Iterable<E> entities) {
		jpaRepository.save(entities);
	}

	public void delete(E entity) {
		entity.setDeleted(true);
		jpaRepository.save(entity);
	}

	public void delete(ID id) {
		jpaRepository.removeById(id);
	}

	public Optional<D> partialUpdate(D dto) {
		return jpaRepository.findById(dto.getId()).map(ent -> {
			mapper.partialUpdate(ent, dto);
			return ent;
		}).map(jpaRepository::save).map(mapper::toDto);
	}

}
