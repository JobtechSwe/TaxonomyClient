package se.jobtech.taxonomy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.jobtech.taxonomy.domain.ConceptHistoryEntity;
import se.jobtech.taxonomy.domain.ConceptSkillEntity;
import se.jobtech.taxonomy.domain.ConceptsEntity;
import se.jobtech.taxonomy.service.ChangesConceptService;
import se.jobtech.taxonomy.service.ConceptsService;
import se.jobtech.taxonomy.service.SearchConceptService;

import java.util.List;


/**
 * The type Taxonomy controller.
 */
@RestController
public class TaxonomyController {

    /**
     * The Concept history since service.
     */
    @Autowired
    ChangesConceptService conceptHistoryService = new ChangesConceptService( );

    /**
     * The Search concept service.
     */
    @Autowired
    SearchConceptService searchConceptService = new SearchConceptService( );
    /**
     * The Concepts service.
     */
    @Autowired
    ConceptsService conceptsService = new ConceptsService( );

    /**
     * Instantiates a new Taxonomy controller.
     */
    public TaxonomyController() {

        super( );
    }

    /**
     * Instantiates a new Taxonomy controller.
     *
     * @param conceptHistoryService the concept history since service
     */
    public TaxonomyController( ChangesConceptService conceptHistoryService ) {
        this.conceptHistoryService = conceptHistoryService;

    }

    //CHANGE****************************************************************************************************************
    @GetMapping("/Allconsepthistory")
    private List<ConceptHistoryEntity> getAllHistorys() {

        return conceptHistoryService.taxonomyPublicApiConceptFullHistory( );
    }


    @GetMapping("/AllconsepthistoryFromDate/{dateTime}")
    @ResponseBody
    private List<ConceptHistoryEntity> getAllHistorysSince( @PathVariable String dateTime ) {
        return conceptHistoryService.ChangeTaxonomyConceptHistorySinceGet( dateTime );
    }


    @GetMapping("/DrivinglicenseFromDate/{dateTime}")
    @ResponseBody
    private List<ConceptHistoryEntity> getAllDrivingLicenseFromDate( @PathVariable String dateTime ) {
        return conceptHistoryService.ChangeTaxonomyPublicApiConceptDrivingLicense( dateTime );
    }


    @GetMapping("/OccupationnameFromDate/{dateTime}")
    @ResponseBody
    private List<ConceptHistoryEntity> getAllCccupationnameFromDate( @PathVariable String dateTime ) {

        return conceptHistoryService.taxonomyPublicApiConceptOccupationname( dateTime );
    }


    @GetMapping("/OccupationgroupFromDate/{dateTime}")
    @ResponseBody
    private List<ConceptHistoryEntity> getAllCccupationGroupFromDate( @PathVariable String dateTime ) {

        return conceptHistoryService.taxonomyPublicApiConceptOccupationgroup( dateTime );
    }

    @GetMapping("/OccupationfieldFromDate{dateTime}")
    @ResponseBody
    private List<ConceptHistoryEntity> getAllCccupationFieldFromDate( @PathVariable String dateTime ) {

        return conceptHistoryService.taxonomyPublicApiConceptOccupationField( dateTime );
    }

    @GetMapping("/SkillsFromDate/{dateTime}")
    @ResponseBody
    private List<ConceptSkillEntity> getAllCccupationSkillsFromDate( @PathVariable String dateTime ) {

        return conceptHistoryService.taxonomyPublicApiConceptOccupationSkill( dateTime );
    }


    @GetMapping("/SearchSkill/{q}")
    @ResponseBody
    private List<ConceptHistoryEntity> searchSkill( @PathVariable String q ) {
        return searchConceptService.searchConcept( q, "skill", null, null );
    }

    //SEARCH ***************************************************************************************************************
    @GetMapping("/SearchOccupationName/{q}")
    @ResponseBody
    private List<ConceptHistoryEntity> searchOccupationName( @PathVariable String q ) {
        return searchConceptService.searchConcept( q, "occupation-name", null, null );
    }

    //CONCEPTS**************************************************************************************************************

    @GetMapping("/conceptsId/{id}")
    @ResponseBody
    private List<ConceptsEntity> conceptsId( @PathVariable String id ) {
        return conceptsService.getConcepts( id, null, null, true, null, null );

    }

    @GetMapping("/conceptsType/{type}")
    @ResponseBody
    private List<ConceptsEntity> conceptsType( @PathVariable String type ) {
        return conceptsService.getConcepts( null, null, type, false, null, null );
    }


    @GetMapping("/conceptsPreferredLabel/{preferredLabel}")
    @ResponseBody
    private List<ConceptsEntity> conceptsPreferredLabel( @PathVariable String preferredLabel ) {
        return conceptsService.getConcepts( null, preferredLabel, null, false, null, null );
    }

    //LOADTEST**************************************************************************************************************

    @GetMapping("/SearchLoad/{q}")
    @ResponseBody
    private void searchLoadTest( @PathVariable String q ) {
        for (int i = 0; i < 50; i++) {
            char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
            for (char c : alphabet) {
                List<ConceptHistoryEntity> t = searchConceptService.searchConcept( String.valueOf( c ), "occupation-name", null, null );
                List<ConceptHistoryEntity> s = searchConceptService.searchConcept( String.valueOf( c ), "skill", null, null );
            }
        }
    }


}
