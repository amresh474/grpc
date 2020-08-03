package com.dplaps.catalogs.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "catg")
@EqualsAndHashCode(callSuper = false)
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "parent_id")
    private Integer parentid;
    @Column(name = "name")
    private String name;
    @Column(name = "color")
    private String color;
}
