package com.visitevassouras.crm.dto.restaurantes;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RestauranteUpdateRequest {

    @NotEmpty(message = "Por favor, informe o nome do restaurante.")
    private String nomeRestaurante;

    @NotEmpty(message = "Por favor, faça upload de uma imagem para a logo do restaurante.")
    private String logoRestaurante;

    @NotEmpty(message = "Por favor, informe uma url para o restaurante.")
    private String urlRestaurante;

}
