package se.jobtech.taxonomy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.jobtech.taxonomy.domain.ConceptEntity;
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
    ChangesConceptService changesConceptService = new ChangesConceptService();

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
     * @param changesConceptService the concept history since service
     */
    public TaxonomyController(ChangesConceptService changesConceptService) {
        this.changesConceptService = changesConceptService;

    }
    //CONCEPT CHANGE FROM VERSION TO VERSION****************************************************************************************************************


    @GetMapping("/concept-changes-fromversion-toversion/{fromVersion}/{toVersion}")
    @ResponseBody

    private List<ConceptEntity> getConceptsChangesFromVersions(@PathVariable Long fromVersion, Long toVersion) {

        return changesConceptService.taxonomyPublicApiConceptChangesFromVersionToVersion(fromVersion, toVersion, null, null);
    }

    //CONCEPTS TYPES FROM VERSION**************************************************************************************************************
    @GetMapping("/drivinglicenses-from-version/{version}")
    @ResponseBody
    private List<ConceptsEntity> getAllDrivingLicenseFromVersion(@PathVariable Long version) {
        return conceptsService.taxonomyPublicApiConcepts(null, null, "driving_licence", false, null, 10L, version);

    }

    @GetMapping("/country-from-version/{version}")
    @ResponseBody
    private List<ConceptsEntity> getAllCountryFromVersion(@PathVariable Long version) {
        return conceptsService.taxonomyPublicApiConcepts(null, null, "country", false, null, 10L, version);

    }


    @GetMapping("/skill-from-version/{version}")
    @ResponseBody
    private List<ConceptsEntity> getAllSkillFromVersion(@PathVariable Long version) {
        return conceptsService.taxonomyPublicApiConcepts(null, null, "skill", false, 0L, 10L, version);

    }

    @GetMapping("/concept-from-id/{id}")
    @ResponseBody
    private List<ConceptsEntity> getConceptFromVersionWithID(@PathVariable String id, Long version) {
        return conceptsService.taxonomyPublicApiConcepts(id, null, null, false, 0L, 10L, version);

    }

    //SEARCH CONCEPTS ***************************************************************************************************************
    @GetMapping("/search-skill/{q}/{version}")
    @ResponseBody
    private List<ConceptEntity> searchSkill(@PathVariable String q, Long version) {
        return searchConceptService.searchConcept(q, "skill", null, null, version);
    }


    @GetMapping("/search-occupation-name/{q}/{version}")
    @ResponseBody
    private List<ConceptEntity> searchOccupationName(@PathVariable String q, Long version) {
        return searchConceptService.searchConcept(q, "occupation-name", null, null,version);
    }

    //GET REPLACED CONCEPTS**************************************************************************************************************

    @GetMapping("/concept-replaced-by-changes/{fromVersion}/{toVersion}")
    @ResponseBody

    private List<ConceptEntity> getReplacedConcepts(@PathVariable Long fromVersion, Long toVersion) {

        return changesConceptService.taxonomyPublicApiConceptChangesFromVersionToVersion(fromVersion, toVersion, null, null);
    }


    //LOADTEST**************************************************************************************************************

    @GetMapping("/search-load/{q}")
    @ResponseBody
    private void searchLoadTest(@PathVariable String q) {
        for (int i = 0; i < 50; i++) {
            char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
            for (char c : alphabet) {
                List<ConceptEntity> t = searchConceptService.searchConcept(String.valueOf(c), "occupation-name", null, null, 1L);
                List<ConceptEntity> s = searchConceptService.searchConcept(String.valueOf(c), "skill", null, null, 2L);
            }
        }
    }


}
