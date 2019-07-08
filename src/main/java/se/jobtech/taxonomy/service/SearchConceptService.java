package se.jobtech.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jobtech.taxonomy.client.api.PublicApi;
import se.jobtech.taxonomy.client.model.Response2996;
import se.jobtech.taxonomy.domain.ConceptHistoryEntity;
import se.jobtech.taxonomy.repository.ConceptHistoryRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class SearchConceptService {
    @Autowired
    private ConceptHistoryRepository historyRepository;

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
    public List<ConceptHistoryEntity> searchConcept( String q, String type, Long offset, Long limit ) {
        List<Response2996> response = apiInstance.v0TaxonomyPublicSearchGet( q, type, offset, limit );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );
        for (Response2996 resp : response) {

            ConceptHistoryEntity conceptHistoryEntity = new ConceptHistoryEntity( resp.getPreferredLabel( ), resp.getType( ), null,
                    null, null, resp.getId( ), null );
            conceptHistoryEntities.add( conceptHistoryEntity );
            historyRepository.save( conceptHistoryEntity );
        }
        return conceptHistoryEntities;
    }


}

