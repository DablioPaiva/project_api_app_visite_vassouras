package com.visitevassouras.crm.dto.hospedagem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class HospedagemResponse {
    private Long id;
    private String nome;
    private String imagem;
    private String url;
}
