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
@Table(name = "skill")
// <--- THIS is it
/**
 eventtype        VARCHAR(50),
 transactionid    LONG,
 timestamp        VARCHAR(150),
 conceptid        VARCHAR(50) PRIMARY KEY,
 concepttype      VARCHAR(50),
 conceptconceptdeprecated BOOLEAN,
 conceptpreferredlabel   VARCHAR(50)
 );
 */


public class ConceptSkillEntity {
    @Id
    @Column(name = "conceptid")
    private String conceptId;


    @Column(name = "conceptpreferredlabel")
    private String conceptpreferredlabel;

    @Column(name = "concepttype")
    private String concepttype;


    @Column(name = "conceptdeprecated")
    private Boolean conceptdeprecated;

    @Column(name = "transactionid")
    private Long transactionId;

    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "eventtype")
    private String eventType;


    public ConceptSkillEntity() {
        this.conceptpreferredlabel = null;
        this.concepttype = null;
        this.conceptdeprecated = null;
        this.transactionId = null;
        this.timestamp = null;
        this.conceptId = null;
        this.eventType = null;
    }

    /**
     * @param conceptpreferredlabel
     * @param concepttype
     * @param conceptdeprecated
     * @param transactionId
     * @param timeStamp
     * @param conceptId
     * @param eventType
     */
    public ConceptSkillEntity( String conceptpreferredlabel, String concepttype,
                               Boolean conceptdeprecated, Long transactionId, String timeStamp, String conceptId, String eventType ) {

        this.conceptpreferredlabel = conceptpreferredlabel;
        this.concepttype = concepttype;
        this.conceptdeprecated = conceptdeprecated;
        this.transactionId = transactionId;
        this.timestamp = timeStamp;
        this.conceptId = conceptId;
        this.eventType = eventType;
    }


}
