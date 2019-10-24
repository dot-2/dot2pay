package com.dot2.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Cacheable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission extends AuditModel implements Serializable {

    private static final long serialVersionUID = 1353663165920588257L;

    @Id
    @GeneratedValue
    private Long id;

    // 用于显示的名字
    @Column(length = 20, unique = true, nullable = false)
    private String name;

    // 用于判断的权限名称
    @Column(length = 20, unique = true, nullable = false)
    private String mark;

    // 排序编号
    private Integer sortId = 0;

    @JsonIgnore
    @ManyToMany
    private List<Role> roleList;

    @OneToMany(mappedBy = "parentId",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Permission> children = new HashSet<>(0);

    private Long parentId;

}
