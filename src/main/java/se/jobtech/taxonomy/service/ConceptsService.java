package se.jobtech.taxonomy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jobtech.taxonomy.client.api.PublicApi;
import se.jobtech.taxonomy.client.model.Response2994;
import se.jobtech.taxonomy.domain.ConceptsEntity;
import se.jobtech.taxonomy.repository.ConceptsRepository;

import java.util.ArrayList;
import java.util.List;


/**
 * PublicApi* | [**v0TaxonomyPublicSearchGet**](docs/PublicApi.md#v0TaxonomyPublicSearchGet) |
 * **GET** /v0/taxonomy/public/search | get concepts by part of string
 */
@Service
public class ConceptsService {

    @Autowired
    private ConceptsRepository conceptsRepository;


    @Autowired
    private PublicApi apiInstance;


    public List<ConceptsEntity> getConcepts( String id, String preferredLabel, String type, boolean deprecated, Long offset, Long limit ) {


        List<Response2994> response = apiInstance.v0TaxonomyPublicConceptsGet( id, preferredLabel, type, deprecated, offset, limit );

        List<ConceptsEntity> conceptsEntities = new ArrayList<>( );
        for (Response2994 resp : response) {

            ConceptsEntity conceptsEntity = new ConceptsEntity( resp.getPreferredLabel( ), resp.getType( ), resp.isDeprecated( ), resp.getDefinition( ), resp.getId( ) );

            conceptsEntities.add( conceptsEntity );
            conceptsRepository.save( conceptsEntity );

        }
        return conceptsEntities;
    }


}

