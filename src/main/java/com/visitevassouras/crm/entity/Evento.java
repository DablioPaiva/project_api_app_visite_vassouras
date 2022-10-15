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

    public Evento() {
        this.id = id;
        this.tituloEvento = tituloEvento;
        this.enderecoEvento = enderecoEvento;
        this.descricaoEvento = descricaoEvento;
        this.diasInicio = diasInicio;
        this.diasTermino = diasTermino;
        this.horarioEvento = horarioEvento;
        this.valor = valor;
        this.linkIngresso = linkIngresso;
    }

    public Long getId() {
        return id;
    }

    public String getTituloEvento() {
        return tituloEvento;
    }

    public String getEnderecoEvento() {
        return enderecoEvento;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public String getDiasInicio() {
        return diasInicio;
    }

    public String getDiasTermino() {
        return diasTermino;
    }

    public String getHorarioEvento() {
        return horarioEvento;
    }

    public Float getValor() {
        return valor;
    }

    public String getLinkIngresso() {
        return linkIngresso;
    }

    public void setTituloEvento(String tituloEvento) {
        this.tituloEvento = tituloEvento;
    }

    public void setEnderecoEvento(String enderecoEvento) {
        this.enderecoEvento = enderecoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public void setDiasInicio(String diasInicio) {
        this.diasInicio = diasInicio;
    }

    public void setDiasTermino(String diasTermino) {
        this.diasTermino = diasTermino;
    }

    public void setHorarioEvento(String horarioEvento) {
        this.horarioEvento = horarioEvento;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public void setLinkIngresso(String linkIngresso) {
        this.linkIngresso = linkIngresso;
    }


}
