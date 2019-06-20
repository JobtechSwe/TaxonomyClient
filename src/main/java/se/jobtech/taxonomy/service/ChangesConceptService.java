package se.jobtech.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jobtech.taxonomy.client.api.PublicApi;
import se.jobtech.taxonomy.client.model.Response2976;
import se.jobtech.taxonomy.client.model.Response2976;
import se.jobtech.taxonomy.domain.ConceptHistoryEntity;
import se.jobtech.taxonomy.domain.ConceptSkillEntity;
import se.jobtech.taxonomy.repository.ConceptHistoryRepository;
import se.jobtech.taxonomy.repository.ConceptSkillRepository;

import java.util.ArrayList;
import java.util.List;


/**
 * Använder sig av *PublicApi* | [**v0TaxonomyPublicChangesGet**](docs/PublicApi.md#v0TaxonomyPublicChangesGet) |
 * **GET** /v0/taxonomy/public/changes | Show the history since the given date.
 * Use the format yyyy-MM-dd HH:mm:ss (i.e. 2017-06-09 14:30:01).
 */
@Service
public class ChangesConceptService {

    @Autowired
    private ConceptHistoryRepository historyRepository;

    @Autowired
    private ConceptSkillRepository skillRepository;

    @Autowired
    private PublicApi apiInstance;

    /**
     * @return ConceptHistoryEntity
     */
    public List<ConceptHistoryEntity> taxonomyPublicApiConceptFullHistory() {

        return ChangeTaxonomyConceptHistorySinceGet( "2000-01-01 00:00:00" );
    }

    /**
     * @param fromDateTime
     * @return conceptHistoryEntities
     */
    public List<ConceptHistoryEntity> ChangeTaxonomyConceptHistorySinceGet( String fromDateTime ) {
        List<Response2976> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );
        for (Response2976 resp : response) {


            ConceptHistoryEntity conceptHistoryEntity = new ConceptHistoryEntity( resp.getConcept( ).getPreferredLabel( ), resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ),
                    resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );
            conceptHistoryEntities.add( conceptHistoryEntity );
            historyRepository.save( conceptHistoryEntity );
        }

        return conceptHistoryEntities;
    }

    /**
     * @param fromDateTime
     * @return conceptHistoryEntities
     */
    public List<ConceptHistoryEntity> ChangeTaxonomyPublicApiConceptDrivingLicense( String fromDateTime ) {
        List<Response2976> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response2976 resp : response) {
            CreateConseptHistory( "driving-license", conceptHistoryEntities, resp.getConcept( ).getPreferredLabel( ),
                    resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );
        }
        return conceptHistoryEntities;
    }

    /**
     * @param fromDateTime
     * @return conceptHistoryEntities
     */

    public List<ConceptHistoryEntity> taxonomyPublicApiConceptOccupationname( String fromDateTime ) {
        List<Response2976> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response2976 resp : response) {
            CreateConseptHistory( "occupation-name", conceptHistoryEntities, resp.getConcept( ).getPreferredLabel( ),
                    resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );
        }
        return conceptHistoryEntities;
    }

    /**
     * @param fromDateTime
     * @return conceptHistoryEntities
     */

    public List<ConceptHistoryEntity> taxonomyPublicApiConceptOccupationgroup( String fromDateTime ) {
        List<Response2976> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, null, null );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response2976 resp : response) {
            CreateConseptHistory( "occupation-group", conceptHistoryEntities, resp.getConcept( ).getPreferredLabel( ),
                    resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );
        }
        return conceptHistoryEntities;
    }

    /**
     * @param fromDateTime
     * @return conceptHistoryEntities
     */


    public List<ConceptHistoryEntity> taxonomyPublicApiConceptOccupationField( String fromDateTime ) {
        List<Response2976> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response2976 resp : response) {


            CreateConseptHistory( "occupation-field", conceptHistoryEntities, resp.getConcept( ).getPreferredLabel( ),
                    resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );
        }
        return conceptHistoryEntities;
    }

    public List<ConceptHistoryEntity> taxonomyPublicApiConceptOccupationSkillHeadline( String fromDateTime ) {
        List<Response2976> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response2976 resp : response) {


            CreateConseptHistory( "skill-headline", conceptHistoryEntities, resp.getConcept( ).getPreferredLabel( ),
                    resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );
        }

        return conceptHistoryEntities;
    }

    /**
     * @param fromDateTime
     * @return conceptHistoryEntities
     */


    public List<ConceptSkillEntity> taxonomyPublicApiConceptOccupationSkill( String fromDateTime ) {
        List<Response2976> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
        List<ConceptSkillEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response2976 resp : response) {
            CreateConseptSkill( conceptHistoryEntities,"skill", resp.getConcept( ).getPreferredLabel( ),
                    resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );
        }
        return conceptHistoryEntities;
    }


    private void CreateConseptHistory( String s, List<ConceptHistoryEntity> conceptHistoryEntities, String conceptpreferredlabel, String concepttype,
                                       Boolean conceptconceptdeprecated, Long transactionId, String timestamp, String conceptid, String eventType ) {
        if (concepttype.contains( s )) {
            ConceptHistoryEntity conceptHistoryEntity = new ConceptHistoryEntity( conceptpreferredlabel, concepttype,
                    conceptconceptdeprecated, transactionId, timestamp, conceptid, eventType );
            conceptHistoryEntities.add( conceptHistoryEntity );
            historyRepository.save( conceptHistoryEntity );
        }
    }

    private void CreateConseptSkill( List<ConceptSkillEntity> conceptHistoryEntities, String s, String conceptpreferredlabel, String concepttype,
                                     Boolean conceptconceptdeprecated, Long transactionId, String timestamp, String conceptid, String eventType ) {
        if (concepttype.contains( s )) {
            ConceptSkillEntity conceptHistoryEntity = new ConceptSkillEntity( conceptpreferredlabel, concepttype,
                    conceptconceptdeprecated, transactionId, timestamp, conceptid, eventType );
            conceptHistoryEntities.add( conceptHistoryEntity );
            skillRepository.save( conceptHistoryEntity );
        }
    }

}

