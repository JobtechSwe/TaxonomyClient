package se.jobtech.taxonomy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.jobtech.taxonomy.domain.ConceptHistoryEntity;
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
    ChangesConceptService conceptHistoryService = new ChangesConceptService();

    /**
     * The Search concept service.
     */
    @Autowired
    SearchConceptService searchConceptService = new SearchConceptService();
    /**
     * The Concepts service.
     */
    @Autowired
    ConceptsService conceptsService = new ConceptsService();

    /**
     * Instantiates a new Taxonomy controller.
     */
    public TaxonomyController() {

        super();
    }

    /**
     * Instantiates a new Taxonomy controller.
     *
     * @param conceptHistoryService the concept history since service
     */
    public TaxonomyController(ChangesConceptService conceptHistoryService) {
        this.conceptHistoryService = conceptHistoryService;

    }
    //CHANGE****************************************************************************************************************


    @GetMapping("/concept-changes-fromversion-toversion/{fromVersion}/{toVersion}")
    @ResponseBody

    private List<ConceptHistoryEntity> getConcepts(@PathVariable Long fromVersion, Long toVersion) {

        return conceptHistoryService.taxonomyPublicApiConceptChangesFromVersionToVersion(fromVersion, toVersion, null, null);
    }

    //CONCEPTS**************************************************************************************************************
    @GetMapping("/drivinglicenses-from-version/{version}")
    @ResponseBody
    private List<ConceptsEntity> getAllDrivingLicenseFromVersion(@PathVariable String version ) {
        return conceptsService.taxonomyPublicApiConcepts( null, null, "driving_licence", false, 1L, 10L, 1L );

    }

    @GetMapping("/occupationname-from-version/{version}")
    @ResponseBody
    private List<ConceptsEntity> getAllCccupationnameFromVersion(@PathVariable String version ) {
        return conceptsService.taxonomyPublicApiConcepts( null, null, "occupation_name", false, 1L, 10L, 1L );

    }


    @GetMapping("/skill-from-version/{version}")
    @ResponseBody
    private List<ConceptsEntity> getAllSkillFromVersion(@PathVariable String version ) {
        return conceptsService.taxonomyPublicApiConcepts( null, null, "skill", false, 1L, 10L, 1L );

    }

    //SEARCH ***************************************************************************************************************
    @GetMapping("/search-skill/{q}")
    @ResponseBody
    private List<ConceptHistoryEntity> searchSkill( @PathVariable String q ) {
        return searchConceptService.searchConcept( q, "skill", null, null,1L );
    }


    @GetMapping("/search-occupation-name/{q}")
    @ResponseBody
    private List<ConceptHistoryEntity> searchOccupationName( @PathVariable String q ) {
        return searchConceptService.searchConcept( q, "occupation-name", null, null,1L );
    }

    //CONCEPTS**************************************************************************************************************

    @GetMapping("/concept-replaced-by-changes/{fromVersion}/{toVersion}")
    @ResponseBody

    private List<ConceptHistoryEntity> getReplacedConcepts(@PathVariable Long fromVersion, Long toVersion) {

        return conceptHistoryService.taxonomyPublicApiConceptChangesFromVersionToVersion(fromVersion, toVersion, null, null);
    }


    //LOADTEST**************************************************************************************************************

    @GetMapping("/SearchLoad/{q}")
    @ResponseBody
    private void searchLoadTest(@PathVariable String q) {
        for (int i = 0; i < 50; i++) {
            char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
            for (char c : alphabet) {
                List<ConceptHistoryEntity> t = searchConceptService.searchConcept(String.valueOf(c), "occupation-name", null, null, 1L);
                List<ConceptHistoryEntity> s = searchConceptService.searchConcept(String.valueOf(c), "skill", null, null, 2L);
            }
        }
    }


}
