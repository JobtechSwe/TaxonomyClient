package se.jobtech.taxonomy.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The type Concept entity.
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "conceptchanges")


public class ConceptChangesEntity {
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

    @Column(name = "version")
    private Long version;


    /**
     * Instantiates a new Concept entity.
     */
    public ConceptChangesEntity() {
        this.conceptpreferredlabel = null;
        this.concepttype = null;
        this.conceptdeprecated = null;
        this.transactionId = null;
        this.timestamp = null;
        this.conceptId = null;
        this.eventType = null;
        this.version = null;
    }

    /**
     * Instantiates a new Concept entity.
     *
     * @param conceptpreferredlabel the conceptpreferredlabel
     * @param concepttype           the concepttype
     * @param conceptdeprecated     the conceptdeprecated
     * @param transactionId         the transaction id
     * @param timeStamp             the time stamp
     * @param conceptId             the concept id
     * @param eventType             the event type
     * @param version               the version
     */
    public ConceptChangesEntity(String conceptpreferredlabel, String concepttype,
                                Boolean conceptdeprecated, Long transactionId, String timeStamp, String conceptId, String eventType, Long version) {

        this.conceptpreferredlabel = conceptpreferredlabel;
        this.concepttype = concepttype;
        this.conceptdeprecated = conceptdeprecated;
        this.transactionId = transactionId;
        this.timestamp = timeStamp;
        this.conceptId = conceptId;
        this.eventType = eventType;
        this.version = version;
    }


}
