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
    private String titulo;
    private String endereco;
    private String descricao;
    private String diasInicio;
    private String diasTermino;
    private String horarioEvento;
    private Float valor;
    private String linkIngresso;
    private Boolean ativo;

    public Evento() {
        this.id = id;
        this.titulo = titulo;
        this.endereco = endereco;
        this.descricao = descricao;
        this.diasInicio = diasInicio;
        this.diasTermino = diasTermino;
        this.horarioEvento = horarioEvento;
        this.valor = valor;
        this.linkIngresso = linkIngresso;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getDescricao() {
        return descricao;
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

    public Boolean getAtivo(){return ativo;}

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public void setAtivo(Boolean ativo){this.ativo = ativo;}


}
