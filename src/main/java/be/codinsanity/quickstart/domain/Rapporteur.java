package be.codinsanity.quickstart.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "rapporteur")
public class Rapporteur extends Person {

    private static final long serialVersionUID = 1L;

    @Column(name = "type", length = 16)
    @Enumerated(EnumType.STRING)
    private RapporteurType type;

    @OneToMany(mappedBy = "rapporteur", cascade = CascadeType.ALL)
    private Set<Procedure> procedures = new HashSet<Procedure>();

    public Set<Procedure> getProcedures() {
        return procedures;
    }

    public void setProcedures(Set<Procedure> procedures) {
        this.procedures = procedures;
    }

    public RapporteurType getType() {
        return type;
    }

    public void setType(RapporteurType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Rapporteur)) {
            return false;
        }
        Rapporteur other = (Rapporteur) obj;
        return new EqualsBuilder()
                .append(this.name, other.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(name)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", getId())
                .append("name", name)
                .toString();
    }
}
