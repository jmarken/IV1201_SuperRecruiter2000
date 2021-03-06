package integration.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="competence")
public class Competence {

    @Id
    @Column(name="name")
    @NotNull
    private String name;

    @Column(name="name_sv")
    @NotNull
    private String nameSv;

    public Competence() {
    }

    public Competence(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameSv() {
        return nameSv;
    }

    public void setNameSv(String nameSv) {
        this.nameSv = nameSv;
    }

    @Override
    public String toString() {
        return "Competence{" +
                "name='" + name + '\'' +
                ", nameSv='" + nameSv + '\'' +
                '}';
    }
}
