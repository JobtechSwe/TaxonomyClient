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
@Table(name = "concept")


public class ConceptEntity {
    @Id
    @Column(name = "conceptid")
    private String conceptId;

    @Column(name = "conceptpreferredlabel", length = 512)
    private String conceptpreferredlabel;

    @Column(name = "concepttype")
    private String concepttype;


    @Column(name = "conceptdefinition", length = 1024)
    private String definition;

    public ConceptEntity() {
        this.conceptpreferredlabel = null;
        this.concepttype = null;
        this.definition = null;
        this.conceptId = null;

    }

    /**
     * @param conceptpreferredlabel
     * @param concepttype
     * @param definition
     * @param conceptId
     */
    @Contract(pure = true)
    public ConceptEntity(String conceptpreferredlabel, String concepttype,
                         String definition, String conceptId) {

        this.conceptpreferredlabel = conceptpreferredlabel;
        this.concepttype = concepttype;
        this.definition = definition;
        this.conceptId = conceptId;
        // this.version=version;

    }


}
