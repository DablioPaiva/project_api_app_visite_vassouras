package com.visitevassouras.crm.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
public class Atrativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeAtrativo; //private String nome
    private String enderecoAtrativo;
    private String descricaoAtrativo;
    private String diasFuncionamento;
    private String horarioFuncionamento;
    private String rota;
    private String imgPrincipal;
    private String imgSecundaria; // ver upload de arquivos ao invés de URL

    public Atrativo() {
        this.id = id;
        this.nomeAtrativo = nomeAtrativo;
        this.enderecoAtrativo = enderecoAtrativo;
        this.descricaoAtrativo = descricaoAtrativo;
        this.diasFuncionamento = diasFuncionamento;
        this.horarioFuncionamento = horarioFuncionamento;
        this.rota = rota;
        this.imgPrincipal = imgPrincipal;
        this.imgSecundaria = imgSecundaria;
    }

    public Long getId() {
        return id;
    }

    public String getNomeAtrativo() {
        return nomeAtrativo;
    }

    public String getEnderecoAtrativo() {
        return enderecoAtrativo;
    }

    public String getDescricaoAtrativo() {
        return descricaoAtrativo;
    }

    public String getDiasFuncionamento() {
        return diasFuncionamento;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public String getRota() {
        return rota;
    }

    public String getImgPrincipal() {
        return imgPrincipal;
    }

    public String getImgSecundaria() {
        return imgSecundaria;
    }

    public void setNomeAtrativo(String nomeAtrativo) {
        this.nomeAtrativo = nomeAtrativo;
    }

    public void setEnderecoAtrativo(String enderecoAtrativo) {
        this.enderecoAtrativo = enderecoAtrativo;
    }

    public void setDescricaoAtrativo(String descricaoAtrativo) {
        this.descricaoAtrativo = descricaoAtrativo;
    }

    public void setDiasFuncionamento(String diasFuncionamento) {
        this.diasFuncionamento = diasFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }

    public void setImgPrincipal(String imgPrincipal) {
        this.imgPrincipal = imgPrincipal;
    }

    public void setImgSecundaria(String imgSecundaria) {
        this.imgSecundaria = imgSecundaria;
    }

}
