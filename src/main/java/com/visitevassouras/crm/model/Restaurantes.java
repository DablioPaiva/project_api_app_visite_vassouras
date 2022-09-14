package com.visitevassouras.crm.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Restaurantes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeRestaurante;
    private String logoRestaurante;
    private String urlRestaurante;

}
