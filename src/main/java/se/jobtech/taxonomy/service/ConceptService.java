package se.jobtech.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jobtech.taxonomy.client.api.PublicApi;
import se.jobtech.taxonomy.client.model.Response2944;
import se.jobtech.taxonomy.domain.ConceptHistoryEntity;
import se.jobtech.taxonomy.domain.ConceptSkillEntity;
import se.jobtech.taxonomy.repository.ConceptSkillRepository;
import se.jobtech.taxonomy.repository.ConceptHistoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConceptService {

    @Autowired
    private ConceptHistoryRepository repository;

    @Autowired
    private ConceptSkillRepository repositorySkill;

    @Autowired
    private PublicApi apiInstance;

    public List<ConceptHistoryEntity> taxonomyPublicApiConceptFullHistory() {

        return taxonomyConceptHistorySinceGet( "2000-01-01 00:00:00" );
    }

    /**
     * @param fromDateTime
     * @return conceptHistoryEntities
     */
    public List<ConceptHistoryEntity> taxonomyConceptHistorySinceGet( String fromDateTime ) {
        List<Response2944> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );
        for (Response2944 resp : response) {


            ConceptHistoryEntity conceptHistoryEntity = new ConceptHistoryEntity( resp.getConcept( ).getPreferredLabel( ), resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ),
                    resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );
            conceptHistoryEntities.add( conceptHistoryEntity );
            repository.save( conceptHistoryEntity );
        }

        return conceptHistoryEntities;
    }

    /**
     * @param fromDateTime
     * @return conceptHistoryEntities
     */
    public List<ConceptHistoryEntity> taxonomyPublicApiConceptDrivingLicense( String fromDateTime ) {
        List<Response2944> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response2944 resp : response) {
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
        List<Response2944> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response2944 resp : response) {
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
        List<Response2944> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, null, null );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response2944 resp : response) {
            CreateConseptHistory( "occupation-group", conceptHistoryEntities, resp.getConcept( ).getPreferredLabel( ),
                    resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );
        }
        return conceptHistoryEntities;
    }

    /**
     * @param fromDateTime
     * @return conceptHistoryEntities   */


    public List<ConceptHistoryEntity> taxonomyPublicApiConceptOccupationField( String fromDateTime ) {
        List<Response2944> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response2944 resp : response) {


            CreateConseptHistory( "occupation-field", conceptHistoryEntities, resp.getConcept( ).getPreferredLabel( ),
                    resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );
        }
        return conceptHistoryEntities;
    }

    public List<ConceptHistoryEntity> taxonomyPublicApiConceptOccupationSkillHeadline( String fromDateTime ) {
        List<Response2944> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response2944 resp : response) {


            CreateConseptHistory( "skill-headline", conceptHistoryEntities, resp.getConcept( ).getPreferredLabel( ),
                    resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );
        }

        return conceptHistoryEntities;
    }

    /**
     * @param fromDateTime
     * @return conceptHistoryEntities
     */


    public List<ConceptHistoryEntity> taxonomyPublicApiConceptOccupationSkill( String fromDateTime ) {
        List<Response2944> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response2944 resp : response) {
            CreateConseptHistory( "skill", conceptHistoryEntities, resp.getConcept( ).getPreferredLabel( ),
                    resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );


        }
        return conceptHistoryEntities;
    }


    /**
     * @param s
     * @param conceptHistoryEntities
     * @param conceptpreferredlabel
     * @param concepttype
     * @param conceptconceptdeprecated
     * @param transactionId
     * @param timestamp
     * @param conceptid
     * @param eventType
     */

    private void CreateConseptHistory( String s, List<ConceptHistoryEntity> conceptHistoryEntities, String conceptpreferredlabel, String concepttype,
                                       Boolean conceptconceptdeprecated, Long transactionId, String timestamp, String conceptid, String eventType ) {
        if (concepttype.contains( s )) {
            ConceptHistoryEntity conceptHistoryEntity = new ConceptHistoryEntity( conceptpreferredlabel, concepttype,
                    conceptconceptdeprecated, transactionId, timestamp, conceptid, eventType );
            conceptHistoryEntities.add( conceptHistoryEntity );
            repository.save( conceptHistoryEntity );
        }
    }

    private void CreateConseptSkill( List<ConceptSkillEntity> conceptHistoryEntities, String s, String conceptpreferredlabel, String concepttype,
                                     Boolean conceptconceptdeprecated, Long transactionId, String timestamp, String conceptid, String eventType ) {
        if (concepttype.contains( s )) {
            ConceptSkillEntity conceptHistoryEntity = new ConceptSkillEntity( conceptpreferredlabel, concepttype,
                    conceptconceptdeprecated, transactionId, timestamp, conceptid, eventType );
            conceptHistoryEntities.add( conceptHistoryEntity );
            repository.save( conceptHistoryEntity );
        }
    }


}

