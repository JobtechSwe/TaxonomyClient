package se.jobtech.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jobtech.taxonomy.client.api.PublicApi;
import se.jobtech.taxonomy.client.model.Response3168;
import se.jobtech.taxonomy.domain.ChangesConceptEntity;
import se.jobtech.taxonomy.repository.ChangesConceptRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class SearchConceptService {
    @Autowired
    private ChangesConceptRepository changesConceptRepository;

    @Autowired
    private PublicApi apiInstance;


    /**
     * Search concept list.
     *
     * @param q      the q
     * @param type   the type
     * @param offset the offset
     * @param limit  the limit
     * @return the list
     */
    public List<ChangesConceptEntity> searchConcept(String q, String type, Long offset, Long limit, Long version) {
        List<Response3168> response = apiInstance.v0TaxonomyPublicSearchGet(q, type, offset, limit, version);
        List<ChangesConceptEntity> conceptEntities = new ArrayList<>();
        for (Response3168 resp : response) {

            ChangesConceptEntity changesConceptEntity = new ChangesConceptEntity(resp.getPreferredLabel(), resp.getType(), null,
                    null, null, resp.getId(), null, version);
            conceptEntities.add(changesConceptEntity);
            changesConceptRepository.save(changesConceptEntity);
        }
        return conceptEntities;
    }


}

