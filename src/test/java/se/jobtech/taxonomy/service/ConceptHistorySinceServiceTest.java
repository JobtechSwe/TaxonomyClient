package se.jobtech.taxonomy.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import se.jobtech.taxonomy.client.api.PublicApi;
import se.jobtech.taxonomy.client.model.Response38760;
import se.jobtech.taxonomy.client.model.Response38765;
import se.jobtech.taxonomy.domain.ConceptHistoryEntity;
import se.jobtech.taxonomy.repository.ConceptHistoryRepository;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ConceptHistorySinceServiceTest {

     PublicApi api = new PublicApi( );

    ConceptHistorySinceService conceptHistorySinceService= new ConceptHistorySinceService();

    //@Test
    public void taxonomyPublicApiConceptHistorySinceGetTest() {
        String dateTime = "2015-08-08 14:00:00";
         PublicApi api = new PublicApi( );
        ConceptHistorySinceService conceptHistorySinceService= new ConceptHistorySinceService();


        List<ConceptHistoryEntity> entityList = conceptHistorySinceService.taxonomyPublicApiConceptHistorySinceGet( dateTime );

        List<Response38765> response = api.taxonomyPublicApiConceptHistorySinceGet( dateTime );

        assertNotNull( response );

        for (Response38765 res : response) {


        }

        // TODO: test validations
    }


    /**
     * Taxonomy public api term get test.
     */
    @Test
    public void taxonomyPublicApiTermGetTest() {
        String term = "Danska";
        List<Response38760> response = api.taxonomyPublicApiTermGet( term );
        for (Response38760 response38760 : response) {
            assertNotNull( response38760.getId( ) );
            assertNotNull( response38760.getCategory( ) );


        }

        // TODO: test validations
    }


    @Test
    public void taxonomyPublicApiTermPartGetTest() {
        String term = "Danska";
        api.taxonomyPublicApiTermPartGet( term );

        // TODO: test validations
    }

}
