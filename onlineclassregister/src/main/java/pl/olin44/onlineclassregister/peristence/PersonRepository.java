package pl.olin44.onlineclassregister.peristence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Long>, QueryByExampleExecutor<PersonEntity> {

}
