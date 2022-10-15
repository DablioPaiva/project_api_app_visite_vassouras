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
    private String nomeRestaurante;
    private String logoRestaurante;
    private String urlRestaurante;

    public Restaurantes() {
        this.id = id;
        this.nomeRestaurante = nomeRestaurante;
        this.logoRestaurante = logoRestaurante;
        this.urlRestaurante = urlRestaurante;
    }

    public Long getId() {
        return id;
    }

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public String getLogoRestaurante() {
        return logoRestaurante;
    }

    public String getUrlRestaurante() {
        return urlRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public void setLogoRestaurante(String logoRestaurante) {
        this.logoRestaurante = logoRestaurante;
    }

    public void setUrlRestaurante(String urlRestaurante) {
        this.urlRestaurante = urlRestaurante;
    }

}
