package se.jobtech.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jobtech.taxonomy.client.api.PublicApi;
import se.jobtech.taxonomy.client.model.Response3164;
import se.jobtech.taxonomy.domain.ChangesConceptEntity;
import se.jobtech.taxonomy.repository.ChangesConceptRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class ChangesConceptService {

    @Autowired
    private ChangesConceptRepository changesConceptRepository;


    @Autowired
    private PublicApi apiInstance;

    /**
     * Taxonomy public api concept full history list. GET /v0/taxonomy/public/changes
     * Show the history from a given version
     *
     * @return conceptEntity list
     */
    public List<ChangesConceptEntity> taxonomyPublicApiConceptChangesFromVersionToVersion(Long fromVersion, Long toVersion, Long offset, Long limit) {

        List<ChangesConceptEntity> conceptEntities = new ArrayList<>();
        List<Response3164> response = apiInstance.v0TaxonomyPublicChangesGet(fromVersion, toVersion, offset, limit);
        for (Response3164 resp : response) {
            ChangesConceptEntity changesConceptEntity = new ChangesConceptEntity(resp.getConcept().getPreferredLabel(), resp.getConcept().getType(),
                    resp.getConcept().isDeprecated(), null, null, resp.getConcept().getId(), resp.getEventType(), resp.getVersion());
            conceptEntities.add(changesConceptEntity);
            changesConceptRepository.save(changesConceptEntity);
        }

        return conceptEntities;
    }


}

