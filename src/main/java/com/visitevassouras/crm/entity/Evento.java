package com.visitevassouras.crm.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Data
@Getter
@Setter
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
