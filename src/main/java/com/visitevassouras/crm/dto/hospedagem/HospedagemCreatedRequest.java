package com.visitevassouras.crm.dto.hospedagem;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class HospedagemCreatedRequest {

    @NotEmpty(message = "Por favor, informe o nome do estabelecimento de hospedagem.")
    private String nome;

    @NotEmpty(message = "Por favor, faça upload de uma imagem para a hospedagem.")
    private String imagem;

    @NotEmpty(message = "Por favor, informe uma url para estabelecimento de hospedagem.")
    private String url;

}
