package se.jobtech.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jobtech.taxonomy.client.api.PublicApi;

import se.jobtech.taxonomy.client.model.Response3164;
import se.jobtech.taxonomy.domain.ConceptHistoryEntity;

import se.jobtech.taxonomy.repository.ConceptHistoryRepository;
import se.jobtech.taxonomy.repository.ConceptSkillRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class ChangesConceptService {

    @Autowired
    private ConceptHistoryRepository historyRepository;

    @Autowired

    private ConceptSkillRepository skillRepository;

    @Autowired
    private PublicApi apiInstance;

    /**
     * Taxonomy public api concept full history list. GET /v0/taxonomy/public/changes
     * Show the history from a given version
     *
     * @return ConceptHistoryEntity list
     */
    public List<ConceptHistoryEntity> taxonomyPublicApiConceptFromVersionToVersion( Long fromVersion, Long toVersion, Long offset, Long limit ) {

        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );
        List<Response3164> response = apiInstance.v0TaxonomyPublicChangesGet( fromVersion, toVersion, offset, limit );
        for (Response3164 resp : response) {
            ConceptHistoryEntity conceptHistoryEntity = new ConceptHistoryEntity( resp.getConcept( ).getPreferredLabel( ), resp.getConcept( ).getType( ),
                    resp.getConcept( ).isDeprecated( ), null, null, resp.getConcept( ).getId( ), resp.getEventType( ), resp.getVersion( ) );
            conceptHistoryEntities.add( conceptHistoryEntity );
            historyRepository.save( conceptHistoryEntity );
        }

        return conceptHistoryEntities;
    }


}

