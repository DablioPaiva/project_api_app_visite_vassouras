package com.visitevassouras.crm.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Hospedagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeHospedagem;
    private String imagemHospedagem;
    private String urlHospedagem;


}
