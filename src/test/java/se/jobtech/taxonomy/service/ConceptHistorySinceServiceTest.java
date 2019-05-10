package se.jobtech.taxonomy.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

public class ConceptHistorySinceServiceTest {

    @MockBean
    ConceptHistorySinceService conceptHistorySinceService;


    @Before
    public void setUp() throws Exception {
        conceptHistorySinceService = new ConceptHistorySinceService( );
    }


    @Test
    public void taxonomyPublicApiConceptHistorySinceGetTest() {
        String dateTime = "2015-08-08 14:00:00";
        //     conceptHistorySinceService.taxonomyPublicApiConceptHistorySinceGet( dateTime );

    }


    @Test
    public void taxonomyPublicApiConceptHistorySinceGet() {
    }

    @Test
    public void taxonomyPublicApiConceptFullHistory() {

        // conceptHistorySinceService.taxonomyPublicApiConceptFullHistory();
    }

    @Test
    public void taxonomyPublicApiConceptDrivingLicense() {
    }

    @Test
    public void taxonomyPublicApiConceptOccupationname() {
    }

    @Test
    public void taxonomyPublicApiConceptOccupationgroup() {
    }

    @Test
    public void taxonomyPublicApiConceptOccupationField() {
    }

    @Test
    public void taxonomyPublicApiConceptOccupationSkillHeadline() {
    }

    @Test
    public void taxonomyPublicApiConceptOccupationSkill() {
    }
}
