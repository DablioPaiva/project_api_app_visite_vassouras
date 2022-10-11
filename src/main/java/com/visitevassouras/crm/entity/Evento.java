package com.visitevassouras.crm.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String tituloEvento;
    private String enderecoEvento;
    private String descricaoEvento;
    private String diasInicio;
    private String diasTermino;
    private String horarioEvento;
    private Float valor;
    private String linkIngresso;

}
