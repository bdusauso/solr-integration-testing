package be.codinsanity.quickstart.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bruno Dusausoy
 */
@Entity
@Table(name = "dossier")
public class Dossier extends BaseEntity {

    @Column(name = "title", length = 4000, nullable = false)
    private String title;

    @Column(name = "iter_reference", nullable = false, unique = true)
    private String iterReference;

    @OneToMany(mappedBy = "dossiers")
    private Set<Procedure> procedures = new HashSet<Procedure>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "dossier_rapporteur",
            joinColumns = {@JoinColumn(name = "dossier_id")},
            inverseJoinColumns = {@JoinColumn(name = "rapporteur_id")})
    private Set<Rapporteur> rapporteurs = new HashSet<Rapporteur>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "dossier_responsible",
            joinColumns = {@JoinColumn(name = "dossier_id")},
            inverseJoinColumns = {@JoinColumn(name = "responsible_id")})
    private Set<Responsible> responsibles = new HashSet<Responsible>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "dossier_organ",
            joinColumns = {@JoinColumn(name = "dossier_id")},
            inverseJoinColumns = {@JoinColumn(name = "organ_id")})
    private Set<Organ> organs = new HashSet<Organ>();

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private DossierType type;

    public String getIterReference() {
        return iterReference;
    }

    public void setIterReference(String iterReference) {
        this.iterReference = iterReference;
    }

    public Set<Procedure> getProcedures() {
        return procedures;
    }

    public void setProcedures(Set<Procedure> procedures) {
        this.procedures = procedures;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Rapporteur> getRapporteurs() {
        return rapporteurs;
    }

    public void setRapporteurs(Set<Rapporteur> rapporteurs) {
        this.rapporteurs = rapporteurs;
    }

    public Set<Responsible> getResponsibles() {
        return responsibles;
    }

    public void setResponsibles(Set<Responsible> responsibles) {
        this.responsibles = responsibles;
    }

    public Set<Organ> getOrgans() {
        return organs;
    }

    public void setOrgans(Set<Organ> organs) {
        this.organs = organs;
    }

    public DossierType getType() {
        return type;
    }

    public void setType(DossierType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Dossier dossier = (Dossier) o;

        return iterReference.equals(dossier.iterReference);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + iterReference.hashCode();
        return result;
    }
}
