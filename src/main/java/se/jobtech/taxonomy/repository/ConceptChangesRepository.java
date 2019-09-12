package se.jobtech.taxonomy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.jobtech.taxonomy.domain.ConceptChangesEntity;


@Transactional
@Repository
public interface ConceptChangesRepository extends CrudRepository<ConceptChangesEntity, Long> {

}
