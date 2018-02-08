package biz.dinewell.dinewellcarehome.db.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "TITLE")
@Data
public class Title implements Serializable {

    private static final long serialVersionUID = 0;

    @Id
    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;
}
