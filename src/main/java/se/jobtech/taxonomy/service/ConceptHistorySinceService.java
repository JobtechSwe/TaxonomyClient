package se.jobtech.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import se.jobtech.taxonomy.client.api.PublicApi;

import se.jobtech.taxonomy.client.model.Response38765;
import se.jobtech.taxonomy.domain.ConceptHistoryEntity;
import org.springframework.stereotype.Service;
import se.jobtech.taxonomy.repository.ConceptHistoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConceptHistorySinceService {

@Autowired
    private ConceptHistoryRepository repository;

    private PublicApi apiInstance = new PublicApi();

    public List<ConceptHistoryEntity> taxonomyPublicApiConceptHistorySinceGet( String dateTime) {
        List<Response38765> response = apiInstance.taxonomyPublicApiConceptHistorySinceGet(dateTime);
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>();
        for (Response38765 resp : response) {
            ConceptHistoryEntity conceptHistoryEntity = new ConceptHistoryEntity( resp.getCategory( ), resp.getPreferredTerm( ), resp.getNewPreferredTerm( ),
                    resp.getOldPreferredTerm( ), resp.isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConceptId( ),
                    resp.getEventType( ) );
            conceptHistoryEntities.add(conceptHistoryEntity );
             repository.save( conceptHistoryEntity);
        }
        return conceptHistoryEntities;
    }





}