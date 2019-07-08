package se.jobtech.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jobtech.taxonomy.client.api.PublicApi;
import se.jobtech.taxonomy.client.model.Response2992;
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
     * Taxonomy public api concept full history list.
     *
     * @return ConceptHistoryEntity list
     */



    public List<ConceptHistoryEntity> taxonomyPublicApiConceptFullHistory() {

        return taxonomyConceptHistorySinceGet( "2000-01-01 00:00:00" );
    }

    /**
     * Change taxonomy concept history since get list.
     *
     * @param fromDateTime the from date time
     * @return conceptHistoryEntities list
     */
    public List<ConceptHistoryEntity> taxonomyConceptHistorySinceGet( String fromDateTime ) {
        List<Response2992> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );
        for (Response2992 resp : response) {


            ConceptHistoryEntity conceptHistoryEntity = new ConceptHistoryEntity( resp.getConcept( ).getPreferredLabel( ), resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ),
                    resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );
            conceptHistoryEntities.add( conceptHistoryEntity );
            historyRepository.save( conceptHistoryEntity );
        }

        return conceptHistoryEntities;
    }

    /**
     * Change taxonomy public api concept driving license list.
     *
     * @param fromDateTime the from date time
     * @return conceptHistoryEntities list
     */
    public List<ConceptHistoryEntity> taxonomyPublicApiConceptDrivingLicense( String fromDateTime ) {
        List<Response2992> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response2992 resp : response) {
            CreateConseptHistory( "driving-license", conceptHistoryEntities, resp.getConcept( ).getPreferredLabel( ),
                    resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );
        }
        return conceptHistoryEntities;
    }

    /**
     * Taxonomy public api concept occupationname list.
     *
     * @param fromDateTime the from date time
     * @return conceptHistoryEntities list
     */
    public List<ConceptHistoryEntity> taxonomyPublicApiConceptOccupationname( String fromDateTime ) {
        List<Response2992> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response2992 resp : response) {
            CreateConseptHistory( "occupation-name", conceptHistoryEntities, resp.getConcept( ).getPreferredLabel( ),
                    resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );
        }
        return conceptHistoryEntities;
    }

    /**
     * Taxonomy public api concept occupationgroup list.
     *
     * @param fromDateTime the from date time
     * @return conceptHistoryEntities list
     */
    public List<ConceptHistoryEntity> taxonomyPublicApiConceptOccupationgroup( String fromDateTime ) {
        List<Response2992> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, null, null );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response2992 resp : response) {
            CreateConseptHistory( "occupation-group", conceptHistoryEntities, resp.getConcept( ).getPreferredLabel( ),
                    resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );
        }
        return conceptHistoryEntities;
    }

    /**
     * Taxonomy public api concept occupation field list.
     *
     * @param fromDateTime the from date time
     * @return conceptHistoryEntities list
     */


    public List<ConceptHistoryEntity> taxonomyPublicApiConceptOccupationField( String fromDateTime ) {
        List<Response2992> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response2992 resp : response) {


            CreateConseptHistory( "occupation-field", conceptHistoryEntities, resp.getConcept( ).getPreferredLabel( ),
                    resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );
        }
        return conceptHistoryEntities;
    }

    /**
     * Taxonomy public api concept occupation skill list.
     *
     * @param fromDateTime the from date time
     * @return conceptHistoryEntities list
     */


    public List<ConceptSkillEntity> taxonomyPublicApiConceptOccupationSkill( String fromDateTime ) {
        List<Response2992> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
        List<ConceptSkillEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response2992 resp : response) {
            CreateConseptSkill( conceptHistoryEntities, "skill", resp.getConcept( ).getPreferredLabel( ),
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

