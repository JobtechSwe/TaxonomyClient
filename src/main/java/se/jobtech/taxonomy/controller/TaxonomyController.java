package se.jobtech.taxonomy.controller;


        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;
        import se.jobtech.taxonomy.service.ConceptHistorySinceService;


@RestController
@RequestMapping("/taxonomy")
public class TaxonomyController {

    private ConceptHistorySinceService conceptHistorySinceService;

    public TaxonomyController( ConceptHistorySinceService conceptHistorySinceService ) {
        this.conceptHistorySinceService = conceptHistorySinceService;
    }


}
