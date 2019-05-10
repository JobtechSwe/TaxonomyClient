package se.jobtech.taxonomy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.jobtech.taxonomy.domain.ConceptHistoryEntity;
import se.jobtech.taxonomy.service.ConceptHistorySinceService;

import java.util.List;


@RestController
public class TaxonomyController {

    @Autowired
    ConceptHistorySinceService conceptHistorySinceService = new ConceptHistorySinceService( );

    public TaxonomyController() {
        super( );
    }

    public TaxonomyController( ConceptHistorySinceService conceptHistorySinceService ) {
        this.conceptHistorySinceService = conceptHistorySinceService;

    }


    @GetMapping("/Allconsepthistory")
    private List<ConceptHistoryEntity> getAllHistorys() {

        return conceptHistorySinceService.taxonomyPublicApiConceptFullHistory( );
    }


    @GetMapping("/AllconsepthistoryFromDate/{dateTime}")
    @ResponseBody
    private List<ConceptHistoryEntity> getAllHistorysSince( @PathVariable String dateTime ) {
        return conceptHistorySinceService.taxonomyPublicApiConceptHistorySinceGet( dateTime );
    }


    @GetMapping("/DrivinglicenseFromDate/{dateTime}")
    @ResponseBody
    private List<ConceptHistoryEntity> getAllDrivingLicenseSincee( @PathVariable String dateTime ) {
        return conceptHistorySinceService.taxonomyPublicApiConceptDrivingLicense( dateTime );
    }


    @GetMapping("/OccupationnameFromDate/{dateTime}")
    @ResponseBody
    private List<ConceptHistoryEntity> getAllCccupationname( @PathVariable String dateTime ) {

        return conceptHistorySinceService.taxonomyPublicApiConceptOccupationname( dateTime );
    }


    @GetMapping("/OccupationgroupFromDate/{dateTime}")
    @ResponseBody
    private List<ConceptHistoryEntity> getAllCccupationGroup( @PathVariable String dateTime ) {

        return conceptHistorySinceService.taxonomyPublicApiConceptOccupationgroup( dateTime );
    }

    @GetMapping("/OccupationfieldFromDate{dateTime}")
    @ResponseBody
    private List<ConceptHistoryEntity> getAllCccupationFieldFromDate( @PathVariable String dateTime ) {

        return conceptHistorySinceService.taxonomyPublicApiConceptOccupationField( dateTime );
    }

    @GetMapping("/SkillHeadline/{dateTime}")
    @ResponseBody
    private List<ConceptHistoryEntity> getAllCccupationSkillHeadline( @PathVariable String dateTime ) {

        return conceptHistorySinceService.taxonomyPublicApiConceptOccupationSkillHeadline( dateTime );
    }

    @GetMapping("/SkillFromDate/{date}")
    @ResponseBody
    private List<ConceptHistoryEntity> getAllCccupationSkill( @PathVariable String dateTime ) {

        return conceptHistorySinceService.taxonomyPublicApiConceptOccupationSkill( dateTime );
    }

}
