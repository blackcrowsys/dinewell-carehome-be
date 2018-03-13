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
@Table(name = "RESIDENTALLERGEN")
public class ResidentAllergen extends AbstractUUIDEntity{

    private static final long serialVersionUID = 0;

    @Column(name = "ID")
    private String id;

    @Column(name = "RESIDENTID")
    private String residentId;

    @Column(name = "ALLERGENCODE")
    private String allergenCode;
}
