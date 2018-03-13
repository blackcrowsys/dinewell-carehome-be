package biz.dinewell.dinewellcarehome.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RESIDENT")
public class Resident extends AbstractUUIDEntity {
    private static final long serialVersionUID = 0;

    @Column(name = "ID")
    private String id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "MIDDLENAME")
    private String middleName;

    @Column(name = "SURNAME")
    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TITLE")
    private Title title;

    public void setTitle(String code, String name) {
        this.title.setCode(code);
        this.title.setName(name);
    }
}