package se.jobtech.taxonomy.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.jobtech.taxonomy.domain.ConceptHistoryEntity;
import se.jobtech.taxonomy.service.ConceptHistorySinceService;

import java.util.List;


@RestController
@RequestMapping("/taxonomy")
public class TaxonomyController {
    final ConceptHistorySinceService conceptHistorySinceService;

    public TaxonomyController( ConceptHistorySinceService conceptHistorySinceService ) {
        this.conceptHistorySinceService = conceptHistorySinceService;
    }


    @GetMapping("/consepthistorysince")
    private List<ConceptHistoryEntity> getAllHistorysSince() {

        String dateTime = "2015-08-08 14:00:00";

        return conceptHistorySinceService.taxonomyPublicApiConceptHistorySinceGet( dateTime );
    }
}
