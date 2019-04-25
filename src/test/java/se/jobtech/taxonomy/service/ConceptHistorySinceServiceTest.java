package se.jobtech.taxonomy.service;

import org.junit.Test;
import se.jobtech.taxonomy.client.api.PublicApi;
import se.jobtech.taxonomy.client.model.Response38760;
import se.jobtech.taxonomy.client.model.Response38763;
import se.jobtech.taxonomy.client.model.Response38765;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ConceptHistorySinceServiceTest {

    private final PublicApi api = new PublicApi();


    @Test
    public void taxonomyPublicApiConceptHistorySinceGetTest() {
        String dateTime = "2015-08-08 14:00:00";



        List<Response38765> response = api.taxonomyPublicApiConceptHistorySinceGet(dateTime);
        assertNotNull( response );

        for (Response38765 res : response) {




        }

        // TODO: test validations
    }


//@Test
    public void taxonomyPublicApiDeprecatedConceptHistorySinceGetTest() {
        String dateTime = "2018-08-08 14:00:00";

        Object response = api.taxonomyPublicApiDeprecatedConceptHistorySinceGet(dateTime);

        assertNotNull(response);
    }


    /**
     * Taxonomy public api term get test.
     */
    //@Test
    public void taxonomyPublicApiTermGetTest() {
        String term = "Danska";
        List<Response38760> response = api.taxonomyPublicApiTermGet(term);
        for (Response38760 response38760 : response) {
            assertNotNull(response38760.getId());
            assertNotNull(response38760.getCategory());


        }

        // TODO: test validations
    }


  //  @Test
    public void taxonomyPublicApiTermPartGetTest() {
        String term = "Danska";
        api.taxonomyPublicApiTermPartGet(term);

        // TODO: test validations
    }

}
