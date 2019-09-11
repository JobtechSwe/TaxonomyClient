
# SearchConceptService

### Example
```java
List<Response2996> response = apiInstance.v0TaxonomyPublicSearchGet( q, type, offset, limit );
        List<conceptEntity> conceptHistoryEntities = new ArrayList<>( );
        for (Response2996 resp : response) {

            conceptEntity conceptEntity = new conceptEntity( resp.getPreferredLabel( ), resp.getType( ), null,
                    null, null, resp.getId( ), null );
            conceptHistoryEntities.add( conceptEntity );
            historyRepository.save( conceptEntity );
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
**List&lt;[**conceptEntity**](conceptEntity.md)&gt;**