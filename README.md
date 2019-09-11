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
with this dependency


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
      
      private List<conceptEntity> getConceptsChangesFromVersions(@PathVariable Long fromVersion, Long toVersion) {
  
          return changesConceptService.taxonomyPublicApiConceptChangesFromVersionToVersion(fromVersion, toVersion, null, null);
      }    
    
```
## Documentation for API Endpoints

All URIs are relative to *http://localhost:3000*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*TaxonomyController* | [**getConceptsChangesFromVersions**](docs/ChangesConceptService.md#taxonomyPublicApiConceptChangesFromVersionToVersion) | **GET** /concept-changes-fromversion-toversion/{fromVersion}/{toVersion} | Return conceptEntity changes from-version to-version and insert data in table,TaxonomyClient\src\main\resources\sql\create-table-consepthistory.
*TaxonomyController* | [**getAllDrivingLicenseFromVersion**](docs/ConceptsService.md) | **GET** /taxonomyP |  Return all driving license from a version, and insert data in table,TaxonomyClient\src\main\resources\sql\create-table-consepthistory. se the format yyyy-MM-dd HH:mm:ss (i.e. 2017-06-09 14:30:01).
*TaxonomyController* | [**getAllCccupationnameFromVersion**](docs/ConceptsService.md) | **GET**  /getAllOccupationnameFromVersion/{version}| Return Drivinglicense history from date to now, and insert data in table,TaxonomyClient\src\main\resources\sql\create-table-consepthistory. se the format yyyy-MM-dd HH:mm:ss (i.e. 2017-06-09 14:30:01).
*TaxonomyController* | [**getAllSkillFromVersion**](docs/ConceptsService.md) | **GET** /getAllSkillFromVersion/{version}| Return Skills history from version, and insert data in table,TaxonomyClient\src\main\resources\sql\create-table-consepthistory. se the format yyyy-MM-dd HH:mm:ss (i.e. 2017-06-09 14:30:01).
*TaxonomyController* | [**getConceptFromVersionWithID**](docs/ConceptsService.md) | **GET** /getConceptFromVersionWithID/{version}| Return Skills history from version, and insert data in table,TaxonomyClient\src\main\resources\sql\create-table-consepthistory. se the format yyyy-MM-dd HH:mm:ss (i.e. 2017-06-09 14:30:01).
*TaxonomyController* | [**searchSkill**](docs/SearchConceptService.md) | **GET** /SearchSkill/{q} | Return Skill(s) concepts by part of string, and insert data in table,TaxonomyClient\src\main\resources\sql\create-table-conseptskill
*TaxonomyController* | [**searchOccupationName**](docs/SearchConceptService.md) | **GET** /SearchOccupationName/{q} | Return SearchOccupationName(s) concepts by part of string, and insert data in table,TaxonomyClient\src\main\resources\sql\create-table-consepthistory  
*TaxonomyController* | [**getReplacedConcepts**](TaxonomyController.md#ConceptsService) | **GET** conceptsId/{id} | Return concepts with id. and insert data in table,C:\Workspace\TaxonomyClient\src\main\resources\sql\create-table-concepts   
*TaxonomyController* | [**SearchLoad**](TaxonomyController.md#SearchConceptService) | **GET** /SearchLoad/{q} | run Load test. 


## Documentation for Services
 - [ChangesConceptService](docs/ChangesConceptService.md)
 - [ConceptsService](docs/ConceptsService.md)
 - [SearchConceptService](docs/SearchConceptService.md)
 
 ## Documentation for Domains
 - [conceptEntity](docs/conceptEntity.md)
 - [ConceptsEntity](docs/ConceptsEntity.md)
 - [ConceptSkillEntity](docs/ConceptSkillEntity.md)
 
  ## Documentation for Repositorys
 - [ConceptHistoryRepository](docs/ConceptHistoryRepository.md)
 - [ConceptSkillRepository](docs/ConceptSkillRepository.md)
 - [ConceptsRepository](docs/ConceptsRepository.md)
 





