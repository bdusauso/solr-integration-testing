package be.codinsanity.quickstart.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import be.codinsanity.quickstart.domain.BaseEntity;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "procedure")
public class Procedure extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "procedure_ref", unique = true)
    private String procedureReference;

    @Column(name = "status_code")
    private String statusCode;

    @ManyToMany(mappedBy = "procedures")
    private Set<Dossier> dossiers = new HashSet<Dossier>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rapporteur")
    private Rapporteur rapporteur;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Organ> organs = new HashSet<Organ>();

    @Column(name = "procedure_title", length = 2000)
    private String procedureTitle;

    @Column(name = "procedure_type")
    private String procedureType;

    @Column(name = "vote_in_plenary")
    private Date voteInPlenary;

    @Column(name = "amendment_deadline")
    private Date amendmentDeadline;

    public Procedure() {
    }

    public String getProcedureReference() {
        return procedureReference;
    }

    public void setProcedureReference(String procedureRef) {
        this.procedureReference = procedureRef;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Rapporteur getRapporteur() {
        return rapporteur;
    }

    public void setRapporteur(Rapporteur rapporteur) {
        this.rapporteur = rapporteur;
    }

    public Set<Organ> getOrgans() {
        return organs;
    }

    public void setOrgans(Set<Organ> organs) {
        this.organs = organs;
    }

    public String getProcedureTitle() {
        return procedureTitle;
    }

    public void setProcedureTitle(String procedureTitle) {
        this.procedureTitle = procedureTitle;
    }

    public String getProcedureType() {
        return procedureType;
    }

    public void setProcedureType(String procedureType) {
        this.procedureType = procedureType;
    }

    public Date getVoteInPlenary() {
        return voteInPlenary;
    }

    public void setVoteInPlenary(Date voteInPlenary) {
        this.voteInPlenary = voteInPlenary;
    }

    public Date getAmendmentDeadline() {
        return amendmentDeadline;
    }

    public void setAmendmentDeadline(Date amendmentDeadline) {
        this.amendmentDeadline = amendmentDeadline;
    }

    public Set<Dossier> getDossiers() {
        return dossiers;
    }

    public void setDossiers(Set<Dossier> procedures) {
        this.dossiers = procedures;
    }

    public void addDossiers(Dossier... dossiers) {
        for (Dossier dossier : dossiers) {
            this.dossiers.add(dossier);
            dossier.getProcedures().add(this);
        }
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Procedure)) {
            return false;
        }
        Procedure other = (Procedure) obj;

        boolean equals = new EqualsBuilder()
                .append(this.procedureReference, other.procedureReference)
                .isEquals();

        return equals;

    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(procedureReference)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", getId())
                .append("procedureRef", procedureReference)
                .append("rapporteur", rapporteur)
                .append("procedureTitle", procedureTitle)
                .append("procedureType", procedureType)
                .append("voteInPlenary", voteInPlenary)
                .append("amendmentDeadline", amendmentDeadline)
                .append("organs", organs)
                .toString();
    }
}
