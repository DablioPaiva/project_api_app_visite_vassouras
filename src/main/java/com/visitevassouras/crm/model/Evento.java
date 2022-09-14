package com.visitevassouras.crm.model;

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
    private Date diasInicio;
    private Date diasTermino;
    private String horarioEvento;
    private Float valor;
    private String linkIngresso;

}
