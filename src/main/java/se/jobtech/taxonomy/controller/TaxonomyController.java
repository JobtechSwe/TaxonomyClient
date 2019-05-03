package se.jobtech.taxonomy.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.jobtech.taxonomy.domain.ConceptHistoryEntity;
import se.jobtech.taxonomy.service.ConceptHistorySinceService;

import java.util.List;


@RestController
public class TaxonomyController {
    final ConceptHistorySinceService conceptHistorySinceService;

    public TaxonomyController( ConceptHistorySinceService conceptHistorySinceService ) {
        this.conceptHistorySinceService = conceptHistorySinceService;
    }


    @GetMapping("/Allconsepthistory")
    private List<ConceptHistoryEntity> getAllHistorysSince() {

        String dateTime = "2015-08-08 14:00:00";

        return conceptHistorySinceService.taxonomyPublicApiConceptHistorySinceGet( dateTime );
    }


    @GetMapping("/drivinglicense")
    private List<ConceptHistoryEntity> getAllDrivingLicense() {

        String dateTime = "2015-08-08 14:00:00";

        return conceptHistorySinceService.taxonomyPublicApiConceptDrivingLicense( dateTime );
    }


    @GetMapping("/occupationname")
    private List<ConceptHistoryEntity> getAllCccupationname() {

        String dateTime = "2015-08-08 14:00:00";

        return conceptHistorySinceService.taxonomyPublicApiConceptccupationname( dateTime );
    }


    @GetMapping("/occupationgroup")
    private List<ConceptHistoryEntity> getAllCccupationGroup() {

        String dateTime = "2015-08-08 14:00:00";

        return conceptHistorySinceService.taxonomyPublicApiConceptccupationgroup( dateTime );
    }

    @GetMapping("/occupationfield")
    private List<ConceptHistoryEntity> getAllCccupationField() {

        String dateTime = "2015-08-08 14:00:00";

        return conceptHistorySinceService.taxonomyPublicApiConceptccupationField( dateTime );
    }

    @GetMapping("/skill-headline")
    private List<ConceptHistoryEntity> getAllCccupationSkillHeadline() {

        String dateTime = "2015-08-08 14:00:00";

        return conceptHistorySinceService.taxonomyPublicApiConceptccupationSkillHeadline( dateTime );
    }

    @GetMapping("/skill")
    private List<ConceptHistoryEntity> getAllCccupationSkill() {

        String dateTime = "2015-08-08 14:00:00";

        return conceptHistorySinceService.taxonomyPublicApiConceptccupationSkill( dateTime );
    }



    /*

    occupation-field

    skill-headline
            skill
            */
}
