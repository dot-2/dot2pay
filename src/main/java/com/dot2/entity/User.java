package com.dot2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 3279210899728333690L;
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 20)
    private String name;
    @Column(length = 32)
    private String pass;
}
