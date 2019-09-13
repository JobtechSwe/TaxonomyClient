#JsontodbApplication.TaxonomyClient

##TaxonomyClient and H2 Database
- version: 0.9.0
##Requirements
Building the client library requires:
1. Java 1.7+
2. Maven/Gradle

## Installation

### Preparations
Before you can compile TaxonomyClient, you need to install spring-swagger-codegen-api-client-0.0.1-SNAPSHOT.jar in ..\.m2 directory
with dependency


```xml
<dependency>
  <groupId>se.jobtech</groupId>
  <artifactId>spring-swagger-codegen-api-client</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <scope>compile</scope>
</dependency>
```
### Install package
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
      
      private List<changesConceptEntity> getConceptsChangesFromVersions(@PathVariable Long fromVersion, Long toVersion) {
  
          return changesConceptService.taxonomyPublicApiConceptChangesFromVersionToVersion(fromVersion, toVersion, null, null);
      }    
    
```
## Documentation for API Endpoints

All URIs are relative to *http://localhost:3000*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*TaxonomyController* | [**getConceptsChangesFromVersions**](docs/ChangesConceptService.md#taxonomyPublicApiConceptChangesFromVersionToVersion) | **GET** /concept-changes-fromversion-toversion/{fromVersion}/{toVersion} | Return changesConceptEntity changes from-version to-version and insert data in table,TaxonomyClient\src\main\resources\sql\create-table-consepthistory.
*TaxonomyController* | [**getAllDrivingLicenseFromVersion**](docs/ConceptService.md) | **GET** /drivinglicenses-from-version/{version} |  Return all driving license concepts from a version, and insert data in table,TaxonomyClient\src\main\resources\sql\create-table-consepthistory. se the format yyyy-MM-dd HH:mm:ss (i.e. 2017-06-09 14:30:01).
*TaxonomyController* | [**getAllCccupationnameFromVersion**](docs/ConceptService.md) | **GET**  /occupationname-from-version/{version}| Return occupationname concepts from a version, and insert data in table,TaxonomyClient\src\main\resources\sql\create-table-consepthistory. se the format yyyy-MM-dd HH:mm:ss (i.e. 2017-06-09 14:30:01).
*TaxonomyController* | [**getAllSkillFromVersion**](docs/ConceptService.md) | **GET** /skill-from-version/{version}| Return Skills concepts from version, and insert data in table,TaxonomyClient\src\main\resources\sql\create-table-consepthistory. se the format yyyy-MM-dd HH:mm:ss (i.e. 2017-06-09 14:30:01).
*TaxonomyController* | [**getConceptFromVersionWithID**](docs/Conceptservice.md) | **GET** /concept-from-id/{id}| Return concept with id from version, and insert data in table,TaxonomyClient\src\main\resources\sql\create-table-consepthistory. se the format yyyy-MM-dd HH:mm:ss (i.e. 2017-06-09 14:30:01).
*TaxonomyController* | [**searchSkill**](docs/SearchConceptService.md) | **GET** /search-skill/{q}/{version} | Return Skill(s) concepts by part of string, and insert data in table,TaxonomyClient\src\main\resources\sql\create-table-conseptskill
*TaxonomyController* | [**searchOccupationName**](docs/SearchConceptService.md) | **GET** /search-occupation-name/{q}/{version} | Return OccupationName(s) concepts by part of string, and insert data in table,TaxonomyClient\src\main\resources\sql\create-table-consepthistory  
*TaxonomyController* | [**getReplacedConcepts**](ConceptsService) | **GET** /concept-replaced-by-changes/{fromVersion}/{toVersion} | Return concepts replaced by changes, and show the history of concepts being replaced from a given version. and insert data in table,C:\Workspace\TaxonomyClient\src\main\resources\sql\create-table-concepts   
*TaxonomyController* | [**SearchLoad**](TaxonomyController.md#SearchConceptService) | **GET** /SearchLoad/{q} | run Load test. 


## Documentation for Services
 - [ChangesConceptService](docs/ChangesConceptService.md)
 - [ConceptService](docs/ConceptService.md)
 - [SearchConceptService](docs/SearchConceptService.md)
 
 ## Documentation for Domains
 - [ConceptChangesEntity](docs/ConceptChangesEntity.md)
 - [ConceptEntity](docs/ConceptEntity.md)
 - [ConceptSkillEntity](docs/ConceptSkillEntity.md)
 
  ## Documentation for Repositorys
 - [ConceptChangesRepository](docs/ConceptChangesRepository.md)
 - [ConceptSkillRepository](docs/ConceptSkillRepository.md)
 - [ConceptRepository](docs/ConceptRepository.md)
 





