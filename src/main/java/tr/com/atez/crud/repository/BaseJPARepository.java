package tr.com.atez.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import tr.com.atez.crud.model.entity.AbstractBaseEntity;

@NoRepositoryBean
public interface BaseJPARepository<E extends AbstractBaseEntity, ID> extends JpaRepository<E, ID> {

    @Modifying
    @Query(value = "update #{#entityName} t  set t.isDeleted = true where t.id = ?1 ")
    void removeById(ID id);
}
