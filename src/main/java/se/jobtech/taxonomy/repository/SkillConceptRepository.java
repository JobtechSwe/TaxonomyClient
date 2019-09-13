package se.jobtech.taxonomy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.jobtech.taxonomy.domain.SkillConceptEntity;


@Transactional
@Repository
public interface SkillConceptRepository extends CrudRepository<SkillConceptEntity, Long> {

}
