package se.jobtech.taxonomy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.jobtech.taxonomy.domain.ConceptHistoryEntity;
import se.jobtech.taxonomy.service.ConceptService;

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
    ConceptService conceptHistoryService = new ConceptService( );


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
    public TaxonomyController( ConceptService conceptHistoryService ) {
        this.conceptHistoryService = conceptHistoryService;

    }


    @GetMapping("/Allconsepthistory")
    private List<ConceptHistoryEntity> getAllHistorys() {

        return conceptHistoryService.taxonomyPublicApiConceptFullHistory( );
    }


    @GetMapping("/AllconsepthistoryFromDate/{dateTime}")
    @ResponseBody
    private List<ConceptHistoryEntity> getAllHistorysSince( @PathVariable String dateTime ) {
        return conceptHistoryService.taxonomyConceptHistorySinceGet( dateTime );
    }


    @GetMapping("/DrivinglicenseFromDate/{dateTime}")
    @ResponseBody
    private List<ConceptHistoryEntity> getAllDrivingLicenseFromDate( @PathVariable String dateTime ) {
        return conceptHistoryService.taxonomyPublicApiConceptDrivingLicense( dateTime );
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
    private List<ConceptHistoryEntity> getAllCccupationSkillsFromDate( @PathVariable String dateTime ) {

        return conceptHistoryService.taxonomyPublicApiConceptOccupationSkill( dateTime );
    }


}
