package tr.com.atez.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import tr.com.atez.crud.model.entity.AbstractBaseEntity;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseJPARepository<E extends AbstractBaseEntity, ID extends Serializable> extends JpaRepository<E, ID> {


}
