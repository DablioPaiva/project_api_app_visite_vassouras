package com.visitevassouras.crm.dto.restaurantes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestauranteResponse {

    private Long id;
    private String nome;
    private String logo;
    private String url;

    private Boolean ativo;

}
