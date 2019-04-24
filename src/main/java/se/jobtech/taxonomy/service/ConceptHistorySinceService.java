package se.jobtech.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import se.jobtech.taxonomy.client.api.PublicApi;
import se.jobtech.taxonomy.client.model.Response38765;
import se.jobtech.taxonomy.domain.ConceptHistoryEntity;
import se.jobtech.taxonomy.repository.ConceptHistorySinceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConceptHistorySinceService {

    private ConceptHistorySinceRepository repository;


    private PublicApi apiInstance = new PublicApi();


    public List<ConceptHistoryEntity> taxonomyPublicApiConceptHistorySinceGet( String dateTime) {
        List<Response38765> response = apiInstance.taxonomyPublicApiConceptHistorySinceGet(dateTime);
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>();
        for (Response38765 resp : response) {
            ConceptHistoryEntity r = repository.save( new ConceptHistoryEntity( resp.getCategory( ), resp.getPreferredTerm( ), resp.getNewPreferredTerm( ),
                    resp.getOldPreferredTerm( ), resp.isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConceptId( ),
                    resp.getEventType( ) ) );
            conceptHistoryEntities.add( repository.save( new ConceptHistoryEntity( resp.getCategory( ), resp.getPreferredTerm( ), resp.getNewPreferredTerm( ),
                    resp.getOldPreferredTerm( ), resp.isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConceptId( ),
                    resp.getEventType( ) ) ));
        }

        return conceptHistoryEntities;
    }





}