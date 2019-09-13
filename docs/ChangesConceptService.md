# ChangesConceptService.md

 Method | Description
------------- | ------------- 
[**getConceptsChangesFromVersions**](ChangesConceptService.md#taxonomyPublicApiConceptChangesFromVersionToVersion) | Show the history since the given date. Use the format yyyy-MM-dd HH:mm:ss (i.e. 2017-06-09 14:30:01).

[**ConceptHistoryRepository**](ConceptHistoryRepository.md)
 
[**PublicApi**](https://github.com/JobtechSwe/jobtech-taxonomy-api-consumer-example/blob/master/docs/PublicApi.md)




<a name="taxonomyPublicApiConceptChangesFromVersionToVersion"></a>
# **taxonomyPublicApiConceptChangesFromVersionToVersion**

### Example
```java

        List<changesConceptEntity> conceptHistoryEntities = new ArrayList<>();
        List<Response3164> response = apiInstance.v0TaxonomyPublicChangesGet(fromVersion, toVersion, offset, limit);
        for (Response3164 resp : response) {
            changesConceptEntity changesConceptEntity = new changesConceptEntity(resp.getConcept().getPreferredLabel(), resp.getConcept().getType(),
                    resp.getConcept().isDeprecated(), null, null, resp.getConcept().getId(), resp.getEventType(), resp.getVersion());
            conceptHistoryEntities.add(changesConceptEntity);
            historyRepository.save(changesConceptEntity);
        }

        return conceptHistoryEntities;
```

### Parameters
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**fromVersion** | **Long** |  | 
**toVersion** | **Long** |  | 
**offset** | **Long** |  | 
**limit** | **Long** |  | 


### Return type

**List&lt;[**changesConceptEntity**](changesConceptEntity.md)&gt;**;

