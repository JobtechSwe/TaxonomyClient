package se.jobtech.taxonomy.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Contract;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "concepts")
// <--- THIS is it
/**
 "conceptid"
 "concepttype"
 "conceptdefinition"
 "conceptpreferredLabel"
 "conceptdeprecated"
 */


public class ConceptsEntity {
    @Id
    @Column(name = "conceptid")
    private String conceptId;

    @Column(name = "conceptpreferredlabel")
    private String conceptpreferredlabel;

    @Column(name = "concepttype")
    private String concepttype;

    @Column(name = "conceptdeprecated")
    private Boolean conceptdeprecated;

    @Column(name = "conceptdefinition")
    private String definition;
    @Column(name = "version")
    private Long version;



    public ConceptsEntity() {
        this.conceptpreferredlabel = null;
        this.concepttype = null;
        this.conceptdeprecated = null;
        this.definition = null;
        this.conceptId = null;

    }

    /**
     * @param conceptpreferredlabel
     * @param concepttype
     * @param conceptdeprecated
     * @param definition
     * @param conceptId
     */
    @Contract(pure = true)
    public ConceptsEntity( String conceptpreferredlabel, String concepttype,
                           Boolean conceptdeprecated, String definition, String conceptId ) {

        this.conceptpreferredlabel = conceptpreferredlabel;
        this.concepttype = concepttype;
        this.conceptdeprecated = conceptdeprecated;
        this.definition = definition;
        this.conceptId = conceptId;

    }


}
