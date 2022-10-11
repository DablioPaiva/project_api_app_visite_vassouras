package com.visitevassouras.crm.dto.hospedagem;

import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class HospedagemUpdateRequest {

    @NotEmpty(message = "Por favor, informe o nome do estabeleciomento de hospedagem")
    private String nomeHospedagem;

    @NotEmpty(message = "Por favor, informe a url da imagem")
    private String imagemHospedagem;

    @NotEmpty(message = "Por favor, informe a url do estabelecimento de hospedagem")
    private String urlHospedagem;

}
