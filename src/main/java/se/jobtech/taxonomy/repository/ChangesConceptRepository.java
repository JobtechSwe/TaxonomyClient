package se.jobtech.taxonomy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.jobtech.taxonomy.domain.ChangesConceptEntity;


@Transactional
@Repository
public interface ChangesConceptRepository extends CrudRepository<ChangesConceptEntity, Long> {

}
