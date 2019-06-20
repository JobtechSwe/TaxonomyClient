package se.jobtech.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jobtech.taxonomy.client.api.PublicApi;
import se.jobtech.taxonomy.client.model.Response2980;
import se.jobtech.taxonomy.domain.ConceptHistoryEntity;
import se.jobtech.taxonomy.domain.ConceptSkillEntity;
import se.jobtech.taxonomy.repository.ConceptHistoryRepository;
import se.jobtech.taxonomy.repository.ConceptSkillRepository;

import java.util.ArrayList;
import java.util.List;


/**
 *PublicApi* | [**v0TaxonomyPublicSearchGet**](docs/PublicApi.md#v0TaxonomyPublicSearchGet) |
 * **GET** /v0/taxonomy/public/search | get concepts by part of string

 */
@Service
public class SearchConceptService {

    @Autowired
    private ConceptHistoryRepository historyRepository;

    @Autowired
    private ConceptSkillRepository skillRepository;

    @Autowired
    private PublicApi apiInstance;




    public List<ConceptHistoryEntity> searchConcept( String q, String type, Long offset, Long limit ) {
        List<Response2980> response = apiInstance.v0TaxonomyPublicSearchGet( q,type,offset,limit );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );
        for (Response2980 resp : response) {

            ConceptHistoryEntity conceptHistoryEntity = new ConceptHistoryEntity( resp.getPreferredLabel( ), resp.getType( ), null,
                    null, null, null, null );
            conceptHistoryEntities.add( conceptHistoryEntity );
        // historyRepository.save( conceptHistoryEntity );
        }
        return conceptHistoryEntities;
    }





}

