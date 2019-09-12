
# SearchConceptService

### Example
```java
List<Response2996> response = apiInstance.v0TaxonomyPublicSearchGet( q, type, offset, limit );
        List<conceptChangesEntity> conceptHistoryEntities = new ArrayList<>( );
        for (Response2996 resp : response) {

            conceptChangesEntity conceptChangesEntity = new conceptChangesEntity( resp.getPreferredLabel( ), resp.getType( ), null,
                    null, null, resp.getId( ), null );
            conceptHistoryEntities.add( conceptChangesEntity );
            historyRepository.save( conceptChangesEntity );
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
**List&lt;[**conceptChangesEntity**](conceptChangesEntity.md)&gt;**