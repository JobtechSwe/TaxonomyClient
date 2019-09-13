# ConceptsService

### Example
```java

List<Response2994> response = apiInstance.v0TaxonomyPublicConceptsGet( id, preferredLabel, type, deprecated, offset, limit );
   List<ConceptsEntity> conceptsEntities = new ArrayList<>( );
   for (Response2994 resp : response) {
   ConceptsEntity conceptEntity = new ConceptsEntity( resp.getPreferredLabel( ), resp.getType( ), resp.isDeprecated( ), resp.getDefinition( ), resp.getId( ) );
   conceptsEntities.add( conceptEntity );
   conceptsRepository.save( conceptEntity );
   }
        return conceptsEntities;
```        

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  | [optional]
 **preferredLabel** | **String**|  | [optional]
 **type** | **String**|  | [optional]
 **deprecated** | **Boolean**|  | [optional]
 **offset** | **Long**|  | [optional]
 **limit** | **Long**|  | [optional]
 
 ### Using
 [**ConceptsRepository**](ConceptsRepository.md)
 
 ConceptsRepository

### Return type
[**List&lt;ConceptsEntity&gt;**](ConceptsEntity.md)
