
# SearchConceptService

### Example
```java
List<Response2996> response = apiInstance.v0TaxonomyPublicSearchGet( q, type, offset, limit );
        List<changesConceptEntity> conceptHistoryEntities = new ArrayList<>( );
        for (Response2996 resp : response) {

            changesConceptEntity changesConceptEntity = new changesConceptEntity( resp.getPreferredLabel( ), resp.getType( ), null,
                    null, null, resp.getId( ), null );
            conceptHistoryEntities.add( changesConceptEntity );
            historyRepository.save( changesConceptEntity );
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
**List&lt;[**changesConceptEntity**](changesConceptEntity.md)&gt;**