package com.visitevassouras.crm.dto.atrativo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AtrativoResponse {

    private Long id;
    private String nomeAtrativo;
    private String enderecoAtrativo;
    private String descricaoAtrativo;
    private String diasFuncionamento;
    private String horarioFuncionamento;
    private String rota;
    private String imgPrincipal;
    private String imgSecundaria;

}
