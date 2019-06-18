package se.jobtech.taxonomy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.jobtech.taxonomy.domain.ConceptHistoryEntity;
import se.jobtech.taxonomy.domain.ConceptSkillEntity;


@Transactional
@Repository
public interface ConceptSkillRepository extends CrudRepository<ConceptSkillEntity, Long> {

}
