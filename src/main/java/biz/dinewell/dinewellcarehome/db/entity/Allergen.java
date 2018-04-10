package biz.dinewell.dinewellcarehome.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ALLERGEN")
public class Allergen extends AbstractUUIDEntity {
    private static final long serialVersionUID = 0;

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "allergens")
    private Set<Resident> residents;

}
