package se.jobtech.taxonomy.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

public class ChangesConceptServiceTest {

    @MockBean
    ChangesConceptService changesConceptService;


    @Before
    public void setUp() throws Exception {
        changesConceptService = new ChangesConceptService( );
    }


    //@Test
    public void taxonomyPublicApiConceptHistorySinceGetTest() {
        String dateTime = "2015-08-08 14:00:00";
        changesConceptService.ChangeTaxonomyConceptHistorySinceGet( dateTime );

    }


    @Test
    public void taxonomyPublicApiConceptHistorySinceGet() {
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
