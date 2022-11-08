package com.visitevassouras.crm.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Atrativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome; //private String nome
    private String endereco;
    private String descricao;
    private String diasFuncionamento;
    private String horarioFuncionamento;
    private String rota;
    private String imgPrincipal;
    private String imgSecundaria; // ver upload de arquivos ao invés de URL

    public Atrativo() {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.descricao = descricao;
        this.diasFuncionamento = diasFuncionamento;
        this.horarioFuncionamento = horarioFuncionamento;
        this.rota = rota;
        this.imgPrincipal = imgPrincipal;
        this.imgSecundaria = imgSecundaria;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getDescricao() {
        return descricao;
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

    public void setNomeAtrativo(String nome) {
        this.nome = nome;
    }

    public void setEnderecoAtrativo(String endereco) {
        this.endereco = endereco;
    }

    public void setDescricaoAtrativo(String descricao) {
        this.descricao = descricao;
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
