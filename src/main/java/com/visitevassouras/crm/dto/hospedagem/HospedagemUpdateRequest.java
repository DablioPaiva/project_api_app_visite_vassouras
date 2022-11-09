package com.visitevassouras.crm.dto.hospedagem;

import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class HospedagemUpdateRequest {

    @NotEmpty(message = "Por favor, informe o nome do estabeleciomento de hospedagem")
    private String nome;

    @NotEmpty(message = "Por favor, informe a url da imagem")
    private String imagem;

    @NotEmpty(message = "Por favor, informe a url do estabelecimento de hospedagem")
    private String url;

    private Boolean ativo;

}
