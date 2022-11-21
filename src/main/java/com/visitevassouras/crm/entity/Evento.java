package com.visitevassouras.crm.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    private String local;
    private String dataInicio;
    private String dataTermino;
    private String horario;
    private String valor;
    private String linkIngresso;
    private Boolean ativo;

    public Evento() {
        this.id = id;
        this.titulo = titulo;
        this.local = local;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.horario = horario;
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

    public String getLocal() {
        return local;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public String getHorario() {
        return horario;
    }

    public String getValor() {
        return valor;
    }

    public String getLinkIngresso() {
        return linkIngresso;
    }

    public Boolean getAtivo(){return ativo;}

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setLocal(String endereco) {
        this.local = endereco;
    }

    public void setDataInicio(String diasInicio) {
        this.dataInicio = diasInicio;
    }

    public void setDataTermino(String diasTermino) {
        this.dataTermino = diasTermino;
    }

    public void setHorario(String horarioEvento) {
        this.horario = horarioEvento;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setLinkIngresso(String linkIngresso) {
        this.linkIngresso = linkIngresso;
    }

    public void setAtivo(Boolean ativo){this.ativo = ativo;}


}
