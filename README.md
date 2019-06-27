# src/main/java/se/jobtech/taxonomy/JsontodbApplication.java.TaxonomyClient
TaxonomyClient and H2 Database
- version: 0.9.0
  
Building the client library requires:
1. Java 1.7+
2. Maven/Gradle

## Installation

Before you can compile TaxonomyClient, you need to install spring-swagger-codegen-api-client-0.0.1-SNAPSHOT.jar in ..\.m2 directory

with this dependency


```xml
<dependency>
  <groupId>se.jobtech</groupId>
  <artifactId>spring-swagger-codegen-api-client</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <scope>compile</scope>
</dependency>
```

To install the  client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:
```xml
<dependency>
  <groupId>se.jobtech.taxonomy</groupId>
  <artifactId>jsontodb</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <scope>compile</scope>
</dependency>
```
### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/spring-swagger-codegen-api-client-0.0.1-SNAPSHOT.jar`
* `target/lib/*.jar`

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/.m2\repository\se\jobtech\taxonomy\jsontodb\0.0.1-SNAPSHOT\jsontodb-0.0.1-SNAPSHOT.jar`
* `target/lib/*.jar`

# Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java
 @GetMapping("/SearchSkill/{q}")
    @ResponseBody
    private List<ConceptHistoryEntity> searchSkillExample( @PathVariable String q ) {
        return searchConceptService.searchConcept( q, "skill", null, null );
    }
    
    
```
## Documentation for API Endpoints

# Taxonomy controller

All URIs are relative to *http://localhost:3000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**Allconsepthistory**](TaxonomyController.md#getAllHistorys) | **GET** /Allconsepthistory | Return all ConceptHistoryEntity, and insert data in table,TaxonomyClient\src\main\resources\sql\create-table-consepthistory.
[**AllconsepthistoryFromDate/{dateTime}**](TaxonomyController.md#ChangesConceptService) | **GET** /AllconsepthistoryFromDate/{dateTime} |  Return all history, and insert data in table,TaxonomyClient\src\main\resources\sql\create-table-consepthistory. se the format yyyy-MM-dd HH:mm:ss (i.e. 2017-06-09 14:30:01).
[**DrivinglicenseFromDate/{dateTime}**](TaxonomyController.md#ChangesConceptService) | **GET**  /DrivinglicenseFromDate/{dateTime}| Return Drivinglicense history from dateTime to now, and insert data in table,TaxonomyClient\src\main\resources\sql\create-table-consepthistory. se the format yyyy-MM-dd HH:mm:ss (i.e. 2017-06-09 14:30:01).
[**/OccupationnameFromDate/{dateTime}**](TaxonomyController.md#ChangesConceptService) | **GET** /OccupationnameFromDate/{dateTime}| Return Drivinglicense history from dateTime to now, and insert data in table,TaxonomyClient\src\main\resources\sql\create-table-consepthistory. se the format yyyy-MM-dd HH:mm:ss (i.e. 2017-06-09 14:30:01).
[**/OccupationgroupFromDate/{dateTime}**](TaxonomyController.md#ChangesConceptService) | **GET** /OccupationgroupFromDate/{dateTime}| Return Occupationgroup history from dateTime to now, and insert data in table,TaxonomyClient\src\main\resources\sql\create-table-consepthistory. se the format yyyy-MM-dd HH:mm:ss (i.e. 2017-06-09 14:30:01). 
[**/OccupationfieldFromDate/{dateTime}**](TaxonomyController.md#ChangesConceptService) | **GET** /OccupationfieldFromDate/{dateTime}| Return Occupationfield history from dateTime to now, and insert data in table,TaxonomyClient\src\main\resources\sql\create-table-consepthistory. se the format yyyy-MM-dd HH:mm:ss (i.e. 2017-06-09 14:30:01). 
[**/SearchSkill/{q}**](TaxonomyController.md#SearchConceptService) | **GET** /SearchSkill/{q} | Return Skill(s) concepts by part of string, and insert data in table,TaxonomyClient\src\main\resources\sql\create-table-conseptskill
[**/SearchOccupationName/{q}**](TaxonomyController.md#SearchConceptService) | **GET** /SearchOccupationName/{q} | Return SearchOccupationName(s) concepts by part of string, and insert data in table,TaxonomyClient\src\main\resources\sql\create-table-consepthistory  
[**/conceptsId/{id}**](TaxonomyController.md#ConceptsService) | **GET** conceptsId/{id} | Return concepts with id. and insert data in table,C:\Workspace\TaxonomyClient\src\main\resources\sql\create-table-concepts   
[**/conceptsType/{type}**](TaxonomyController.md#ConceptsService) | **GET** /conceptsType/{type} | Return concepts with type. and insert data in table,C:\Workspace\TaxonomyClient\src\main\resources\sql\create-table-concepts  
[**/conceptsPreferredLabel/{preferredLabel}**](TaxonomyController.md#ConceptsService) | **GET** /conceptsPreferredLabel/{preferredLabel} | Return concepts. and insert data in table,C:\Workspace\TaxonomyClient\src\main\resources\sql\create-table-concepts  
[**/SearchLoad/{q}**](TaxonomyController.md#SearchConceptService) | **GET** /SearchLoad/{q} | run Loadtest 







