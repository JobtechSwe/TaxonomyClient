package se.jobtech.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jobtech.taxonomy.client.api.PublicApi;
import se.jobtech.taxonomy.client.model.Response38928;
import se.jobtech.taxonomy.client.model.Response38930;
import se.jobtech.taxonomy.domain.ConceptHistoryEntity;
import se.jobtech.taxonomy.repository.ConceptHistoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConceptHistorySinceService {

    @Autowired
    private ConceptHistoryRepository repository;
    @Autowired
    private PublicApi apiInstance;

    public List<ConceptHistoryEntity> taxonomyPublicApiConceptHistorySinceGet( String dateTime ) {
        List<Response38930> response = apiInstance.taxonomyPublicConceptHistorySinceGet( dateTime );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );
        for (Response38930 resp : response) {
            ConceptHistoryEntity conceptHistoryEntity = new ConceptHistoryEntity( resp.getCategory( ), resp.getPreferredTerm( ), resp.getNewPreferredTerm( ),
                    resp.getOldPreferredTerm( ), resp.isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConceptId( ),
                    resp.getEventType( ) );
            conceptHistoryEntities.add( conceptHistoryEntity );
            repository.save( conceptHistoryEntity );
        }
        return conceptHistoryEntities;
    }


    public List<ConceptHistoryEntity> taxonomyPublicApiConceptFullHistory() {
        List<Response38928> response = apiInstance.taxonomyPublicFullHistoryGet( );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );
        for (Response38928 resp : response) {
            ConceptHistoryEntity conceptHistoryEntity = new ConceptHistoryEntity( resp.getCategory( ), resp.getPreferredTerm( ), resp.getNewPreferredTerm( ),
                    resp.getOldPreferredTerm( ), resp.isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConceptId( ),
                    resp.getEventType( ) );
            conceptHistoryEntities.add( conceptHistoryEntity );
            repository.save( conceptHistoryEntity );
        }
        return conceptHistoryEntities;
    }

    public List<ConceptHistoryEntity> taxonomyPublicApiConceptDrivingLicense( String dateTime ) {
        List<Response38930> response = apiInstance.taxonomyPublicConceptHistorySinceGet( dateTime );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response38930 resp : response) {
            if (resp.getCategory( ).contains( "driving-license" )) {
                ConceptHistoryEntity conceptHistoryEntity = new ConceptHistoryEntity( resp.getCategory( ), resp.getPreferredTerm( ), resp.getNewPreferredTerm( ),
                        resp.getOldPreferredTerm( ), resp.isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConceptId( ),
                        resp.getEventType( ) );
                conceptHistoryEntities.add( conceptHistoryEntity );
                repository.save( conceptHistoryEntity );
            }
        }
        return conceptHistoryEntities;
    }


    public List<ConceptHistoryEntity> taxonomyPublicApiConceptOccupationname( String dateTime ) {
        List<Response38930> response = apiInstance.taxonomyPublicConceptHistorySinceGet( dateTime );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response38930 resp : response) {
            if (resp.getCategory( ).contains( "occupation-name" )) {
                ConceptHistoryEntity conceptHistoryEntity = new ConceptHistoryEntity( resp.getCategory( ), resp.getPreferredTerm( ), resp.getNewPreferredTerm( ),
                        resp.getOldPreferredTerm( ), resp.isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConceptId( ),
                        resp.getEventType( ) );
                conceptHistoryEntities.add( conceptHistoryEntity );
                repository.save( conceptHistoryEntity );
            }
        }
        return conceptHistoryEntities;
    }


    public List<ConceptHistoryEntity> taxonomyPublicApiConceptOccupationgroup( String dateTime ) {
        List<Response38930> response = apiInstance.taxonomyPublicConceptHistorySinceGet( dateTime );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response38930 resp : response) {
            if (resp.getCategory( ).contains( "occupation-group" )) {
                ConceptHistoryEntity conceptHistoryEntity = new ConceptHistoryEntity( resp.getCategory( ), resp.getPreferredTerm( ), resp.getNewPreferredTerm( ),
                        resp.getOldPreferredTerm( ), resp.isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConceptId( ),
                        resp.getEventType( ) );
                conceptHistoryEntities.add( conceptHistoryEntity );
                repository.save( conceptHistoryEntity );
            }
        }
        return conceptHistoryEntities;
    }

    public List<ConceptHistoryEntity> taxonomyPublicApiConceptOccupationField( String dateTime ) {
        List<Response38930> response = apiInstance.taxonomyPublicConceptHistorySinceGet( dateTime );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response38930 resp : response) {
            if (resp.getCategory( ).contains( "occupation-field" )) {
                ConceptHistoryEntity conceptHistoryEntity = new ConceptHistoryEntity( resp.getCategory( ), resp.getPreferredTerm( ), resp.getNewPreferredTerm( ),
                        resp.getOldPreferredTerm( ), resp.isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConceptId( ),
                        resp.getEventType( ) );
                conceptHistoryEntities.add( conceptHistoryEntity );
                repository.save( conceptHistoryEntity );
            }
        }
        return conceptHistoryEntities;
    }

    public List<ConceptHistoryEntity> taxonomyPublicApiConceptOccupationSkillHeadline( String dateTime ) {
        List<Response38930> response = apiInstance.taxonomyPublicConceptHistorySinceGet( dateTime );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response38930 resp : response) {
            if (resp.getCategory( ).contains( "skill-headline" )) {
                ConceptHistoryEntity conceptHistoryEntity = new ConceptHistoryEntity( resp.getCategory( ), resp.getPreferredTerm( ), resp.getNewPreferredTerm( ),
                        resp.getOldPreferredTerm( ), resp.isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConceptId( ),
                        resp.getEventType( ) );
                conceptHistoryEntities.add( conceptHistoryEntity );
                repository.save( conceptHistoryEntity );
            }
        }
        return conceptHistoryEntities;
    }

    public List<ConceptHistoryEntity> taxonomyPublicApiConceptOccupationSkill( String dateTime ) {
        List<Response38930> response = apiInstance.taxonomyPublicConceptHistorySinceGet( dateTime );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response38930 resp : response) {
            if (resp.getCategory( ).contains( "skill" )) {
                ConceptHistoryEntity conceptHistoryEntity = new ConceptHistoryEntity( resp.getCategory( ), resp.getPreferredTerm( ), resp.getNewPreferredTerm( ),
                        resp.getOldPreferredTerm( ), resp.isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConceptId( ),
                        resp.getEventType( ) );
                conceptHistoryEntities.add( conceptHistoryEntity );
                repository.save( conceptHistoryEntity );
            }
        }
        return conceptHistoryEntities;
    }


}