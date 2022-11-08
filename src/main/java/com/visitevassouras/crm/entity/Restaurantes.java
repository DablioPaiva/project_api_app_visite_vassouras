package com.visitevassouras.crm.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
public class Restaurantes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    private String logo;
    private String url;

    public Restaurantes() {
        this.id = id;
        this.nome = nome;
        this.logo = logo;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLogo() {
        return logo;
    }

    public String getUrl() {
        return url;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
