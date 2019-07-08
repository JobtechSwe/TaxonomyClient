# ChangesConceptService.md

 Method | Description
------------- | ------------- 
[**taxonomyConceptHistorySinceGet**](ChangesConceptService.md#taxonomyConceptHistorySinceGet) | Show the history since the given date. Use the format yyyy-MM-dd HH:mm:ss (i.e. 2017-06-09 14:30:01).
[**taxonomyPublicApiConceptFullHistory**](ChangesConceptService.md#taxonomyPublicApiConceptFullHistory) | Return a list of all history.
[**taxonomyPublicApiConceptDrivingLicense**](ChangesConceptService.md#taxonomyPublicApiConceptDrivingLicense) | Show the history since the given date,  Use the format yyyy-MM-dd HH:mm:ss (i.e. 2017-06-09 14:30:01)and concepttype "driving-license".
[**taxonomyPublicApiConceptOccupationField**](ChangesConceptService.md#taxonomyPublicApiConceptOccupationField) | Show the history since the given date. Use the format yyyy-MM-dd HH:mm:ss (i.e. 2017-06-09 14:30:01)and concepttype "occupation-field".
[**taxonomyPublicApiConceptOccupationgroup**](ChangesConceptService.md#taxonomyPublicApiConceptOccupationgroup) | Show the history since the given date. Use the format yyyy-MM-dd HH:mm:ss (i.e. 2017-06-09 14:30:01)and concepttype "occupation-group".
[**taxonomyPublicApiConceptOccupationname**](ChangesConceptService.md#taxonomyPublicApiConceptOccupationname) | Show the history since the given date. Use the format yyyy-MM-dd HH:mm:ss (i.e. 2017-06-09 14:30:01)and concepttype "occupation-name".
[**taxonomyPublicApiConceptOccupationSkill**](ChangesConceptService.md#taxonomyPublicApiConceptOccupationSkill) | Show the history since the given date. Use the format yyyy-MM-dd HH:mm:ss (i.e. 2017-06-09 14:30:01)and concepttype "skill".
### Using
[**ConceptHistoryRepository**](ConceptHistoryRepository.md)
 
[**ConceptSkillRepository**](ConceptSkillRepository.md)
  
[**PublicApi**](https://github.com/JobtechSwe/jobtech-taxonomy-api-consumer-example/blob/master/docs/PublicApi.md)




<a name="taxonomyConceptHistorySinceGet"></a>
# **taxonomyConceptHistorySinceGet**

### Example
```java
List<Response2992> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );
        for (Response2992 resp : response) {


            ConceptHistoryEntity conceptHistoryEntity = new ConceptHistoryEntity( resp.getConcept( ).getPreferredLabel( ), resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ),
                    resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );
            conceptHistoryEntities.add( conceptHistoryEntity );
            historyRepository.save( conceptHistoryEntity );
        }

        return conceptHistoryEntities;
```

### Parameters
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**fromDateTime** | **String** |  | 

### Return type

**List&lt;[**ConceptHistoryEntity**](ConceptHistoryEntity.md)&gt;**;


<a name="taxonomyPublicApiConceptFullHistory"></a>
# **taxonomyPublicApiConceptFullHistory**


### Example
```java
   return taxonomyConceptHistorySinceGet( "2000-01-01 00:00:00" );
```
### Parameters
Empty
### Return type

**List&lt;[**ConceptHistoryEntity**](ConceptHistoryEntity.md)&gt;**;


<a name="taxonomyPublicApiConceptDrivingLicense"></a>
# **taxonomyPublicApiConceptDrivingLicense**

### Example
```java
 List<Response2992> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
        List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );

        for (Response2992 resp : response) {
            CreateConseptHistory( "driving-license", conceptHistoryEntities, resp.getConcept( ).getPreferredLabel( ),
                    resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );
        }
        return conceptHistoryEntities;
```
### Parameters
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**fromDateTime** | **String** |  | 
### Return type

**List&lt;[**ConceptHistoryEntity**](ConceptHistoryEntity.md)&gt;**;


<a name="taxonomyPublicApiConceptOccupationField"></a>
# **taxonomyPublicApiConceptOccupationField**

### Example
```java
List<Response2992> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
         List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );
 
         for (Response2992 resp : response) {
             CreateConseptHistory( "occupation-field", conceptHistoryEntities, resp.getConcept( ).getPreferredLabel( ),
                     resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );
         }
         return conceptHistoryEntities;
```

### Parameters
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**fromDateTime** | **String** |  | 
### Return type

**List&lt;[**ConceptHistoryEntity**](ConceptHistoryEntity.md)&gt;**;


<a name="taxonomyPublicApiConceptOccupationgroup"></a>
# **taxonomyPublicApiConceptOccupationgroup**

### Example
```java
List<Response2992> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
               List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );
       
               for (Response2992 resp : response) {
                   CreateConseptHistory( "occupation-group", conceptHistoryEntities, resp.getConcept( ).getPreferredLabel( ),
                           resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );
               }
               return conceptHistoryEntities;
```

### Parameters
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**fromDateTime** | **String** |  | 
### Return type

**List&lt;[**ConceptHistoryEntity**](ConceptHistoryEntity.md)&gt;**;


<a name="taxonomyPublicApiConceptOccupationname"></a>
# **taxonomyPublicApiConceptOccupationname**

### Example
```java
List<Response2992> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
               List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );
       
               for (Response2992 resp : response) {
                   CreateConseptHistory( "occupation-name", conceptHistoryEntities, resp.getConcept( ).getPreferredLabel( ),
                           resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );
               }
               return conceptHistoryEntities;
```

### Parameters
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**fromDateTime** | **String** |  | 

### Return type

**List&lt;[**ConceptHistoryEntity**](ConceptHistoryEntity.md)&gt;**;


<a name="taxonomyPublicApiConceptOccupationSkill"></a>
# **taxonomyPublicApiConceptOccupationSkill**


### Example
```java

List<Response2992> response = apiInstance.v0TaxonomyPublicChangesGet( fromDateTime, 0L, 1L );
               List<ConceptHistoryEntity> conceptHistoryEntities = new ArrayList<>( );
       
               for (Response2992 resp : response) {
                   CreateConseptHistory( "occupation-skill", conceptHistoryEntities, resp.getConcept( ).getPreferredLabel( ),
                           resp.getConcept( ).getType( ), resp.getConcept( ).isDeprecated( ), resp.getTransactionId( ), resp.getTimestamp( ), resp.getConcept( ).getId( ), resp.getEventType( ) );
               }
               return conceptHistoryEntities;
```

### Parameters
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**fromDateTime** | **String** |  | 
### Return type

**List&lt;[**ConceptHistoryEntity**](ConceptHistoryEntity.md)&gt;**;
