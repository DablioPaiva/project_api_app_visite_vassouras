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
    private String nomeHospedagem;
    private String imagemHospedagem;
    private String urlHospedagem;

    public Hospedagem() {
        this.id = id;
        this.nomeHospedagem = nomeHospedagem;
        this.imagemHospedagem = imagemHospedagem;
        this.urlHospedagem = urlHospedagem;
    }

    public Long getId() {
        return id;
    }

    public String getNomeHospedagem() {
        return nomeHospedagem;
    }

    public String getImagemHospedagem() {
        return imagemHospedagem;
    }

    public String getUrlHospedagem() {
        return urlHospedagem;
    }

    public void setNomeHospedagem(String nomeHospedagem) {
        this.nomeHospedagem = nomeHospedagem;
    }

    public void setImagemHospedagem(String imagemHospedagem) {
        this.imagemHospedagem = imagemHospedagem;
    }

    public void setUrlHospedagem(String urlHospedagem) {
        this.urlHospedagem = urlHospedagem;
    }


}
