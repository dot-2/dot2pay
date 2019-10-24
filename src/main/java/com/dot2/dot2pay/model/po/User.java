package com.dot2.dot2pay.model.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends AuditModel {

    private static final long serialVersionUID = -670098075480150354L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 50)
    private String email = "";

    // 0=未知；1=男；2=女
    private Short sex = 0;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Auth> authList;

    @JsonIgnore
    @ManyToMany
    private List<Role> roleList;

}
