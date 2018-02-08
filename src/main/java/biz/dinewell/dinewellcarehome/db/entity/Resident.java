package biz.dinewell.dinewellcarehome.db.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "RESIDENT")
@Data
public class Resident extends AbstractUUIDEntity {
    private static final long serialVersionUID = 0;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TITLE")
    private Title title;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "MIDDLENAME")
    private String middleName;

    @Column(name = "SURNAME")
    private String lastName;
}