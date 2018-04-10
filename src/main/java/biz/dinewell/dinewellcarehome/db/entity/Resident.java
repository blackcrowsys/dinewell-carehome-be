package biz.dinewell.dinewellcarehome.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RESIDENT")
public class Resident extends AbstractUUIDEntity {
    private static final long serialVersionUID = 0;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "MIDDLENAME")
    private String middleName;

    @Column(name = "SURNAME")
    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TITLE")
    private Title title;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "RESIDENTALLERGEN", joinColumns = @JoinColumn(name = "RESIDENTID"), inverseJoinColumns = @JoinColumn(name = "ALLERGENCODE"))
    private Set<Allergen> allergens = new HashSet<>();

    public void setTitle(String code, String name) {
        this.title.setCode(code);
        this.title.setName(name);
    }
}