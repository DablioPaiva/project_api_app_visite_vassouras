package com.visitevassouras.crm.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
public class Hospedagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    private String imagem;
    private String url;
    private Boolean ativo;

    public Hospedagem() {
        this.id = id;
        this.nome = nome;
        this.imagem = imagem;
        this.url = url;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getImagem() {
        return imagem;
    }

    public String getUrl() {
        return url;
    }

    public Boolean getAtivo(){return ativo;}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setAtivo(Boolean ativo){this.ativo = ativo;}

}
