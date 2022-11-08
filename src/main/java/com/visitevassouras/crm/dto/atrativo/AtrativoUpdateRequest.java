package com.visitevassouras.crm.dto.atrativo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AtrativoUpdateRequest {

    @NotEmpty(message = "Por favor, informe o nome do Atrativo.")
    private String nome;

    @NotEmpty(message = "Por favor, informe o endereço do Atrativo.")
    private String endereco;

    @NotEmpty(message = "Por favor, informe uma descrição para o Atrativo.")
    private String descricao;

    @NotEmpty(message = "Por favor, informe os dias de funcionamento do Atrativo.")
    private String diasFuncionamento;

    @NotEmpty(message = "Por favor, informe o horário de funcionamento do Atrativo.")
    private String horarioFuncionamento;

    @NotEmpty(message = "Por favor, informe a rota do Atrativo.")
    private String rota;

    @NotEmpty(message = "Por favor, faça upload de uma imagem para o Atrativo.")
    private String imgPrincipal;

    @NotEmpty(message = "Por favor, faça upload de uma segunda imagem para o Atrativo.")
    private String imgSecundaria;
}
