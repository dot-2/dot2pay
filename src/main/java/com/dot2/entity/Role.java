package com.dot2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    private static final long serialVersionUID = 3797711791490846034L;

    @Id
    @GeneratedValue
    private Long id;

    // 用于显示的名字
    @Column(length = 20, unique = true,nullable = false)
    private String name;

    // 用户判断
    @Column(length = 20, unique = true,nullable = false)
    private String mark;

    @JsonIgnore
    @ManyToMany
    private List<User> userList;

    @JsonIgnore
    @ManyToMany
    private List<Permission> permissionList;

}
