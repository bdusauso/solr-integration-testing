package be.codinsanity.quickstart.domain;

import javax.persistence.*;


/**
 * @author Bruno Dusausoy
 */

@MappedSuperclass
public abstract class Person extends BaseEntity {

    @Column(name = "name", unique = true, nullable = false)
    protected String name;

    @ManyToOne
    @JoinColumn(name = "organ_id")
    protected Organ organ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organ getOrgan() {
        return organ;
    }

    public void setOrgan(Organ organ) {
        this.organ = organ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Person person = (Person) o;

        if (!name.equals(person.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
