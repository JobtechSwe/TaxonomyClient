
# SearchConceptService

### Example
```java
List<Response2996> response = apiInstance.v0TaxonomyPublicSearchGet( q, type, offset, limit );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );
        for (Response2996 resp : response) {

            ConceptHistoryEntity conceptHistoryEntity = new ConceptHistoryEntity( resp.getPreferredLabel( ), resp.getType( ), null,
                    null, null, resp.getId( ), null );
            conceptHistoryEntities.add( conceptHistoryEntity );
            historyRepository.save( conceptHistoryEntity );
        }
        return conceptHistoryEntities;
    }
```
### Parameters
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**q** | **String** |  | 
**type** | **String** |  | 
**offset** | **Long** |  | 
**limit** | **Long** |  | 


### Return type
**List&lt;[**ConceptHistoryEntity**](ConceptHistoryEntity.md)&gt;**