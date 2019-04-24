package se.jobtech.taxonomy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import se.jobtech.taxonomy.domain.ConceptHistoryEntity;


@Transactional
public interface ConceptHistorySinceRepository extends CrudRepository<ConceptHistoryEntity, Long> {

}
