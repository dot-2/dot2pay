package com.dot2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu implements Serializable {

    private static final long serialVersionUID = 6774637351038406544L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 20, unique = true, nullable = false)
    private String name;

    // 菜单 url
    @Column(nullable = false)
    private String url;

    // 菜单图标
    @Column(length = 50)
    private String icon;

    // 排序编号
    private Integer sortId = 0;

    // 是否新窗口打开
    private Boolean blank = false;

//    @OneToMany()
//    List<Menu> menuList;
}
