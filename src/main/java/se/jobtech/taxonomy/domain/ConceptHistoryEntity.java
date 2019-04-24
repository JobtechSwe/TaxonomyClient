package se.jobtech.taxonomy.domain;


import lombok.*;
import org.threeten.bp.OffsetDateTime;

import javax.persistence.*;
@Entity
@Getter @Setter
@EqualsAndHashCode
@ToString
@Table(name = "concepthistory")
// <--- THIS is it

public class ConceptHistoryEntity {
    @Id
    @Column(name="concept-id")
    private String conceptId ;

    @Column(name="category")
    private String category;

    @Column(name="preferred-term")
    private String preferredTerm ;

    @Column(name="new-preferred-term")
    private String newPreferredTerm;

    @Column(name="old-preferred-term")
    private String oldPreferredTerm ;

    @Column(name="deprecated")
    private Boolean deprecated ;

    @Column(name="transaction-id")
    private Long transactionId ;

    @Column(name="timestamp")
    private OffsetDateTime timestamp ;

    @Column(name="event-type")
    private String eventType ;


    public ConceptHistoryEntity( String category, String preferredTerm, String newPreferredTerm, String oldPreferredTerm,
                                 Boolean deprecated, Long transactionId, OffsetDateTime timeStamp, String conceptId, String eventType ) {
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
