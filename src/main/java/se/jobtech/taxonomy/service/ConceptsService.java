package se.jobtech.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jobtech.taxonomy.client.api.PublicApi;
import se.jobtech.taxonomy.client.model.Response3166;
import se.jobtech.taxonomy.client.model.Response3179;
import se.jobtech.taxonomy.domain.ConceptEntity;
import se.jobtech.taxonomy.repository.ConceptRepository;

import java.util.ArrayList;
import java.util.List;


/**
 * PublicApi* | [**v0TaxonomyPublicSearchGet**](docs/PublicApi.md#v0TaxonomyPublicSearchGet) |
 * **GET** /v0/taxonomy/public/search | get concepts by part of string
 */
@Service
public class ConceptsService {

    @Autowired
    private ConceptRepository conceptRepository;


    @Autowired
    private PublicApi apiInstance;


    public List<Response3179> getConcepts(Long fromVersion, Long toVersion) {


        return apiInstance.v0TaxonomyPublicReplacedByChangesGet(fromVersion, toVersion);
/*
        List<ConceptsEntity> conceptsEntities = new ArrayList<>();
        for (Response3179 resp : response) {

            ConceptsEntity conceptsEntity = new ConceptsEntity(resp.getPreferredLabel(), resp.getType(), resp.isDeprecated(), resp.getDefinition(), resp.getId());

            conceptsEntities.add(conceptsEntity);
            conceptsRepository.save(conceptsEntity);

        }
        return conceptsEntities;*/
    }

    public List<ConceptEntity> taxonomyPublicApiConcepts(String id, String preferredLabel, String type, boolean deprecated, Long offset, Long limit, Long version) {


        List<Response3166> response = apiInstance.v0TaxonomyPublicConceptsGet(id, preferredLabel, type, deprecated, offset, limit, version);

        List<ConceptEntity> conceptsEntities = new ArrayList<>();
        for (Response3166 resp : response) {

            ConceptEntity conceptEntity = new ConceptEntity(resp.getPreferredLabel(), resp.getType(), resp.getDefinition(), resp.getId());

            conceptsEntities.add(conceptEntity);
            conceptRepository.save(conceptEntity);
        }
        //  conceptsRepository.saveAll(conceptsEntities);
        return conceptsEntities;
    }
}

