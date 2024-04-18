package com.chunping.springcloud.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "t_storage")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "total")
    private Integer total;

    @Column(name = "used")
    private Integer used;

    @Column(name = "residue")
    private Integer residue;
}