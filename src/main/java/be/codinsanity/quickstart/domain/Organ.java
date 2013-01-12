package be.codinsanity.quickstart.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="organ")
public class Organ extends BaseEntity {

  private static final long serialVersionUID = 1L;
  
  @Column(name = "organ_name", unique=true)
  private String organName;
  
  
  public Organ() {
  }
 
  public String getOrganName() {
    return organName;
  }

  public void setOrganName(String organName) {
    this.organName = organName;
  }
 
  @Override
  public boolean equals(Object obj) {
      if (obj == null) {
          return false;
      }
      if (!(obj instanceof Organ)) {
          return false;
      }
      Organ other = (Organ) obj;
      return new EqualsBuilder()
          .append(this.organName, other.organName)
          .isEquals();
  }

  @Override
  public int hashCode() {
      return new HashCodeBuilder()
          .append(organName)
          .toHashCode();
  }

  @Override
  public String toString() {
      return new ToStringBuilder(this)
          .append("organ name", organName)
          .toString();
  }
  
}
