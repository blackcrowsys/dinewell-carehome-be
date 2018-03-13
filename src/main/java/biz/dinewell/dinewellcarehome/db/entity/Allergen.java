package biz.dinewell.dinewellcarehome.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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

}
