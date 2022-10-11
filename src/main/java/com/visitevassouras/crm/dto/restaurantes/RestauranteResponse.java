package com.visitevassouras.crm.dto.restaurantes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestauranteResponse {

    private Long id;
    private String nomeRestaurante;
    private String logoRestaurante;
    private String urlRestaurante;

}
