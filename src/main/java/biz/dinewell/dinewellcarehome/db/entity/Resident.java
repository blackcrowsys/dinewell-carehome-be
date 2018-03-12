package biz.dinewell.dinewellcarehome.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "RESIDENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resident extends AbstractUUIDEntity {
    private static final long serialVersionUID = 0;

    @Column(name = "ID")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TITLE")
    private Title title;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "MIDDLENAME")
    private String middleName;

    @Column(name = "SURNAME")
    private String lastName;

    public void setTitle(String code, String name) {
        this.title.setCode(code);
        this.title.setName(name);
    }
}