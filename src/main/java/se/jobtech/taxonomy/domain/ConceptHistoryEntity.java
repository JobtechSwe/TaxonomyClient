package se.jobtech.taxonomy.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "concepthistory")
// <--- THIS is it
/**
 *   conceptid      VARCHAR(50) PRIMARY KEY,
 *          category        VARCHAR(50),
 *          preferredterm   VARCHAR(50),
 *          newpreferredterm   VARCHAR(50),
 *          oldpreferredterm   VARCHAR(50),
 *          deprecated      BOOLEAN,
 *           transactionid   LONG,
 *          eventtype       VARCHAR(50),
 *          timestamp       VARCHAR(50)
 */

public class ConceptHistoryEntity {
    @Id
    @Column(name = "conceptid")
    private String conceptId;

    @Column(name = "category")
    private String category;

    @Column(name = "preferredterm")
    private String preferredTerm;

    @Column(name = "newpreferredterm")
    private String newPreferredTerm;

    @Column(name = "oldpreferredterm")
    private String oldPreferredTerm;

    @Column(name = "deprecated")
    private Boolean deprecated;

    @Column(name = "transactionid")
    private Long transactionId;

    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "eventtype")
    private String eventType;


    public ConceptHistoryEntity() {
        this.category = null;
        this.preferredTerm = null;
        this.newPreferredTerm = null;
        this.oldPreferredTerm = null;
        this.deprecated = null;
        this.transactionId = null;
        this.timestamp = null;
        this.conceptId = null;
        this.eventType = null;
    }

    public ConceptHistoryEntity( String category, String preferredTerm, String newPreferredTerm, String oldPreferredTerm,
                                 Boolean deprecated, Long transactionId, String timeStamp, String conceptId, String eventType ) {
        this.category = category;
        this.preferredTerm = preferredTerm;
        this.newPreferredTerm = newPreferredTerm;
        this.oldPreferredTerm = oldPreferredTerm;
        this.deprecated = deprecated;
        this.transactionId = transactionId;
        this.timestamp = timeStamp;
        this.conceptId = conceptId;
        this.eventType = eventType;
    }


}
