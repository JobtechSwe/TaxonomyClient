package se.jobtech.taxonomy.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ChangesConceptServiceTest {

    @MockBean
    ChangesConceptService changesConceptService;

    @Before
    public void setUp() {


    }
/*

    @Test
    public void taxonomyPublicApiConceptHistorySinceGetTest() {
        String dateTime = "2015-08-08 14:00:00";
        List<conceptEntity> entityList = changesConceptService.taxonomyConceptHistorySinceGet( dateTime );
        assertNotNull( entityList );

    }*/


    @Test
    public void taxonomyPublicApiAllConceptHistory() {
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
