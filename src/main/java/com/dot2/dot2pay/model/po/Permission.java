package com.dot2.dot2pay.model.po;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    private Long parentId;

    @JsonIgnore
    @ManyToMany
    private List<Role> roleList;

    @Transient // 忽略字段在table中的映射
    private List<Permission> children = new ArrayList<>(0);

}
