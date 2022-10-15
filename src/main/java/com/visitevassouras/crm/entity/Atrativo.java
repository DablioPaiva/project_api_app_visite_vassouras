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

}
